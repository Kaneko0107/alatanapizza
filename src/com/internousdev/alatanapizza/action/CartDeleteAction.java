package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;



//カート内の商品を削除するクラス
public class CartDeleteAction extends ActionSupport implements SessionAware {


		//商品ID
		private int productId;

		//セッション情報
		private Map<String, Object> session;

		//カート内の商品情報リスト
		private ArrayList<CartInfoDTO>cartList = new ArrayList<CartInfoDTO>();

		//カート内の金額
		public int total_price = 0;

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
		int deletedProductCount = 0;
		for (CartInfoDTO dto: cartList) {
			if (dto.getProductId() == productId) {
				deletedProductCount += dto.getProductCount();
			}
		}
		dao.deleteSeparate(userId, productId);
		// 在庫を増やす為に、符号を反転させる
		dao.changeStockCount(-deletedProductCount, productId);

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


	//セッション
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	//商品ID
	public String getProductId() {
		return Integer.valueOf(productId).toString();
	}
	public void setProductId(String productId) {
		this.productId = Integer.parseInt(productId);
	}

	//カート情報
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	//合計金額
	public int getTotalPrice() {
		return total_price;
	}
	public void setTotalPrice(int total_price) {
		this.total_price = total_price;
	}

}
