package com.internousdev.alatanapizza.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ChangePasswordConfirmDAO;
import com.internousdev.alatanapizza.dto.ChangePasswordDTO;
import com.opensymphony.xwork2.ActionSupport;


public class ChangePasswordConfirmAction extends ActionSupport implements SessionAware{
	private Map<String,Object>session;
	private String result;
	private String answer;
	private int question;
	private String newpass;
	private String errorUserid;
	private String errorpassword;
	private String userid;
	private String checkpass;
	private String hideNewPassword;
	private String hideUserId;
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
	System.out.println(newpass);
	System.out.println(checkpass);


	if(CPCdao.CheckAnswer(userid,question,answer)){
		result=SUCCESS;
		session.put("newpass",newpass);
		session.put("userid",userid);
		session.put("answer", answer);
	}else{
		result=ERROR;
		errorUserid="*ユーザーIDと答えが一致していません";
		session.put("errorUserid",errorUserid);
	}
	//値の確認出力
		System.out.println(userid);
		System.out.println(result);
		System.out.println(CPCdao.getPassword());








	if(!(newpass.equals(checkpass))){
		result=ERROR;
		setErrorpassword("*新しいパスワードと確認用パスワードが合致しません");
	}else if(newpass.equals(CPCdao.getPassword())){
		result=ERROR;
		setErrorpassword("*新しいパスワードは以前のパスワードと同様の値に設定できません");

		if(newpass.length() <= 1){
			hideUserId = hideString(userid,0,2);
			hideNewPassword = hideString(newpass,0,0);
		}else if(newpass.length() == 2){
			hideUserId = hideString(userid,0,2);
			hideNewPassword = hideString(newpass,0,1);
		}else{
			hideUserId = hideString(userid,0,2);
			hideNewPassword = hideString(newpass,0,2);
		}



	}
	return result;



}







public String getResult() {
	return result;
}



public void setResult(String result) {
	this.result = result;
}



public String getErrorUserid() {
	return errorUserid;
}



public void setErrorUserid(String errorUserid) {
	this.errorUserid = errorUserid;
}



public int getQuestion() {
	return question;
}



public void setQuestion(int question) {
	this.question = question;
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



public String getAnswer() {
	return answer;
}







public void setAnswer(String answer) {
	this.answer = answer;
}







public String getCheckpass() {
	return checkpass;
}



public void setCheckpass(String checkpass) {
	this.checkpass = checkpass;
}



public String getErrorpassword() {
	return errorpassword;
}



public void setErrorpassword(String errorpassword) {
	this.errorpassword = errorpassword;
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







public void setHideUserId(String hideUserId) {
	this.hideUserId = hideUserId;
}



}
