package com.bbz.spring.demo;


import com.bbz.spring.formework.annotation.Controller;
import com.bbz.spring.formework.annotation.RequestMapping;
import com.bbz.spring.formework.annotation.Requestparam;
import com.bbz.spring.webmvc.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping
public class Action {


    @RequestMapping("/query")
    public ModelAndView query(@Requestparam(value = "id") String id, HttpServletRequest request, HttpServletResponse response) {
        return out(response, id);
    }


    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("index.html");
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
