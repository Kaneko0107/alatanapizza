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
	private String familyName;

	private String firstName;

	private String familyNameKana;

	private String firstNameKana;
	public Map<String,Object>session;


	public String execute() throws SQLException{


		String errorUpdate="errorupdate";
		UserUpdateCompleteDAO dao=new UserUpdateCompleteDAO();
		String result=ERROR;

		if(session.containsKey("errorUpdate")){
			result=ERROR;
		}
		else if(newPassword.equals("")){
			dao.userUpdate2(newEmail,familyName,firstName,familyNameKana,firstNameKana,user_id);
			session.put("errorUpdate",errorUpdate);
			result=SUCCESS;
		}
		else{
			dao.userUpdate(newPassword, newEmail, familyName, firstName, familyNameKana, firstNameKana, user_id);
			session.put("errorUpdate",errorUpdate);
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












	public String getFamilyName() {
		return familyName;
	}












	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}












	public String getFirstName() {
		return firstName;
	}












	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}












	public String getFamilyNameKana() {
		return familyNameKana;
	}












	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}












	public String getFirstNameKana() {
		return firstNameKana;
	}












	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

}
