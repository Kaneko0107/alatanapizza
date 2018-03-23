package com.internousdev.alatanapizza.dto;

public class MyPageDTO {

	private String userId;
	private String password;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private boolean sex;
	private String email;
	private int secretQuestion;
	private String secretAnswer;


	//ゲッター・セッター
	//----------------------------------------
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	//----------------------------------------

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	//----------------------------------------

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	//----------------------------------------

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	//----------------------------------------

	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana = familyNameKana;
	}
	//----------------------------------------

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}
	//----------------------------------------

	public boolean isSex() {
		return sex;
	}

	public void setSex(boolean sex) {
		this.sex = sex;
	}
	//----------------------------------------

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	//----------------------------------------

	public int getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(int secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	//----------------------------------------

		public String getSecretAnswer() {
			return secretAnswer;
		}

		public void setSecretAnswer(String secretAnswer) {
			this.secretAnswer = secretAnswer;
		}
		//----------------------------------------



}
