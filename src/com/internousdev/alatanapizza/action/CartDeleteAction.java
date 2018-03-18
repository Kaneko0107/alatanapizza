package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

//カート内削除アクション　担当：上原→かねごんにバトンタッチします！ごめん→実装完了しました！（金子）
//①ログインしている場合
//		（１）全削除メソッド
//		（２）チェックしたものだけを削除するメソッド
//②ログインしていない場合（ゲストユーザー）
//		（３）全削除メソッド
//		（４）チェックしたものだけを削除するメソッド

//※４つのメソッドを作るのがめんどいと思ったが、これしか方法はない。
//なお、ここでもログインしているか否かは、しっかりと判別する必要あり。


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
		// 在庫を増やしたいから符号を反転させる。
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

//
//		if (!(session.containsKey("userId"))) {
//			deletedao.deleteSeparate(session.get("tempUserId").toString(), productId);
//			cartList = dao.showUserCartList(session.get("tempUserId").toString());
//		}
//		else {
//			userId = session.get("userId").toString();// ログインしているuserId
//			deletedao.deleteSeparate(userId, productId);
//			cartList = dao.showUserCartList(session.get("userId").toString());
//		}
//
//		totalPrice = calcTotalPrice(cartList);
//
//		result = SUCCESS;
//
//		return result;
//	}

	//セッションを【取得する】メソッド
	public Map<String, Object> getSession() {
		return session;
	}

	//セッションを【格納する】メソッド
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	//商品IDを【取得する】メソッド
	public String getProductId() {
		return Integer.valueOf(productId).toString();
	}

	//商品IDを【格納する】メソッド
	public void setProductId(String productId) {
		this.productId = Integer.parseInt(productId);
	}

	//カート情報を【取得する】メソッド
	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	//カート情報を【格納する】メソッド
	public void setCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	//合計金額を【取得する】メソッド
	public int getTotalPrice() {
		return total_price;
	}

	//合計金額を【格納する】メソッド
	public void setTotalPrice(int total_price) {
		this.total_price = total_price;
	}

}
