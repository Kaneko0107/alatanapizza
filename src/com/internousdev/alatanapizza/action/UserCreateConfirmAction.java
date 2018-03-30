package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.UserCreateConfirmDAO;
import com.opensymphony.xwork2.ActionSupport;


public class UserCreateConfirmAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	private String hidePassword;
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String mail;
	private String secretQuestion;
	private String secretAnswer;

	private Map<String, Object> session;

	private String result;

	private ArrayList<String> errMsgList=new ArrayList<>();
	private ArrayList<String> errMsgListId=new ArrayList<>();
	private ArrayList<String> errMsgListPass=new ArrayList<>();
	private ArrayList<String> errMsgListFamilyName=new ArrayList<>();
	private ArrayList<String> errMsgListFirstName=new ArrayList<>();
	private ArrayList<String> errMsgListFamilyNameKana=new ArrayList<>();
	private ArrayList<String> errMsgListFirstNameKana=new ArrayList<>();
	private ArrayList<String> errMsgListSex=new ArrayList<>();
	private ArrayList<String> errMsgListMail=new ArrayList<>();
	private ArrayList<String> errMsgListQuestion=new ArrayList<>();
	private ArrayList<String> errMsgListAnswer=new ArrayList<>();

	// エラーメッセージの種類
	private String errId1;
	private String errId2;
	private String errPass1;
	private String errPass2;
	private String errName1;
	private String errName2;
	private String errName3;
	private String errName4;
	private String errKana1;
	private String errKana2;
	private String errKana3;
	private String errKana4;
	private String errSex;
	private String errMail1;
	private String errMail2;
	private String errQuestion;
	private String errAnswer;




	public String execute() {

		    result=ERROR;

		// ※ID重複確認※  userCreate.jspでの入力欄が全て入力されていれば、(jspでも設定しているけど完全ではない為）
		if(!(loginUserId.equals(""))
				&& !(loginPassword.equals(""))
				&& !(familyName.equals(""))
				&& !(firstName.equals(""))
				&& !(familyNameKana.equals(""))
				&& !(firstNameKana.equals(""))
				&& !(sex.equals(""))
				&& !(mail.equals(""))
				&& !(secretQuestion.equals("選択してください"))
				&& !(secretAnswer.equals("")) ) {

			// データーベース情報取得し、
			UserCreateConfirmDAO dao=new UserCreateConfirmDAO();

			// UserCreateConfirmDAOの"getUserInfo"メソッドの結果true/falseを"checkId"に代入
			boolean checkId=dao.getUserInfo(loginUserId, loginPassword);

			// userCreateConfirm.jspで使うので、trueならsessionに。
			if(checkId){
				session.put("loginUserId", loginUserId);
				session.put("loginPassword", loginPassword);
				session.put("familyName", familyName);
				session.put("firstName", firstName);
				session.put("familyNameKana", familyNameKana);
				session.put("firstNameKana", firstNameKana);
				session.put("sex", sex);
				session.put("mail", mail);
				session.put("secretQuestion", secretQuestion);
				session.put("secretAnswer", secretAnswer) ;


				if(loginPassword.length()<=1){
					hidePassword = hideString(loginPassword,0,0);
				}
				if(loginPassword.length()==2){
					hidePassword = hideString(loginPassword,0,1);
				}
				if(loginPassword.length()>=3){
					hidePassword = hideString(loginPassword,0,2);
				}



			}else{
			errMsgList.add("【そのIDは使われています】");
			}

		 // userCreate.jspでの入力欄が全て入力されていないなら、"未入力の項目があります"
		}else{
			errMsgList.add("【未入力の項目があります】");
		}


	// エラーメッセージの種類

	// ユーザーID
	if (loginUserId.length() > 8) {
		errId1="【ユーザーIDは8文字以内で入力してください】";
		errMsgListId.add(errId1);
	}

	if (!loginUserId.matches("^[0-9a-zA-Z]+$")) {
		errId2="【ユーザーIDは半角英数字で入力してください】";
		errMsgListId.add(errId2);
	}


	// パスワード
	if (loginPassword.length() > 16) {
		errPass1="【パスワードは16文字以内で入力してください】";
		errMsgListPass.add(errPass1);
	}
	if (!loginPassword.matches("^[0-9a-zA-Z]+$")) {
		errPass2="【パスワードは半角英数字で入力してください】";
		errMsgListPass.add(errPass2);
	}


	// 名前
	if (familyName.length() > 16) {
		errName1="【姓は1文字以上16文字以下で入力してください】";
		errMsgListFamilyName.add(errName1);
	}

	if (firstName.length() > 16) {
		errName2="【名は1文字以上16文字以下で入力してください】";
		errMsgListFirstName.add(errName2);
	}

	if (!familyName.matches("^[a-zA-Z.ぁ-ん.一-龠]*$")) {
		errName3="【姓は半角英語、ひらがな、漢字で入力してください】";
		errMsgListFamilyName.add(errName3);
	}

	if (!firstName.matches("^[a-zA-Z.ぁ-ん.一-龠]*$")) {
		errName4="【名は半角英語、ひらがな、漢字で入力してください】";
		errMsgListFirstName.add(errName4);
	}

	if (familyNameKana.length() > 16) {
		errKana1="【ふりがな(姓)は1文字以上16文字以下で入力してください】";
		errMsgListFamilyNameKana.add(errKana1);
	}

	if (firstNameKana.length() > 16) {
		errKana2="【ふりがな(名)は1文字以上16文字以下で入力してください】";
		errMsgListFirstNameKana.add(errKana2);
	}

	if (!familyNameKana.matches("^[ぁ-ん]+$")) {
		errKana3="【ふりがな(姓)はひらがなで入力してください】";
		errMsgListFamilyNameKana.add(errKana3);
	}

	if (!firstNameKana.matches("^[ぁ-ん]+$")) {
		errKana4="【ふりがな(名)はひらがなで入力してください】";
		errMsgListFirstNameKana.add(errKana4);
	}


	// 性別
	if (sex!=null) {
		if (!sex.matches("^[0-1]+$")) {
			errSex="【性別を選択してください】";
			errMsgListSex.add(errSex);
		}
	}


	// メールアドレス
	if (mail.length()<14 || mail.length()>32) {
		errMail1="【メールアドレスは14文字以上32文字以下で入力してください】";
		errMsgListMail.add(errMail1);
	}

	if (!mail.matches("^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")) {
		errMail2="【メールアドレスは半角英数字と半角記号で入力してください】";
		errMsgListMail.add(errMail2);
	}


	// 質問
	if (!secretQuestion.matches("^[1-3]+$")) {
		errQuestion="【質問を選択してください】";
		errMsgListQuestion.add(errQuestion);
	}


	// 答え
	if (secretAnswer.length()>16) {
		errAnswer="【答えは1文字以上16文字以下で入力してください】";
		errMsgListAnswer.add(errAnswer);
	}

	// エラーメッセージリストが全て何もなかったら、成功
	if (errMsgList.isEmpty()
		 && errMsgListId.isEmpty()
		 && errMsgListPass.isEmpty()
		 && errMsgListFamilyName.isEmpty()
		 && errMsgListFirstName.isEmpty()
		 && errMsgListFamilyNameKana.isEmpty()
		 && errMsgListFirstNameKana.isEmpty()
		 && errMsgListSex.isEmpty()
		 && errMsgListMail.isEmpty()
		 && errMsgListQuestion.isEmpty()
		 && errMsgListAnswer.isEmpty()) {

		 result=SUCCESS;
	}
	return result;
   }


	//文字列の何文字かを'*'に変える
	public String hideString(String word,int a,int b){

		String hideWord;


		int wordLength;
		wordLength = word.length();

		hideWord=word.substring(a,b);//パスワードが12345の場合1,2まで。


		int i=0;
		while(i < wordLength - b){
			hideWord = hideWord + "*";//1,2の跡に繰り返し回数分※を表示
			i++;
		}
		return hideWord;
	}

	// ゲッターセッター
    public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId=loginUserId;
	}


	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword=loginPassword;
	}


	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}


	public String getFamilyNameKana() {
		return familyNameKana;
	}

	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana=familyNameKana;
	}


	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana=firstNameKana;
	}


	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex=sex;
	}


	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail=mail;
	}


	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion=secretQuestion;
	}


	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer=secretAnswer;
	}


	@Override
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	// ArrayList
	public ArrayList<String> getErrMsgList() {
		return errMsgList;
	}

	public void setErrMsgList(ArrayList<String> errMsgList) {
		this.errMsgList=errMsgList;
	}


	public ArrayList<String> getErrMsgListId() {
		return errMsgListId;
	}

	public void setErrMsgListId(ArrayList<String> errMsgListId) {
		this.errMsgListId=errMsgListId;
	}


	public ArrayList<String> getErrMsgListPass() {
		return errMsgListPass;
	}

	public void setErrMsgListPass(ArrayList<String> errMsgListPass) {
		this.errMsgListPass=errMsgListPass;
	}


	public ArrayList<String> getErrMsgListFamilyName() {
		return errMsgListFamilyName;
	}

	public void setErrMsgListFamilyName(ArrayList<String> errMsgListFamilyName) {
		this.errMsgListFamilyName=errMsgListFamilyName;
	}

	public ArrayList<String> getErrMsgListFirstName() {
		return errMsgListFirstName;
	}

	public void setErrMsgListFirstName(ArrayList<String> errMsgListFirstName) {
		this.errMsgListFirstName=errMsgListFirstName;
	}


	public ArrayList<String> getErrMsgListFamilyNameKana() {
		return errMsgListFamilyNameKana;
	}

	public void setErrMsgListFamilyNameKana(ArrayList<String> errMsgListFamilyNameKana) {
		this.errMsgListFamilyNameKana=errMsgListFamilyNameKana;
	}

	public ArrayList<String> getErrMsgListFirstNameKana() {
		return errMsgListFirstNameKana;
	}

	public void setErrMsgListFirstNameKana(ArrayList<String> errMsgListFirstNameKana) {
		this.errMsgListFirstNameKana=errMsgListFirstNameKana;
	}


	public ArrayList<String> getErrMsgListSex() {
		return errMsgListSex;
	}

	public void setErrMsgListSex(ArrayList<String> errMsgListSex) {
		this.errMsgListSex=errMsgListSex;
	}


	public ArrayList<String> getErrMsgListMail() {
		return errMsgListMail;
	}

	public void setErrMsgListMail(ArrayList<String> errMsgListMail) {
		this.errMsgListMail=errMsgListMail;
	}


	public ArrayList<String> getErrMsgListQuestion() {
		return errMsgListQuestion;
	}

	public void setErrMsgListQuestion(ArrayList<String> errMsgListQuestion) {
		this.errMsgListQuestion=errMsgListQuestion;
	}


	public ArrayList<String> getErrMsgListAnswer() {
		return errMsgListAnswer;
	}

	public void setErrMsgListAnswer(ArrayList<String> errMsgListAnswer) {
		this.errMsgListAnswer=errMsgListAnswer;
	}

	public String getHidePassword() {
		return hidePassword;
	}

	public void setHidePassword(String hidePassword) {
		this.hidePassword = hidePassword;
	}

}


