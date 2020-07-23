package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.model.User;
import com.bbz.model.UserModel;
import com.bbz.search.Params;
import com.bbz.search.UserSearchTerm;
import com.bbz.service.UserService;
import org.hibernate.annotations.Synchronize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
public class UserController extends BaseController {


    @Autowired
    private UserService userService;


    @GetMapping(value = "/getUser")
    public List<User> getUser() {
        List<User> uList = userService.findAll();
        return uList;
    }

    //查询User，单表，多条件
    @PostMapping(value = "/getUser/{pageNum}/{pageSize}")
    public List<User> getUser(@PathVariable("pageNum") Integer pageNum,
                              @PathVariable("pageSize") Integer pageSize,
                              @RequestBody User user) {
        List<User> uList = userService.findAll(pageNum, pageSize, user);
        return uList;
    }

    //查询User，多表，多条件
    @PostMapping(value = "/getUser2/{pageNum}/{pageSize}")
    public  List<User> getUser2(@PathVariable("pageNum") Integer pageNum,
                                           @PathVariable("pageSize") Integer pageSize,
                                           @RequestBody Params params) {
        List<User> uList = userService.findAll(pageNum, pageSize, params);
        return uList;
    }


//    @GetMapping(value = "/getUserById", produces = MediaType.APPLICATION_XML_VALUE)
//    public UserModel getUserById(Integer id) {
////        Map<String, Object> result = new HashMap<String, Object>();
////        result.put("data", );
//        return userService.findUserById(id);
//    }
//
//    @PostMapping("/save")
//    public Boolean save() {
//        UserModel model = new UserModel();
//        model.setId(5);
//        model.setAge(20);
//        model.setAddress("上海1");
//        model.setName("张三1");
//        userService.save(model);
//        return Boolean.TRUE;
//    }
//
//    @GetMapping("/getUserByNameList")
//    public Map<String, Object> getUserByNameList(UserSearchTerm term) {
//        Map<String, Object> result = new HashMap<String, Object>();
//        result.put("data", userService.findUserAll(term));
//        return result;
//    }
//
//    @GetMapping(value = "/getUserList")
//    public Map<String, Object> getUserList() {
//        Map<String, Object> result = new HashMap<>();
//        result.put("data", userService.findUserAll());
//        return result;
//    }


}
