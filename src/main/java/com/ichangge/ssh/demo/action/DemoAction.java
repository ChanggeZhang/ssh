package com.ichangge.ssh.demo.action;

import com.ichangge.ssh.demo.model.UserEntity;
import com.ichangge.ssh.demo.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class DemoAction extends ActionSupport {
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public String index(){
        return "index";
    }

    public String listUser(){
        List<UserEntity> userEntityList = userService.listUser();
        HttpServletRequest request = ServletActionContext.getRequest();
        request.setAttribute("userEntityList",userEntityList);
        return "listUser";
    }
}
