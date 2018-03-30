package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartDeleteDAO;
import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dao.ProductListDAO;
import com.internousdev.alatanapizza.dao.PurchaseCompleteDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;

//①カート情報取得
//②購入履歴に登録
//③カートテーブルの情報を削除する
public class PurchaseCompleteAction extends ActionSupport implements SessionAware {


	// userId格納
	private String userId;
	// cartInfoDTO格納List
	private ArrayList<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>();
	private ArrayList<String> errorMessageList = new ArrayList<String>();

	// session情報格納
	public Map<String, Object> session;
	// カートの合計金額
	private int totalPrice = 0;

	public String execute() throws SQLException {
		String result = ERROR;//(■cart.jspへ　これたぶん)
		/*---------------------------------------------------------
		①カート情報取得（getCartInfo）
		---------------------------------------------------------*/
		PurchaseCompleteDAO purchaseCompleteDAO = new PurchaseCompleteDAO();
		CartInfoDAO dao = new CartInfoDAO();
		if (session.containsKey("userId")) {
			//cartList = purchaseCompleteDAO.getCartInfo(session.get("userId").toString());
			cartList = dao.showUserCartList((String) session.get("userId"));

			if (cartList.size() == 0) {//カート情報がなかったら
				return "other";//■cart.jspへ
			}


		/*---------------------------------------------------------
		②購入履歴に登録(setPurchseHistory)
		---------------------------------------------------------*/
			//商品情報取得
		    ProductListDAO productListDAO = new ProductListDAO();
		    //商品情報格納
		    ArrayList<ProductDTO> productList;
	        productList = productListDAO.getProductInfo();
	        boolean soldOut = false;

			for (CartInfoDTO cart: cartList) {
				ProductDTO purchasedProduct = null;
				for (ProductDTO product: productList) {
					if (product.getProduct_id() == cart.getProductId()) {
						purchasedProduct = product;
					}
				}
				if (cart.getProductCount() > purchasedProduct.getStock()) {
					if (purchasedProduct.getStock() == 0) {
						errorMessageList.add("申し訳ありません。すでに「" + purchasedProduct.getProduct_name() + "」は在庫切れになっているので購入できずカートから削除しました");
					} else {
						errorMessageList.add("申し訳ありません。「" + purchasedProduct.getProduct_name() + "」の在庫は" + purchasedProduct.getStock() + "個しかないので、" + cart.getProductCount() + "個は購入できずカートから削除しました。");
					}
					dao.deleteSeparate(cart.getId());
					soldOut = true;
				} else {
					purchasedProduct.setStock(purchasedProduct.getStock() - cart.getProductCount());
				}
			}
			if (soldOut) {
				cartList = dao.showUserCartList((String) session.get("userId"));
				totalPrice = calcTotalPrice(cartList);
				return "other";
			}

			int i = purchaseCompleteDAO.setPurchseHistory(cartList);


		/*---------------------------------------------------------
		③カートテーブル情報を削除
		---------------------------------------------------------*/
			for (CartInfoDTO cart: cartList) {
				dao.changeStockCount(cart.getProductCount(), cart.getProductId());
			}
			if (cartList.size() == i) {
				CartDeleteDAO deletedao = new CartDeleteDAO();
				deletedao.AlldeleteCart(session.get("userId").toString());
				result = SUCCESS;
			}
		}
		totalPrice = calcTotalPrice(cartList);
		return result;
	}


		//合計金額を計算メソッド
		public int calcTotalPrice(ArrayList<CartInfoDTO> cartList) {
			int totalPrice = 0;
			for (CartInfoDTO dto : cartList) {
				totalPrice += dto.getPrice() * dto.getProductCount();

			}
			return totalPrice;
		}




	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}


	public ArrayList<CartInfoDTO> getCartList() {
		return cartList;
	}

	public void setCartList(ArrayList<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}


	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

}

