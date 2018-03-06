package com.internousdev.alatanapizza.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.LoginDAO;
import com.internousdev.alatanapizza.dto.LoginDTO;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;

//import com.internousdev.alatanapizza.dao.GoCartInfoDAO;
//import com.internousdev.alatanapizza.dto.GoCartInfoDTO;
//import com.internousdev.alatanapizza.dao.DestinationInfoDAO;
//import com.internousdev.alatanapizza.dto.DestinationInfoDTO;
//import com.internousdev.alatanapizza.dto.UserInfoDTO;
//import com.internousdev.alatanapizza.util.ErrorMessageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware ,ErrorMessageConstants {

	/**
	 * ログインに必要な情報
	 * 登録した内容
	 * →ID,PASSWORD
	 *
	 * カート情報を紐付けするために引き継ぐ仮ID
	 *
	 * カート内容
	 *
	 * エラーメッセージ
	 *
	 * くらい？
	 */
	/**
	 *ID
	 */
	private String loginUserId;
	/**
	 * pass
	 */
	private String loginPassword;
	/**
	 * 結果返すためのresult
	 */
	private String result;
	/**
	 * 入れ物Map session
	 */
	public Map<String,Object> session;
	/**
	 * new
	 */
	private LoginDAO loginDAO=new LoginDAO();
	private LoginDTO loginDTO=new LoginDTO();


	public String execute(){
		String result = ERROR;
		loginDTO=loginDAO.getLoginUserInfo(loginUserId,loginPassword);
		session.put("loginUser", loginDTO);

		if(((LoginDTO) session.get("loginUser")).getLoginFlg()){
			result = SUCCESS;
			session.put("login_user_id",loginDTO.getLoginId());

			return result;

		}
		return result;
	}
/**
 * カート内容の引継ぎ、仮IDと登録済みIDとのリンク機能、それに関するDBとの通信機能、
 * 未入力欄がある場合のエラーメッセージを追加したい
 * @return
 */
	public String getLoginUserId(){
		return loginUserId;
	}
	public void setLoginUserId(String loginUserId){
		this.loginUserId=loginUserId;
	}
	public String getLoginPassword(){
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword){
		this.loginPassword=loginPassword;
	}

	@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}


}
