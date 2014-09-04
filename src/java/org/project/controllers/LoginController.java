/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.project.controllers;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author CNA
 * The login Controller handles the login processing
 */
@ManagedBean
@RequestScoped
public class LoginController implements Serializable{
    
    //private variables
    private String loginName;
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   

    public String login(){
        
        if (loginName.equals("yusf") && password.equals("password"))
            return "welcome";
        else
            return null;
    }
    
}
