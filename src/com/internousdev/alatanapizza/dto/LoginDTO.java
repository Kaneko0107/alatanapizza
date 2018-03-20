package com.internousdev.alatanapizza.dto;

import java.util.Date;

public class LoginDTO {

	private int id;
	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	//private String sex;
	private boolean sex; //0:男性 1:女性
	private String email;
//	private boolean status;
	private boolean logined;
	private boolean master;
	private Date register_date;
	private Date update_date;


	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id=id;
	}
	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId=userId;
	}
	public String getPassword(){
		return password;
	}
	public void setPassword(String password){
		this.password=password;
	}

	public boolean isMaster() {
		return master;
	}
	public void setMaster(boolean master) {
		this.master = master;
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
	/*
	public String getSex(){
		return sex;
	}
	public void setSex(String sex){
		this.sex=sex;
	}
	*/
	public boolean isSex(){
		return sex;
	}
	public void setSex(boolean sex){
		this.sex=sex;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public boolean isLogined(){
		return logined;
	}
	public void setLogined(boolean logined){
		this.logined=logined;
	}
	public Date getRegister_date(){
		return register_date;
	}
	public void setRegister_date(Date register_date){
		this.register_date=register_date;
	}
	public Date getUpdate_date(){
		return update_date;
	}
	public void setUpdate_date(Date update_date){
		this.update_date=update_date;
	}

	public void setUserName(String familyName,String firstName,String familyNameKana,String firstNameKana){
		this.familyName=familyName;
		this.firstName=firstName;
		this.familyNameKana=familyNameKana;
		this.firstNameKana=firstNameKana;
	}



	/*下記は試しうちしたもの
	private String loginId;
	private String loginPassword;
	private String userName;
	private boolean loginFlg=false;

	public String getLoginId(){
		return loginId;
	}
	public void setLoginId(String loginId){
		this.loginId=loginId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}
	public String getUserName(){
		return userName;
	}
	public void setUserName(String userName){
		this.userName=userName;
	}
	public boolean getLoginFlg(){
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg){
		this.loginFlg=loginFlg;
	}
	*/

}
