package com.internousdev.alatanapizza.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class UserUpdateAction extends ActionSupport implements SessionAware{
	public Map<String ,Object> session;

	public String execute(){
		String result;

		if(session.containsKey("userId")){
			session.remove("newPassword");
			session.remove("newEmail");
			result = SUCCESS;
		}else{
			result = ERROR;
		}

		return result;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session = session;
	}

}
