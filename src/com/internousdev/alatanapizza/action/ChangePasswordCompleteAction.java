package com.internousdev.alatanapizza.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ChangePasswordCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordCompleteAction extends ActionSupport implements SessionAware{
	private String newpass;
	private String userid;
	private String secret_answer;
	private Map<String,Object>session;
	private ChangePasswordCompleteDAO dao=new ChangePasswordCompleteDAO();
	public String execute() throws SQLException{
		String result=ERROR;
		String passerror="passerror";

		int count=dao.changeComplete(newpass,userid,secret_answer);
		if(session.containsKey("errorchangepass")){
			result=ERROR;


		}
		else if(count>0){
			session.put("errorchangepass",passerror);
			result=SUCCESS;
		}

return result;


	}





	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}


	public String getNewpass() {
		return newpass;
	}

	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}





	public String getSecret_answer() {
		return secret_answer;
	}





	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}


}
