package com.bbz.spring.demo;

import com.bbz.spring.formework.annotation.Controller;
import com.bbz.spring.formework.annotation.RequestMapping;
import com.bbz.spring.webmvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Test {

    @RequestMapping("/test")
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) {
        return out(response, "dds");
    }


    private ModelAndView out(HttpServletResponse response, String str) {
        try {
            response.getWriter().write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
