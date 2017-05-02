package com.wiatec.push_message.controller;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by xuchengpeng on 27/04/2017.
 */
public class BaseAction implements ServletResponseAware ,ServletRequestAware{

    protected HttpSession session;
    protected HttpServletResponse response;
    protected PrintWriter out;
    protected String userName;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        session = httpServletRequest.getSession();
        userName = (String) session.getAttribute("userName");
    }

    @Override
    public void setServletResponse(HttpServletResponse httpServletResponse) {
        httpServletResponse.setContentType("text/html ; charset=utf-8");
        httpServletResponse.setCharacterEncoding("utf-8");
        response = httpServletResponse;
        try {
            out = httpServletResponse.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected boolean checkSession(){
        if(userName == null){
            try {
                response.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            return false;
        }else {
            return true;
        }
    }

}
