package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dao.DestinationDeleteDAO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DestinationDeleteAction extends ActionSupport implements SessionAware {

	// セッション
	private Map<String, Object> session;
	private ArrayList<DestinationDTO> destinationList = new ArrayList<DestinationDTO>();
	private String message; // 削除メッセージ
	private String deleteFlg; // 削除フラグ
	private DestinationDeleteDAO dao = new DestinationDeleteDAO();
	private DestinationDAO destinationdao=new DestinationDAO();
	private int id; // 個別削除id取得 DAOメソッドの戻り値
	private List<String> checkList;// checkBoxの値
	String userId;



	public String execute() throws SQLException{

		userId =(String)session.get("userId");
		String result=SUCCESS;


//
//		if (deleteFlg == null) {
//			setMessage("チェックを入れてください");
//			result=SUCCESS;
//		}


		if(deleteFlg.equals("1")) {
			delete();
			result = "DESTINATION";


		}else if(deleteFlg.equals("2")) {
			 deletePart();
			 destinationList=destinationdao.obtainingDestinationInfo(userId);
			 result=SUCCESS;

		}
return result;
	}

	// 全件削除メソッド----------------------------------------------------------
	public void delete() throws SQLException {

		String user_id = session.get("userId").toString();

		int res = dao.deleteAllDestination(user_id);

		if (res > 0) {
			destinationList = null;
			setMessage("注文履歴をすべて削除しました");
		} else if (res == 0) {
			setMessage("履歴の削除に失敗しました。");
		}

	}



	//個別削除メソッド-----------------------------------------

	public void deletePart() throws SQLException {
		if (checkList == null) {
			setMessage("削除できませんでした。");
		}
	int a=5;
	int res=dao.deletePartDestination(a);

	if(res>0){
		setMessage(res + "件削除しました");
	}else if (res == 0){
		setMessage("削除できませんでした");
	}
	}






	// deleteFlg
	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	// jspからIDもってくる
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// 削除メッセージ
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	// session
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	// checkBoxの値
	public List<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(List<String> checkList) {
		this.checkList = checkList;
	}

	public ArrayList<DestinationDTO> getDestinationList() {
		return destinationList;
	}

	public void setDestinationList(ArrayList<DestinationDTO> destinationList) {
		this.destinationList = destinationList;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
