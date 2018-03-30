package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dao.ProductDetailsDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartProductAction extends ActionSupport implements SessionAware{

	//商品ID_商品購入ページから持ってくる
	private int productId;
	private int product; // ピザ追加時のサイズ別の値段
	private String errorMessage;

	//セッション情報
	private Map<String,Object>session;



	//カート内の商品情報リスト
	private ArrayList<CartInfoDTO>cartList = new ArrayList<CartInfoDTO>();

	//カートの商品情報（個数、価格）
	private int productCount;

	private String price;
	private int count;
	private CartInfoDAO dao = new CartInfoDAO();

	//カート内の金額
	public int totalPrice = 0;

	//トッピング情報
	public String topping_id_1;
	public String topping_id_2;
	public String topping_id_3;
	public String topping_id_4;
	public String topping_id_5;
	public String topping_id_6;
	public String topping_id_7;
	public String topping_id_8;
	public String topping_id_9;
	public String topping_id_10;
	public String topping_id_11;
	public String topping_id_12;
	private ProductDetailsDAO productDetailsDAO = new ProductDetailsDAO();


	public String execute() throws SQLException {
		ArrayList<Integer> toppings = new ArrayList<Integer>();

		//"userId"を定義し、その中に"登録ユーザー"と"ゲストユーザー"を入れて処理する
		String userId;

		//"登録ユーザー"と"ゲストユーザー"のどちらでログインしているか確認し、定義した"userId"に代入する
		if((boolean)session.get("loginFlg")){
			userId =(String)session.get("userId");
		}
		else{
			userId =(String)session.get("tempUserId");
		}

		// ブラウザのリロード時はカートを取得してsuccessに入れる
		if (productId == 0 || productCount == 0) {
			cartList = dao.showUserCartList(userId);
			totalPrice = calcTotalPrice(cartList);
			return "success";
		}
		ProductDTO detail = productDetailsDAO.getProductDetailsInfo(Integer.valueOf(productId).toString());
		if(productCount < 0){
			cartList = dao.showUserCartList(userId);
			totalPrice = calcTotalPrice(cartList);
			errorMessage = "購入個数が不正です。";
			return "success";
		}

		//カートにトッピング追加時のための処理
		if (topping_id_1 != null) toppings.add(1);
		if (topping_id_2 != null) toppings.add(2);
		if (topping_id_3 != null) toppings.add(3);
		if (topping_id_4 != null) toppings.add(4);
		if (topping_id_5 != null) toppings.add(5);
		if (topping_id_6 != null) toppings.add(6);
		if (topping_id_7 != null) toppings.add(7);
		if (topping_id_8 != null) toppings.add(8);
		if (topping_id_9 != null) toppings.add(9);
		if (topping_id_10 != null) toppings.add(10);
		if (topping_id_11 != null) toppings.add(11);
		if (topping_id_12 != null) toppings.add(12);


		String pizzaSize = null;
		if (product != 0) {
			if (detail.getMsize_price() == product) {
				pizzaSize = "M";
			} else if (detail.getLsize_price() == product) {
				pizzaSize = "L";
			}
		}

		//カートが重複しているか確認する
		Integer cartId = dao.isAlreadyIntoCart(userId, productId, pizzaSize, toppings);
		if(cartId != null){
			count = dao.changeProductStock(productCount,cartId);
		}else{
			count = dao.putProductIntoCart(userId,productId,productCount,totalPrice, pizzaSize, toppings);
		}
		cartList = dao.showUserCartList(userId);


		totalPrice = calcTotalPrice(cartList);
		return SUCCESS;
	}

	//合計金額計算
	public int calcTotalPrice(ArrayList<CartInfoDTO>cartList){
		int totalPrice = 0;
		for(CartInfoDTO dto : cartList){
			totalPrice += dto.getPrice();

		}
		return totalPrice;
	}


	public Map<String,Object>getSession(){
		return session;
	}
	public void setSession(Map<String,Object> session){
		this.session = session;
	}

	public String getProductId(){
		return Integer.valueOf(productId).toString();
	}
	public void setProductId(String productId){
		this.productId = Integer.parseInt(productId);
	}

	public String getPrice(){
		return price;
	}
	public void setPrice(String price){
		this.price = price;
	}

	public ArrayList<CartInfoDTO>getCartList(){
		return cartList;
	}
	public void setCartList(ArrayList<CartInfoDTO>cartList){
		this.cartList = cartList;
	}

	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int setCount(){
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}

	public int getProduct() {
		return product;
	}
	public void setProduct(int product) {
		this.product = product;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}