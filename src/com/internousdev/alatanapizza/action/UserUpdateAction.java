package com.internousdev.alatanapizza.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.UserUpdateConfirmDAO;
import com.internousdev.alatanapizza.dto.UserUpdateDTO;
import com.opensymphony.xwork2.ActionSupport;


public class UserUpdateAction extends ActionSupport implements SessionAware{
	public Map<String ,Object> session;
	private String userId;
	UserUpdateConfirmDAO dao=new UserUpdateConfirmDAO();
	UserUpdateDTO dto=new UserUpdateDTO();
	public String execute(){

		String result;
		if(session.containsKey("userId")){

			userId = session.get("userId").toString();
			dto=dao.getUserInfo(userId);

			session.remove("newPassword");
			session.remove("newEmail");
			session.remove("errorUpdate");
			result = SUCCESS;
		}else{
			result = ERROR;
		}

		return result;
	}
	public Map<String,Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session = session;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public UserUpdateDTO getDto() {
		return dto;
	}
	public void setDto(UserUpdateDTO dto) {
		this.dto = dto;
	}

}
