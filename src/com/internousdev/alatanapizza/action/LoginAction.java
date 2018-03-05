package com.internousdev.alatanapizza.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.LoginDAO;
import com.internousdev.alatanapizza.dto.LoginDTO;

//import com.internousdev.alatanapizza.dao.GoCartInfoDAO;
//import com.internousdev.alatanapizza.dto.GoCartInfoDTO;
//import com.internousdev.alatanapizza.dao.DestinationInfoDAO;
//import com.internousdev.alatanapizza.dto.DestinationInfoDTO;
//import com.internousdev.alatanapizza.dto.UserInfoDTO;
//import com.internousdev.alatanapizza.util.ErrorMessageConstants;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * ユーザーID
	 */
	private String loginUserId;
	/**
	 * パスワード
	 */
	private String loginPassword;
	private String result;
	/**
	 * 便利なMap
	 */
	public Map<String,Object> session;
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
