package com.internousdev.alatanapizza.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.UserUpdateCompleteDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserUpdateCompleteAction extends ActionSupport implements SessionAware{
	private String user_id;
	private String newPassword;
	private String newEmail;
	public Map<String,Object>session;
	UserUpdateCompleteDAO dao=new UserUpdateCompleteDAO();

	public String execute() throws SQLException{
		String result=ERROR;

		if(newEmail==null){
			dao.userUpdatePassword(newPassword,user_id);
			session.remove("newPassword");
			result=SUCCESS;
			}else if(newPassword==null){
				dao.userUpdateEmail(newEmail, user_id);
				session.remove("newEmail");
				result=SUCCESS;
		}else{
			dao.userUpdateDouble(newPassword, newEmail, user_id);
			session.remove(newPassword);
			session.remove(newEmail);
			result=SUCCESS;
		}
		return result;
	}












	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getNewEmail() {
		return newEmail;
	}
	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}












	public Map<String, Object> getSession() {
		return session;
	}












	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
