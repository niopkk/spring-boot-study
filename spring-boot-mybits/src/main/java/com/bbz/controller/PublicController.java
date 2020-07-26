package com.bbz.controller;

import com.bbz.base.BaseController;
import com.bbz.base.ResultView;
import com.bbz.model.SysUser;
import com.bbz.service.SysUserDetailsService;
import com.bbz.view.RequestLoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class PublicController extends BaseController {

    @Value("${token.header}")
    private String tokenHeader;

    @Autowired
    private SysUserDetailsService sysUserDetailsService;


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResultView login(@RequestBody @Valid RequestLoginUser requestLoginUser, BindingResult bindingResult) {
        // 检查有没有输入用户名密码和格式对不对
        if (bindingResult.hasErrors()) {
            return errorResult("缺少参数或者参数格式不对");
        }

        SysUser sysUser = sysUserDetailsService.findSysUserByUserName(requestLoginUser.getUsername());
        ResultView ifLoginFail = checkAccount(requestLoginUser, sysUser);
        if (ifLoginFail != null) {
            return ifLoginFail;
        }
        return okResult("登陆成功", sysUserDetailsService.generateToken(sysUser));
    }

    private ResultView checkAccount(RequestLoginUser requestLoginUser, SysUser sysUser) {
        if (sysUser == null) {
            return errorResult("账号不存在");
        } else {
            if (sysUser.getStatus() == 1) {
                return errorResult("账号在黑名单中");
            }
            if (!sysUser.getPassWord().equals(requestLoginUser.getPassword())) {
                return errorResult("密码错误");
            }
        }
        return null;
    }

}
