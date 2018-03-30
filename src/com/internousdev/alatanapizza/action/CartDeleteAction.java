package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;


public class CartDeleteAction extends ActionSupport implements SessionAware {


	//カートID
	private int id;

	private Map<String, Object> session;

	//カート内の商品情報リスト
	private ArrayList<CartInfoDTO>cartList = new ArrayList<CartInfoDTO>();

	//カート内の金額
	public int total_price;

	private CartInfoDAO dao = new CartInfoDAO();

	//カート情報を削除するメソッド
	public String execute() throws SQLException {

		//"userId"を定義し、その中に"登録ユーザー"と"ゲストユーザー"を入れて処理する
		String userId;

		//"登録ユーザー"と"ゲストユーザー"のどちらでログインしているか確認し、定義した"userId"に代入する
		if((boolean)session.get("loginFlg")){
			userId =(String)session.get("userId");
		}
		else{
			userId =(String)session.get("tempUserId");
		}


		//削除する
		cartList = dao.showUserCartList(userId);
		dao.deleteSeparate(id);

		cartList = dao.showUserCartList(userId);
		total_price = calcTotalPrice(cartList);
		return SUCCESS;
	}

	//合計金額計算
	public int calcTotalPrice(ArrayList<CartInfoDTO>cartList){
		int totalPrice = 0;
		for(CartInfoDTO dto : cartList){
			totalPrice += dto.getPrice();
			System.out.println("合計" + totalPrice + "円");
		}
		return totalPrice;
	}


	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getId() {
		return Integer.valueOf(id).toString();
	}
	public void setId(String id) {
		this.id = Integer.parseInt(id);
	}

	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	public int getTotalPrice() {
		return total_price;
	}
	public void setTotalPrice(int total_price) {
		this.total_price = total_price;
	}

}
