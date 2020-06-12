package com.bbz.spring.formework.servlet;

import com.bbz.spring.formework.annotation.Controller;
import com.bbz.spring.formework.annotation.RequestMapping;
import com.bbz.spring.formework.context.ApplicationContext;
import com.bbz.spring.webmvc.*;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class DispatcherServlet extends HttpServlet {

    private final String LOCATION = "contextConfigLocation";

    private List<HandlerMapping> handlerMappings = new ArrayList<>();

    private Map<HandlerMapping, HandlerAdapter> handlerAdapters = new HashMap<>();

    private List<ViewResolver> viewResolvers = new ArrayList<>();

    private ApplicationContext context;

    @Override
    public void init(ServletConfig config) throws ServletException {

        context = new ApplicationContext(config.getInitParameter(LOCATION));

        initStrategies(context);
    }

    private void initStrategies(ApplicationContext context) {
        //初始化mvc 的所有组件

        //文件上传解析，如果请求类型是 multipart，将通过MultipartResolver 进行文件解析
        initMultipartResolver(context);

        //本地话解析
        initLocalResolver(context);

        //主题解析
        initThemeResolver(context);

        //GPHandler、Mapping 用来保存 Controller 中配置的 RequestMapping 和 Method 的对应关系
        ///通过 HandlerMapping 将请求映射到处理器
        initHandlerMappings(context);

        //HandlerAdapters用来动态匹配 Method 参数，包括类转换、动态赋值
        // 进行多类型的参数动态匹配
        initHandlerAdapters(context);

        //异常用initHandlerExceptionResolver 来解析
        initHandlerExceptionResolver(context);

        //直接将请求解析到试图名
        initRequestToViewNameTranslator(context);

        //自己解析一套模版语言
        initViewResolver(context);

        //flash 映射管理
        initFlashMapManager(context);

    }

    private void initFlashMapManager(ApplicationContext context) {
    }

    private void initViewResolver(ApplicationContext context) {
        //在页面中输入 http://localhost/first.html
        //解决页面名字和模板文件关联的问题
        String templateRoot = context.getConfig().getProperty("templateRoot");

        String templateRootPath = this.getClass().getClassLoader().getResource(templateRoot).getFile();
        File templateRootDir = new File(templateRootPath);

        for (File field : templateRootDir.listFiles()) {
            this.viewResolvers.add(new ViewResolver(templateRoot));
        }

    }

    private void initRequestToViewNameTranslator(ApplicationContext context) {
    }

    private void initHandlerExceptionResolver(ApplicationContext context) {
    }

    private void initHandlerAdapters(ApplicationContext context) {

        for (HandlerMapping handlerMapping : this.handlerMappings) {
            this.handlerAdapters.put(handlerMapping, new HandlerAdapter());
        }
    }

    private void initHandlerMappings(ApplicationContext context) {


        String[] beanNames = context.getBeanDefinitionNames();
        try {
            for (String beanName : beanNames) {
                //到了 MVC 层，对外提供的方法只有一个 getBean()方法
                // 返回的对象不是 BeanWrapper，怎么办?
                Object controller = context.getBean(beanName);
                Class<?> clazz = controller.getClass();
                if (!clazz.isAnnotationPresent(Controller.class)) {
                    continue;
                }
                String baseUrl = "";
                if (clazz.isAnnotationPresent(RequestMapping.class)) {
                    RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
                    baseUrl = requestMapping.value();
                }
                //扫描所有的方法名
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {

                    if (!method.isAnnotationPresent(RequestMapping.class)) {
                        continue;
                    }
                    RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
                    String regex = ("/" + baseUrl + requestMapping.value().replaceAll("\\*", "."))
                            .replaceAll("/+", "/");
                    Pattern pattern = Pattern.compile(regex);
                    this.handlerMappings.add(new HandlerMapping(controller, method, pattern));
                    log.info("Mapping" + regex + "," + method);

                }


            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void initThemeResolver(ApplicationContext context) {
    }

    private void initLocalResolver(ApplicationContext context) {
    }

    private void initMultipartResolver(ApplicationContext context) {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            doDispatch(req, resp);
        } catch (Exception e) {
            resp.getWriter().write("404");
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws Exception {


        HandlerMapping handler = getHandler(req);
        if (handler == null) {
            processDispatchResult(req, resp, new ModelAndView("404"));
            return;
        }

        HandlerAdapter ha = getHandlerAdapter(handler);

        ModelAndView modelAndView = ha.handler(req, resp, handler);

        processDispatchResult(req, resp, modelAndView);
    }

    private HandlerAdapter getHandlerAdapter(HandlerMapping handler) {

        if (this.handlerAdapters.isEmpty()) {
            return null;
        }
        HandlerAdapter ha = this.handlerAdapters.get(handler);
        if (ha.supports(handler)) {
            return ha;
        }
        return null;
    }

    private void processDispatchResult(HttpServletRequest req, HttpServletResponse resp, ModelAndView mv) throws Exception {
        if (null == mv) {
            return;
        }
        if (this.viewResolvers.isEmpty()) {
            return;
        }
        if (this.viewResolvers != null) {
            for (ViewResolver viewResolver : this.viewResolvers) {
                View view = viewResolver.resolveViewName(mv.getViewName(), null);
                if (view != null) {
                    view.render(mv.getModel(), req, resp);
                    return;
                }
            }
        }
    }

    private HandlerMapping getHandler(HttpServletRequest req) {
        if (this.handlerMappings.isEmpty()) {
            return null;
        }
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = url.replaceAll(contextPath, "").replaceAll("/+", "/");
        for (HandlerMapping handler : this.handlerMappings) {
            Matcher matcher = handler.getPattern().matcher(url);
            if (!matcher.matches()) {
                continue;
            }
            return handler;
        }
        return null;
    }
}
