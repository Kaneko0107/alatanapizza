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

	private String familyName;

	private String firstName;

	private String familyNameKana;

	private String firstNameKana;

	private Map<String, Object> session;

	private ArrayList<String> errMsgList = new ArrayList<>();

	private String errorMessage;

	private String hideNewPassword;




	public String execute(){
		ChangePasswordConfirmAction Action=new ChangePasswordConfirmAction();
		UserUpdateConfirmDAO dao=new  UserUpdateConfirmDAO();
		 UserUpdateDTO dto=new UserUpdateDTO();
		String result=ERROR;



		dto=dao.getUserInfo(user_id);

		if(!(newPassword.equals("")) || !(conPassword.equals(""))){
			if(!(password.equals(dto.getPassword()))){
				setErrorMessage("【現在のパスワードが間違っています。】");
				errMsgList.add(errorMessage);
			}
			if(newPassword.length()<1 || newPassword.length()>16){
				setErrorMessage("【新しいパスワードは1～16文字の範囲内で入力してください。】");
				errMsgList.add(errorMessage);
			}
			if(!(newPassword.matches("^[a-zA-Z0-9]+$"))){
				setErrorMessage("【新しいパスワードは半角英数字で入力してください。】");
				errMsgList.add(errorMessage);
			}
			if(!(newPassword.equals(conPassword))){
				setErrorMessage("【新しいパスワードと確認用パスワードの値が一致していません。】");
				errMsgList.add(errorMessage);
			}
		}


			if(!(newEmail.equals(""))){
				if(!(password.equals(dto.getPassword()))){
					setErrorMessage("【現在のパスワードが間違っています。】");
					errMsgList.add(errorMessage);
				}
				if(newEmail.length()<14 || newEmail.length()>32){
					setErrorMessage("【メールアドレスは14～32文字の範囲内で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if((!newEmail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$"))){
					setErrorMessage("【正しいメールアドレスの形式で入力してください。】");
					errMsgList.add(errorMessage);
				}

				if(familyName.length()<1 || familyName.length()>16){
					setErrorMessage("【姓は1～16文字の範囲内で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if(firstName.length()<1 || firstName.length()>16){
					setErrorMessage("【名は1～16文字の範囲内で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if(familyNameKana.length()<1 || familyNameKana.length()>16){
					setErrorMessage("【せいは1～16文字の範囲内で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if(firstNameKana.length()<1 || firstNameKana.length()>16){
					setErrorMessage("【めいは1～16文字の範囲内で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if (!familyName.matches("^[a-zA-Z.ぁ-ん.一-龠]*$")) {
					setErrorMessage("【姓は半角英語、ひらがな、漢字で入力してください。】");
					errMsgList.add(errorMessage);
				}

				if (!firstName.matches("^[a-zA-Z.ぁ-ん.一-龠]*$")) {
					setErrorMessage("【名は半角英語、ひらがな、漢字で入力してください。】");
					errMsgList.add(errorMessage);
				}
				if (!familyNameKana.matches("^[ぁ-ん]+$")) {
					setErrorMessage("【せいはひらがなで入力してください。】");
					errMsgList.add(errorMessage);
				}

				if (!firstNameKana.matches("^[ぁ-ん]+$")) {
					setErrorMessage("【めいはひらがなで入力してください。】");
					errMsgList.add(errorMessage);
				}
			}

			if(newPassword.equals("")&&newEmail.equals("")&&familyName.equals("")&&firstName.equals("")&&familyNameKana.equals("")&&firstNameKana.equals("")){
				setErrorMessage("【変更内容が選ばれていません。】");
				errMsgList.add(errorMessage);
			}

			if(!(newPassword.equals("")) && !(conPassword.equals(""))){
				if(newPassword.length()<=1){
					hideNewPassword = Action.hideString(newPassword,0,0);
				}
				if(newPassword.length()==2){
					hideNewPassword = Action.hideString(newPassword,0,1);
				}
				if(newPassword.length()>=3){
					hideNewPassword = Action.hideString(newPassword,0,2);
				}
		}


			if(errorMessage==null){
				session.put("newPassword", newPassword);
				session.put("newEmail", newEmail);
				session.put("familyName", familyName);
				session.put("firstName", firstName);
				session.put("familyNameKana", familyNameKana);
				session.put("firstNameKana", firstNameKana);
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








	public String getHideNewPassword() {
		return hideNewPassword;
	}








	public void setHideNewPassword(String hideNewPassword) {
		this.hideNewPassword = hideNewPassword;
	}


}
