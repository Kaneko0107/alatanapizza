package com.internousdev.alatanapizza.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	public String execute(){
        String userId=(String)session.get("saveId");
        session.clear();
        if(userId!=null){
        	session.put("saveId", userId);

        }

		return SUCCESS;
	}
	public void setSession(Map<String,Object> session) {
		this.session=session;
	}
	public Map<String, Object> getSession() {
		return session;
	}

}