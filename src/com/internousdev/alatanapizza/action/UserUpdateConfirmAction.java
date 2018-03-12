package com.internousdev.alatanapizza.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.UserUpdateConfirmDAO;
import com.internousdev.alatanapizza.dto.UserUpdateDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserUpdateConfirmAction extends ActionSupport implements SessionAware{
	private String user_id;

	private String password;

	private String newPassword;

	private String conPassword;

	private String newEmail;

	private Map<String, Object> session;

	private ArrayList<String> errMsgList = new ArrayList<>();

	private String errorMessage;

	 UserUpdateConfirmDAO dao=new  UserUpdateConfirmDAO();
	 UserUpdateDTO dto=new UserUpdateDTO();


	public String execute(){
		String result=ERROR;

		System.out.println(user_id);
		System.out.println(password);
		System.out.println(newPassword);
		System.out.println(conPassword);
		System.out.println(newEmail);


		dto=dao.getUserInfo(password,user_id);

		if(!(newPassword.equals("") || conPassword.equals(""))){
			if(!(password.equals(dto.getPassword()))){
				setErrorMessage("現在のパスワードが間違っています。");
				errMsgList.add(errorMessage);
			}
			if(newPassword.length()<1 || newPassword.length()>16){
				setErrorMessage("新しいパスワードは1～16文字の範囲内で入力してください。");
				errMsgList.add(errorMessage);
			}
			if(!(newPassword.matches("^[a-zA-Z0-9]+$"))){
				setErrorMessage("新しいパスワードは半角英数字で入力してください。");
				errMsgList.add(errorMessage);
			}
			if(newPassword.equals(dto.getPassword())){
				setErrorMessage("以前と同じパスワードは使用できません。");
				errMsgList.add(errorMessage);
			}
			if(!(newPassword.equals(conPassword))){
				setErrorMessage("新しいパスワードと確認用パスワードの値が一致していません。");
				errMsgList.add(errorMessage);
			}
			}

			if(!(newEmail.equals(""))){
				if(!(password.equals(dto.getPassword()))){
					setErrorMessage("現在のパスワードが間違っています。");
					errMsgList.add(errorMessage);
				}
				if(newEmail.length()<10 || newEmail.length()>32){
					setErrorMessage("メールアドレスは10～32文字の範囲内で入力してください。");
					errMsgList.add(errorMessage);
				}
				if((!newEmail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"))){
					setErrorMessage("正しいメールアドレスの形式で入力してください。");
					errMsgList.add(errorMessage);
				}
				if(newEmail.equals(dto.getEmail())){
					setErrorMessage("以前のメールアドレスは使用できません。");
					errMsgList.add(errorMessage);
				}
			}

			if(newPassword.equals("")&&newEmail.equals("")){
				setErrorMessage("パスワードとメールアドレスのどちらかは変更してください。");
				errMsgList.add(errorMessage);
			}

			if(errorMessage==null){
				session.put("newPassword", newPassword);
				session.put("newEmail", newEmail);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConPassword() {
		return conPassword;
	}

	public void setConPassword(String conPassword) {
		this.conPassword = conPassword;
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








	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}








	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList = errMsgList;
	}








	public String getErrorMessage() {
		return errorMessage;
	}








	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


}
