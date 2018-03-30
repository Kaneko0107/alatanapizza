package com.internousdev.alatanapizza.action;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class TopAction extends ActionSupport implements SessionAware{
	private Map<String,Object> session;
	Random rdm=new Random();

	public String execute(){
		try{
		if (!(session.containsKey("tempUserId"))) {
			session.put("loginFlg", false);
			Integer tempUserId = Integer.valueOf((int) (Math.random() * 1000000));
			session.put("tempUserId",tempUserId.toString());

		}else if(session == null){
			session.put("loginFlg", false);
			Integer tempUserId = Integer.valueOf((int) (Math.random() * 1000000));
			session.put("tempUserId",tempUserId.toString());
	}

		}catch(Exception e){
			throw new RuntimeException(e);
			}


return SUCCESS;
}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	}
