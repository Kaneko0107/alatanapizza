package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class DestConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
//	private String postalCode;
//	private String addr11;
	private String userAddress;
	private String telNumber;
	private String email;
	private ArrayList<String> errorMessageList=new ArrayList<>();

	public Map<String,Object> session;

	public String execute(){
		String result= SUCCESS;

		//ログイン判定
		if(!(session.containsKey("userId"))){
			result="login";
			return result;
		}

		/**
		 * すべての欄が埋まっている場合
		 * データ格納
		 */
		InputChecker i=new InputChecker();

		if(!i.familyNameChk(familyName).equals("OK")){
			errorMessageList.add(i.familyNameChk(familyName));
			result =ERROR;
		}
		if(!i.firstNameChk(firstName).equals("OK")){
			errorMessageList.add(i.firstNameChk(firstName));
			result =ERROR;
		}
		if(!i.familyNameKanaChk(familyNameKana).equals("OK")){
			errorMessageList.add(i.familyNameKanaChk(familyNameKana));
			result =ERROR;
		}
		if(!i.firstNameKanaChk(firstNameKana).equals("OK")){
			errorMessageList.add(i.firstNameKanaChk(firstNameKana));
			result =ERROR;
		}
		if(!i.userAddressChk(userAddress).equals("OK")){
			errorMessageList.add(i.userAddressChk(userAddress));
			result =ERROR;
		}
		if(!i.telNumberChk(telNumber).equals("OK")){
			errorMessageList.add(i.telNumberChk(telNumber));
			result =ERROR;
		}
		if(!i.emailChk(email).equals("OK")){
			errorMessageList.add(i.emailChk(email));
			result =ERROR;
		}

		//入力情報保持
		if(!(familyName.equals(""))
				&&!(firstName.equals(""))
				&&!(familyNameKana.equals(""))
				&&!(firstNameKana.equals(""))
				&&!(email.equals(""))
				&&!(telNumber.equals(""))
				&&!(userAddress.equals(""))){
			session.put("familyName", familyName);
			session.put("firstName", firstName);
			session.put("familyNameKana", familyNameKana);
			session.put("firstNameKana", firstNameKana);
			session.put("email", email);
			session.put("telNumber", telNumber);
			session.put("userAddress", userAddress);
		}

		return result;
	}

	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

//	public String getZip11(){
//		return zip11;
//	}
//	public void setZip11(String zip11){
//		this.zip11=zip11;
//	}
//
//	public String getAddr11(){
//		return addr11;
//	}
//	public void setAddr11(String addr11){
//		this.addr11=addr11;
//	}

	public String getUserAddress(){
		return userAddress;
	}
	public void setUserAddress(String userAddress){
		this.userAddress=userAddress;
	}

	public String getTelNumber(){
		return telNumber;
	}
	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}

	//@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

	public ArrayList<String> getErrorMessageList(){
		return errorMessageList;
	}
	public void setErrorMessageList(ArrayList<String> errorMessageList){
		this.errorMessageList=errorMessageList;
	}

}
