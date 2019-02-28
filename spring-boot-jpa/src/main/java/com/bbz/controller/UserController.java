package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.model.UserModel;
import com.bbz.search.UserSearchTerm;
import com.bbz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{


    @Autowired
    private UserService userService;


    @GetMapping(value = "/getUserById",produces = MediaType.APPLICATION_XML_VALUE)
    public UserModel getUserById(Integer id) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("data", );
        return userService.findUserById(id);
    }

    @PostMapping("/save")
    public Boolean save() {
        UserModel model = new UserModel();
        model.setId(5);
        model.setAge(20);
        model.setAddress("上海1");
        model.setName("张三1");
        userService.save(model);
        return Boolean.TRUE;
    }

    @GetMapping("/getUserByNameList")
    public Map<String, Object> getUserByNameList(UserSearchTerm term) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("data", userService.findUserAll(term));
        return result;
    }

    @GetMapping(value = "/getUserList")
    public Map<String, Object> getUserList() {
        Map<String, Object> result = new HashMap<>();
        result.put("data", userService.findUserAll());
        return result;
    }





}
