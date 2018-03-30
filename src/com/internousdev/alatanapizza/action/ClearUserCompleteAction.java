package com.internousdev.alatanapizza.action;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ClearUserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ClearUserCompleteAction extends ActionSupport implements SessionAware{
	public Map<String,Object> session;
	private String clearFlg;

	public String execute() throws SQLException{
		String result=ERROR;

		if(clearFlg==null || !(session.containsKey("loginFlg"))){
			result=ERROR;
		}
		else{
			String deleteUserId=session.get("userId").toString();
			ClearUserDAO ClearDAO=new ClearUserDAO();

			ClearDAO.deleteUserInfo(deleteUserId);
			ClearDAO.deleteCartInfo(deleteUserId);
			ClearDAO.deleteFavoriteInfo(deleteUserId);
			ClearDAO.deletePurchaseHistoryInfo(deleteUserId);
			ClearDAO.deleteDestinationInfo(deleteUserId);

			session.clear();
			Integer tempUserId = Integer.valueOf((int) (Math.random() * 1000000));
			session.put("tempUserId",tempUserId.toString());
			session.put("loginFlg", false);
			result=SUCCESS;
		}



		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getClearFlg() {
		return clearFlg;
	}

	public void setClearFlg(String clearFlg) {
		this.clearFlg = clearFlg;
	}
}
