package com.wiatec.push_message.controller;

import com.wiatec.push_message.entities.ManagerInfo;
import com.wiatec.push_message.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
@Controller
public class ActionManager extends BaseAction {

    @Autowired
    private ManagerService managerService;
    private ManagerInfo managerInfo;
    private String loginStatus;

    public String login(){
        if(managerService.login(managerInfo , session)){
            return "success";
        }else{
            loginStatus = "login failure";
            return "failure";
        }
    }

    public String logout(){
        session.invalidate();
        return "logout";
    }

    public ManagerInfo getManagerInfo() {
        return managerInfo;
    }

    public void setManagerInfo(ManagerInfo managerInfo) {
        this.managerInfo = managerInfo;
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
