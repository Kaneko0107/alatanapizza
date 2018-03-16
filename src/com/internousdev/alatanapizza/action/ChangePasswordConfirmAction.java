package com.internousdev.alatanapizza.action;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ChangePasswordConfirmDAO;
import com.internousdev.alatanapizza.dto.ChangePasswordDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ChangePasswordConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String result;
	private String	secret_answer;
	private int secret_question;
	private String newpass;
	private String userid;
	private String checkpass;
	private String hideNewPassword;
	private String hideUserId;
	private String errorMessage;
	private ArrayList<String> errMsgList = new ArrayList<>();
	private ChangePasswordConfirmDAO CPCdao=new ChangePasswordConfirmDAO();
	//DTOいらんかも
	private ChangePasswordDTO CPDTO=new ChangePasswordDTO();

	public String hideString(String word,int a,int b){

		//加工した文字を入れる型定義
		String hideWord;

		//文字の長さをセット
		int wordLength;
		wordLength = word.length();

		//aからbまでの文字列を抽出
		hideWord=word.substring(a,b);

		//抽出した文字列以外は*に差し替える
		//aの位置まで*に差し替え

		int i=0;
		while(i < wordLength - b){
			hideWord = hideWord + "*";
			i++;
		}
		return hideWord;
		}





public String execute(){
	String result=ERROR;
	CPCdao.CheckAnswer(userid,secret_question,secret_answer);

	if(newpass.equals("") || userid.equals("") || secret_answer.equals("")){
		setErrorMessage("未入力の項目があります。");
		errMsgList.add(errorMessage);
	}

	if(!(userid.equals("")) && !(newpass.equals("")) && !(checkpass.equals(""))){


		if(userid.length()<1 || userid.length()>8){
			setErrorMessage("ユーザーIDは1～8文字以内で入力してください。");
			errMsgList.add(errorMessage);
		}
		if(!(userid.matches("^[a-zA-Z0-9]+$"))){
			setErrorMessage("ユーザーIDは半角英数字で入力してください。");
			errMsgList.add(errorMessage);
		}
		else if(!(userid.equals(CPCdao.getUserid()))){
			setErrorMessage("ユーザーIDと答えが一致しません。");
			errMsgList.add(errorMessage);
		}





	if(newpass.length()<1 || newpass.length()>16){
		setErrorMessage("新しいパスワードは1～16文字の範囲内で入力してください。");
		errMsgList.add(errorMessage);
	}
	if(!(newpass.matches("^[a-zA-Z0-9]+$"))){
		setErrorMessage("新しいパスワードは半角英数字で入力してください。");
		errMsgList.add(errorMessage);
	}
	if(newpass.equals(CPCdao.getPassword())){
		setErrorMessage("以前と同じパスワードは使用できません。");
		errMsgList.add(errorMessage);
	}
	if(!(newpass.equals(checkpass))){
		setErrorMessage("新しいパスワードと確認用パスワードの値が一致していません。");
		errMsgList.add(errorMessage);
	}
	}

if(!(newpass.equals("")) && !(checkpass.equals(""))){
		if(newpass.length()<=1){
			hideUserId = hideString(userid,0,2);
			hideNewPassword = hideString(newpass,0,0);
			session.put("hideNewPassword",hideNewPassword);
		}
		if(newpass.length()==2){
			hideUserId = hideString(userid,0,2);
			hideNewPassword = hideString(newpass,0,1);
		}
		if(newpass.length()>=3){
			hideUserId = hideString(userid,0,2);
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







public String getResult() {
	return result;
}



public void setResult(String result) {
	this.result = result;
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






@Override
public void setSession(Map<String, Object>session) {
	this.session=session;

}







public ChangePasswordDTO getCPDTO() {
	return CPDTO;
}







public void setCPDTO(ChangePasswordDTO cPDTO) {
	CPDTO = cPDTO;
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
