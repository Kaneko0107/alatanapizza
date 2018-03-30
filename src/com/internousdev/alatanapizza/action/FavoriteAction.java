package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.FavoriteDAO;
import com.internousdev.alatanapizza.dto.FavoriteDTO;
import com.opensymphony.xwork2.ActionSupport;


public class FavoriteAction extends ActionSupport implements SessionAware {

	private List<FavoriteDTO> favoriteList = new ArrayList<FavoriteDTO>();
	private Map<String, Object> session;
	private Collection<String> checkList;
	private int deleteFlg;
	private int deleteAllFlg;
	private int favoriteInsertFlg;
	private String message;
	private String product_id;
	private String userId;
	private String result;
	int count;
	int count2;
	boolean canInsertFlg;

	public String execute() throws SQLException {
		FavoriteDAO dao = new FavoriteDAO();

		canInsertFlg = true;
		count = 0;


		//削除ボタン押してない時点
		if (deleteFlg == 0) {
			if (session.containsKey("userId")) {
				userId = session.get("userId").toString();
				favoriteList = dao.getFavoriteInfo(userId);
		  }
		}

//ログイン後お気に入り登録した場合-------------------------------------------------------------------

		if (session.containsKey("userId")) {


			if (favoriteInsertFlg == 1) {
				favoriteList = dao.getFavoriteInfo(userId);
				for (int i = 0; favoriteList.size() > i; i++) {
					if (favoriteList.get(i).getProductId().equals(product_id)) {
						canInsertFlg = false;
						setMessage("【すでにリストにある商品です】");
						result = SUCCESS;
						return result;
					}
				}
				if (canInsertFlg) {
					userId = session.get("userId").toString();
					count2 = dao.insertFavorite(userId, product_id);
					favoriteInsertFlg = 0;

					favoriteList = dao.getFavoriteInfo(userId);
					result = SUCCESS;
				}

				if (count2 > 0) {
					result = SUCCESS;

				}
				else {
					result = ERROR;
				}
				return result;
			}

//選択削除ボタンが押された場合--------------------------------------------------------------------------------

			 if (deleteFlg == 1) {



					if(checkList==null) {
						userId = session.get("userId").toString();
						favoriteList = dao.getFavoriteInfo(userId);


						result = SUCCESS;
						return result;

					}

					for (String deleteId : checkList) {
						if(deleteId !="false") {

							count += dao.deleteFavoriteInfo(deleteId, session.get("userId").toString());

							deleteFlg = 0;
							userId = session.get("userId").toString();
							favoriteList = dao.getFavoriteInfo(userId);
							result = SUCCESS;
							setMessage(count+"件削除しました");

						}else if(deleteId=="false") {
							userId = session.get("userId").toString();
							favoriteList = dao.getFavoriteInfo(userId);


							result = SUCCESS;
							return result;
						}
					}
				}
			else if (deleteAllFlg==2) {
				dao.deleteAllFavoriteInfo(userId);
				favoriteList = dao.getFavoriteInfo(userId);
				deleteAllFlg=0;

				setMessage("全件削除しました");
				result = SUCCESS;
				return result;
			} else {
				result = SUCCESS;
				return result;
			}



		} //ログインしていない場合	("userId")が存在しない場合エラーページに移動させる-------------------------
		else	{
			result = "login";
		}
		return result;
		}

	//ゲッター・セッター
	//-----------------------------------------------------------
	public List<FavoriteDTO> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<FavoriteDTO> favoriteList) {
		this.favoriteList = favoriteList;
	}
	//-----------------------------------------------------------

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	//-----------------------------------------------------------

	public Collection<String> getCheckList() {
		return checkList;
	}

	public void setCheckList(Collection<String> checkList) {
		this.checkList = checkList;
	}
	//-----------------------------------------------------------

	public int getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
	//-----------------------------------------------------------

	public int getFavoriteInsertFlg() {
		return favoriteInsertFlg;
	}

	public void setFavoriteInsertFlg(int favoriteInsertFlg) {
		this.favoriteInsertFlg = favoriteInsertFlg;
	}
	//-----------------------------------------------------------

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	//-----------------------------------------------------------

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	//-----------------------------------------------------------

	public String getUserId() {
		return userId;
	}

	public void setResult(String result) {
		this.result = result;
	}
	//-----------------------------------------------------------

	public int getDeleteAllFlg() {
		return deleteAllFlg;
	}

	public void setDeleteAllFlg(int deleteAllFlg) {
		this.deleteAllFlg = deleteAllFlg;
	}
}
