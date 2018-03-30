package com.internousdev.alatanapizza.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ChangePasswordAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String userid;
	private String secret_answer;
	private int secret_question;





	public String execute(){
		session.remove("errorchangepass");
		return SUCCESS;
	}
	public Map<String, Object> getSession(){
		return session;
	}


	public void setSession(Map<String, Object>session) {
		this.session=session;

	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSecret_answer() {
		return secret_answer;
	}
	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}
	public int getSecret_question() {
		return secret_question;
	}
	public void setSecret_question(int secret_question) {
		this.secret_question = secret_question;
	}




}
