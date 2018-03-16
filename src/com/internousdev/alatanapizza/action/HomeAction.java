package com.internousdev.alatanapizza.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport {

	private Map<String,Object>session;

	public String execute(){

		if(!"saveId".equals("")){
			session.get("saveId");
		}
		return SUCCESS;
	}

	public Map<String,Object> getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
