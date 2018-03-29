package com.internousdev.alatanapizza.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ChangePasswordConfirmDAO;
import com.internousdev.alatanapizza.dto.ChangePasswordDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ChangePasswordConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	public String result;
	private String	secret_answer;
	private int secret_question;
	private String newpass;
	private String userid;
	private String checkpass;
	private String hideNewPassword;
	private String hideUserId;
	private String errorMessage;
	private ArrayList<String> errMsgList = new ArrayList<>();

	public String hideString(String word,int a,int b){

		String hideWord;


		int wordLength;
		wordLength = word.length();


		hideWord=word.substring(a,b);


		int i=0;
		while(i < wordLength - b){
			hideWord = hideWord + "*";
			i++;
		}
		return hideWord;
		}





public String execute(){
	ChangePasswordConfirmDAO CPCdao=new ChangePasswordConfirmDAO();
	ChangePasswordDTO CPCdto=new ChangePasswordDTO();
	CPCdto=CPCdao.CheckAnswer(userid);

	String result=ERROR;


	if(userid.equals("") || secret_answer.equals("")){
		setErrorMessage("【未入力の項目があります】");
		errMsgList.add(errorMessage);
	}

	if(checkpass.equals("")||newpass.equals("")){
		setErrorMessage("【パスワードを入力してください】");
		errMsgList.add(errorMessage);
	}


	if(!(userid.equals("")) && !(newpass.equals("")) && !(checkpass.equals(""))){


		if(userid.length()<1 || userid.length()>8){
			setErrorMessage("【ユーザーIDは1～8文字以内で入力してください】");
			errMsgList.add(errorMessage);
		}
		if(!(userid.matches("^[a-zA-Z0-9]+$"))){
			setErrorMessage("【ユーザーIDは半角英数字で入力してください】");
			errMsgList.add(errorMessage);
		}

if(CPCdto==null){

			setErrorMessage("【ユーザーIDが間違っています】");
			errMsgList.add(errorMessage);

}
else{
	if(newpass.equals(CPCdto.getPassword())){
		setErrorMessage("【以前と同じパスワードは使用できません】");
		errMsgList.add(errorMessage);
	}
	if(secret_question!=CPCdto.getQuestion()){
		setErrorMessage("【質問内容が間違っています】");
		errMsgList.add(errorMessage);
	}
	if(!(secret_answer.equals(CPCdto.getAnswer()))){
		setErrorMessage("【質問に対する答えが間違っています】");
		errMsgList.add(errorMessage);
	}

}




	if(newpass.length()<1 || newpass.length()>16){
		setErrorMessage("【新しいパスワードは1～16文字の範囲内で入力してください】");
		errMsgList.add(errorMessage);
	}
	if(!(newpass.matches("^[a-zA-Z0-9]+$"))){
		setErrorMessage("【新しいパスワードは半角英数字で入力してください】");
		errMsgList.add(errorMessage);
	}



	if(!(newpass.equals(checkpass))){
		setErrorMessage("【新しいパスワードと確認用パスワードの値が一致していません】");
		errMsgList.add(errorMessage);
	}


	}

if(!(newpass.equals("")) && !(checkpass.equals(""))){
		if(newpass.length()<=1){
			hideNewPassword = hideString(newpass,0,0);
			session.put("hideNewPassword",hideNewPassword);
		}
		if(newpass.length()==2){
			hideNewPassword = hideString(newpass,0,1);
		}
		if(newpass.length()>=3){
			hideNewPassword = hideString(newpass,0,2);
			session.put("hideNewPassword",hideNewPassword);
		}
}

	if(errorMessage==null){
	result=SUCCESS;

	session.put("newpass",newpass);
	session.put("userid",userid);
	session.put("answer", secret_answer);
	session.put("secret_question", secret_question);
}



	return result;



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





public int getSecret_question() {
	return secret_question;
}





public void setSecret_question(int secret_question) {
	this.secret_question = secret_question;
}





public String getNewpass() {
	return newpass;
}





public void setNewpass(String newpass) {
	this.newpass = newpass;
}





public String getUserid() {
	return userid;
}





public void setUserid(String userid) {
	this.userid = userid;
}





public String getCheckpass() {
	return checkpass;
}





public void setCheckpass(String checkpass) {
	this.checkpass = checkpass;
}





public String getHideNewPassword() {
	return hideNewPassword;
}





public void setHideNewPassword(String hideNewPassword) {
	this.hideNewPassword = hideNewPassword;
}





public String getHideUserId() {
	return hideUserId;
}





public void setHideUserId(String hideUserId) {
	this.hideUserId = hideUserId;
}





public String getErrorMessage() {
	return errorMessage;
}





public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
}





public ArrayList<String> getErrMsgList() {
	return errMsgList;
}





public void setErrMsgList(ArrayList<String> errMsgList) {
	this.errMsgList = errMsgList;
}










}
