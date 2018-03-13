package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 打ち込んだ情報をMapに格納したい
 * @author internousdev
 *
 *			<s:form action="CompleteDestAction">
				<span>姓</span>
				<s:textfield name="familyName"/>
				<span>名</span>
				<s:textfield name="firstName"/>
				<span>姓ふりがな</span>
				<s:textfield name="familyNameKana"/>
				<span>名ふりがな</span>
				<s:textfield name="filstNameKana"/>
				<span>メールアドレス</span>
				<s:textfield name="Email"/>
				<span>電話番号</span>
				<s:textfield name="TelNumber"/>
				<span>郵便番号</span>
				<s:textfield name="PostalCode"/>
				<span>住所</span>
				<s:textfield name="UserAddress"/>
				<s:submit value="登録情報確認画面へ"/>
 *
 *
 * 適切でない文字が入力された際の対応をどうするか？
 *
 */

public class DestConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private boolean sex;
	private String userAddress;
	private String telNumber;
	private String email;
	private ArrayList<String> errorMessageList=new ArrayList<>();

	public Map<String,Object> session;

	public String execute(){
		String result= SUCCESS;

		//ログイン判定
		if(!(session.containsKey("userId"))){
			System.out.println("ログアウトしています");
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
		//if(!i.sexChk(sex).equals("OK")){
		//	errorMessageList.add(i.sexChk(sex));
		//	result =ERROR;
		//}
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
		return result;
	}



		/*if(!(familyName.equals(""))
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

		}else{
			**
			 * 空欄がある場合のエラーメッセージ
			 *
			setErrorMessage("未入力の項目があります。");
			result=ERROR;
		}
		return result;
*/

	public String getUserFamilyName(){
		return familyName;
	}
	public void setUserFamilyName(String familyName){
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
	public boolean isSex(){
		return sex;
	}
	public void setSex(boolean sex){
		this.sex=sex;
	}
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
