package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.model.SysUser;
import com.bbz.util.Lists;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SysMenuController extends BaseController {


    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ResponseBody
    public ResultView getMenuList() {
        List<Menu> menus = Lists.of(
                new Menu(0, "用户管理", Lists.of(new Menu(5, "用户列表", "/users"))),
                new Menu(1, "权限管理", Lists.of(new Menu(6, "角色列表", "/roles")
                        , new Menu(7, "权限列表", "/permissions"))),
                new Menu(2, "商品管理", Lists.of(new Menu(8, "商品列表", "/product1")
                        , new Menu(9, "商品列表1", "/sys/products"))),
                new Menu(3, "订单管理", Lists.of(new Menu(10, "订单列表", "/orders"))),
                new Menu(4, "数据统计", Lists.of(new Menu(11, "数据列表", "/datas"))));
        return okResult("查询成功", menus);
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public ResultView getUserList() {
        SysUser user = SysUser.builder().account("1111")
                .passWord("22222")
                .name("张三")
                .status(1)
                .createTime(System.currentTimeMillis())
                .loginTime(System.currentTimeMillis())
                .modifyTime(System.currentTimeMillis())
                .id(1).build();
        return okResult("查询成功", Lists.of(user, user, user));
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResultView getUser() {
        SysUser user = SysUser.builder().account("1111")
                .passWord("22222")
                .name("张三")
                .status(1)
                .createTime(System.currentTimeMillis())
                .loginTime(System.currentTimeMillis())
                .modifyTime(System.currentTimeMillis())
                .id(1).build();
        return okResult("查询成功", user);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultView deleteUser(@RequestParam(value = "id", required = false) String id) {
        return okResult("删除成功");
    }


    @RequestMapping(value = "/user/store", method = RequestMethod.POST)
    @ResponseBody
    public ResultView store(@RequestBody SysUser sysUser) {

        return okResult("保存成功！");
    }

    @Data
    public static class Menu {
        public Menu(int id, String name, String path) {
            this.id = id;
            this.name = name;
            this.path = path;
        }

        public Menu(int id, String name, List<Menu> children) {
            this.id = id;
            this.name = name;
            this.children = children;

        }

        private int id;
        private String name;
        private String path;
        private List<Menu> children;
    }


}
