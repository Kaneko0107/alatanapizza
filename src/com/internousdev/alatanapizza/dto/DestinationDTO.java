package com.internousdev.alatanapizza.dto;

import java.util.Date;

public class DestinationDTO {

	//宛先情報
	private int id;
	private String userId;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String zip11;
	private String addr11;
	private String telNumber;
	private String email;
	private Date registDate;
	private Date updateDate;

	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id =id;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId =userId;
	}

	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName =familyName;
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
		this.familyNameKana =familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana =firstNameKana;
	}

//郵便番号のコードを使用する際のコード
	public String getZip11(){
		return zip11;
	}
	public void setZip11(String zip11){
		this.zip11 =zip11;
	}

	public String getAddr11(){
		return addr11;
	}
	public void setAddr11(String addr11){
		this.addr11 =addr11;
	}

	public String getTelNumber(){
		return telNumber;
	}
	public void setTelNumber(String telNumber){
		this.telNumber =telNumber;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email =email;
	}

	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate =updateDate;
	}

	public Date getRegistDate(){
		return registDate;
	}
	public void setRegistDate(Date registDate){
		this.registDate =registDate;
	}

}
