package com.internousdev.alatanapizza.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.MyPageDAO;
import com.internousdev.alatanapizza.dto.MyPageDTO;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware, ErrorMessageConstants {

	/**
	 * 1.ログイン状態か確認(sessionにuserIdがあればログイン状態)
	 * 2.未ログインならerrorとし、ホーム画面に返す
	 * 3.ログイン状態ならユーザー登録情報を取得し、successマイページへ遷移
	 * @param userId
	 */

	// userId格納
	private String userId;
	// session情報格納
	private Map<String, Object> session;
	// ログイン情報格納DTO
	private ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

	// エラーメッセージ
	private String message;

	public String execute() {




		/*---------------------------------------------------------
		 セッション情報取得
		---------------------------------------------------------*/
		if (!(session.containsKey("userId"))) {

			setMessage("このサービスをご利用になるにはログインしてください。");

		}
		String result = ERROR;



		/*---------------------------------------------------------
		    ユーザー情報取得
		    @param userId
		 ---------------------------------------------------------*/
		if (session.containsKey("userId")) {
			userId = session.get("userId").toString();
			MyPageDAO dao = new MyPageDAO();

	    /*---------------------------------------------------------
	     	sessionからuserIDをキーにして情報を受け取り、
	     	SQLでIDと一致する項目をselectし、ユーザー情報を
	     	変数MyPageDTOにセットし、mypagelist配列に代入。
			リストにデータが入っていたらSUCCESSとなりマイページに遷移。
			+
			パスワードの暗号化処理
		---------------------------------------------------------*/
			myPageList = dao.getMyPageUserInfo(userId);

			String hideNewPassword;
			hideNewPassword = myPageList.get(0).getPassword();

			if(hideNewPassword.length()<=1){

				hideNewPassword = hideString(hideNewPassword,0,0);
				myPageList.get(0).setPassword(hideNewPassword);
			}
			if(hideNewPassword.length()==2){

				hideNewPassword = hideString(hideNewPassword,0,1);
				myPageList.get(0).setPassword(hideNewPassword);
			}
			if(hideNewPassword.length()>=3){

				hideNewPassword = hideString(hideNewPassword,0,2);
				myPageList.get(0).setPassword(hideNewPassword);
			}


			if (myPageList.size() > 0) {
				result = SUCCESS;
			}

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


	//ゲッター・セッター
	//----------------------------------------------

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	//----------------------------------------------

	public ArrayList<MyPageDTO> getMyPageList() {
		return myPageList;
	}


	public void setMyPageList(ArrayList<MyPageDTO> myPageList) {
		this.myPageList = myPageList;
	}

	//----------------------------------------------

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	//----------------------------------------------


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	//----------------------------------------------

}