package com.bbz.v2.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

public class DispatcherServlet extends HttpServlet {


    private Map<String, Object> mapping = new HashMap<>();

    private Properties configContext = new Properties();

    private List<String> classNames=new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            doDispatch(req, resp);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws IOException, InvocationTargetException, IllegalAccessException {
        String url = req.getRequestURI();
        String contextPath = req.getContextPath();
        url = contextPath.replace(contextPath, "").replaceAll("/+", "/");
        if (!this.mapping.containsKey(url)) {
            resp.getWriter().write("404 not found");
            return;
        }
        Method method = (Method) this.mapping.get(url);
        Map<String, String[]> parameter = req.getParameterMap();
        method.invoke(this.mapping.get(method.getDeclaringClass().getName()), new Object[]{req, resp, parameter.get("name")[0]});
    }


    @Override
    public void init(ServletConfig config) throws ServletException {
//        InputStream is = null;
//        try {
//            Properties configContext = new Properties();
//            is = this.getClass().getClassLoader().getResourceAsStream(config.getInitParameter("contextConfigLocation"));
//            String scanPackage = configContext.getProperty("scanPackage");
//            configContext.load(is);
//            doScanner(scanPackage);
//            for (String className : mapping.keySet()) {
//                if (!className.contains(".")) {
//                    continue;
//                }
//                Class<?> clazz = Class.forName(className);
//                if (clazz.isAnnotationPresent(Controller.class)) {
//                    mapping.put(className, clazz.newInstance());
//
//                    String baseUrl = "";
//                    if (clazz.isAnnotationPresent(RequestMapping.class)) {
//                        RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
//                        baseUrl = requestMapping.value();
//                    }
//                    Method[] methods = clazz.getMethods();
//                    for (Method method : methods) {
//                        if (!method.isAnnotationPresent(RequestMapping.class)) {
//                            RequestMapping requestMapping = method.getAnnotation(RequestMapping.class);
//                            String url = (baseUrl + "/" + requestMapping.value().replaceAll("/+", ""));
//                            mapping.put(url, method);
//                            System.out.println("Mapped:" + url + "," + method);
//                        }
//                    }
//                } else if (clazz.isAnnotationPresent(Service.class)) {
//                    Service service = clazz.getAnnotation(Service.class);
//                    String beanName = service.value();
//                    if (Strings.equals("", beanName)) {
//                        beanName = clazz.getName();
//                    }
//                    Object instance = clazz.newInstance();
//                    mapping.put(beanName, instance);
//                    for (Class<?> i : clazz.getInterfaces()) {
//                        mapping.put(i.getName(), instance);
//                    }
//                } else {
//                    continue;
//                }
//            }
//            for (Object object : mapping.values()) {
//                if (null == object) {
//                    continue;
//                }
//                Class<?> clazz = object.getClass();
//                if (clazz.isAnnotationPresent(Controller.class)) {
//                    Field[] fields = clazz.getFields();
//                    for (Field field : fields) {
//                        if (!field.isAnnotationPresent(Autowired.class)) {
//                            continue;
//                        }
//                        Autowired autowired = field.getAnnotation(Autowired.class);
//                        String beanName = autowired.value();
//                        if (Strings.equals("", beanName)) {
//                            beanName = field.getType().getName();
//                        }
//                        field.setAccessible(true);
//                        field.set(mapping.get(clazz.getName()), mapping.get(beanName));
//                    }
//                }
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (null != is) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
        doloadConfig(config.getInitParameter("contextConfigLocation"));

        doScanner(configContext.getProperty("scanPackage"));

        doInstance();
    }

    private void doInstance() {

    }

    private void doloadConfig(String contextConfigLocation) {
        InputStream is = null;
        is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            configContext.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void doScanner(String scanPackage) {
        URL url = this.getClass().getClassLoader().getResource("/" + scanPackage.replaceAll("\\.", "/"));
        File classDir = new File(url.getFile());
        for (File file : classDir.listFiles()) {
            if (file.isDirectory()) {
                doScanner(scanPackage + "." + file.getName());
            } else {
                if (file.getName().endsWith(".class")) {
                    continue;
                }
                String clazzName = scanPackage + "." + file.getName().replace(".class", "");
                mapping.put(clazzName, null);
            }
        }

    }
}
