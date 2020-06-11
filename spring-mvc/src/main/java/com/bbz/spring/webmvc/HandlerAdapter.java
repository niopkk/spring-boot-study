package com.bbz.spring.webmvc;

import com.bbz.spring.formework.annotation.Requestparam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HandlerAdapter {

    public boolean supports(Object handler) {
        return handler instanceof HandlerMapping;
    }

    public ModelAndView handler(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {


        HandlerMapping handlerMapping = (HandlerMapping) handler;
        Map<String, Integer> paramMapping = new HashMap<>();
        Annotation[][] pa = handlerMapping.getMethod().getParameterAnnotations();
        for (int i = 0; i < pa.length; i++) {
            for (Annotation a : pa[i]) {
                if (a instanceof Requestparam) {
                    String paramName = ((Requestparam) a).value();
                    if (!"".equals(paramName.trim())) {
                        paramMapping.put(paramName, i);
                    }
                }
            }
        }
        //根据用户请求的参数信息，跟 Method 中的参数信息进行动态匹配 //resp 传进来的目的只有一个:将其赋值给方法参数，仅此而己
        //只有当用户传过来的 ModelAndView 为空的时候，才会新建 一个默认的
        //1. 要准备好这个方法的形参列表
        //方法重载时形参的决定因素 : 参数的个数、参数的类型、参数)I民序、方法 的名字 //只处理 Request 和 Response
        Class<?>[] parameterTypes = ((HandlerMapping) handler).getMethod().getParameterTypes();
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> type = parameterTypes[i];
            if (type == HttpServletRequest.class || type == HttpServletResponse.class) {
                paramMapping.put(type.getName(), i);
            }
        }

        //2. 得到自定义命名参数所在的位置
        //用户通过 URL传过来的参数列表
        Map<String, String[]> reqParameterMap = req.getParameterMap();

        //3. 构造实参列表
        Object[] paramValues = new Object[parameterTypes.length];

        for (Map.Entry<String, String[]> param : reqParameterMap.entrySet()) {
            String value = Arrays.toString(param.getValue()).replaceAll("\\[|\\]]", "").replaceAll("\\s", "");
            if (!paramMapping.containsKey(param.getKey())) {
                continue;
            }
            int index = paramMapping.get(param.getKey());

            paramValues[index] = caseStringValue(value, parameterTypes[index]);
        }
        if (paramMapping.containsKey(HttpServletRequest.class.getName())) {
            int reqIndex = paramMapping.get(HttpServletRequest.class.getName());
            paramValues[reqIndex] = req;
        }
        if (paramMapping.containsKey(HttpServletResponse.class.getName())) {
            int respIndex = paramMapping.get(HttpServletResponse.class.getName());
            paramValues[respIndex] = resp;
        }

        //4. 从 handler、 中取 出 Controller、 Method， 然后利用反射机制进行调用
        Object result = handlerMapping.getMethod().invoke(handlerMapping.getController(), paramValues);
        if (null == result) {
            return null;
        }
        boolean isModelAndView = handlerMapping.getMethod().getReturnType() == ModelAndView.class;
        if (isModelAndView){
            return (ModelAndView)result;
        }
        return null;
    }

    private Object caseStringValue(String value, Class<?> clazz) {

        if (clazz == String.class) {
            return value;
        } else if (clazz == Integer.class) {
            return Integer.valueOf(value);
        } else if (clazz == int.class) {
            return Integer.valueOf(value).intValue();
        }
        return null;
    }
}
