package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartProductAction extends ActionSupport implements SessionAware{

	private Map<String,Object>session;
	private ArrayList<CartInfoDTO>cartList = new ArrayList<CartInfoDTO>();

	//商品ID
	private String productId;

	private String productNameKana;
	private String productName;
	private String productDescription;
	private String price;
	private String imageFileName;
	private String releaseCompany;
	private int count;

	//重複フラグを定義
	private boolean duplicationFlg;

	private CartInfoDTO dto = new CartInfoDTO();
	private CartInfoDAO dao = new CartInfoDAO();

	//カートの商品数
	private int productCount;

	//カートの合計金額
	private int totalPrice = 0;
	public String execute()throws SQLException{
		int TotalPrice = Integer.parseInt(price);


	//商品重複を確かめる（重複フラグ"Duplication"をたてる）
		//ログインしている時にカートに入れた場合
		if(session.containsKey("loginFlg")){


			//"Integer.parseInt"→文字列から数列へ変換。全角でも半角でも通す
			dto.setProductId(Integer.parseInt(productId.toString()));
			dto.setProductCount(productCount);


		//重複フラグの説明
		duplicationFlg = dao.isAlreadyIntoCart(session.get("tempUserId").toString(),Integer.parseInt(productId));

		//カート内の商品の重複を確認
			if(duplicationFlg){
				count = dao.UpdateProductCount(session.get("userId").toString(), Integer.parseInt(productId),
						productCount, totalPrice);
				cartList = dao.showUserCartList(session.get("userId").toString());
			}else{
				count = dao.putProductIntoCart(session.get("userId").toString(), Integer.parseInt(productId),
						productCount, totalPrice);
				cartList = dao.showUserCartList(session.get("userId").toString());
			 }
		}

		//ゲストユーザーの場合、カート内の商品の重複を確認
			else{
				if(duplicationFlg){
					count = dao.UpdateProductCount(session.get("tempUserId").toString(), Integer.parseInt(productId),
							productCount, totalPrice);
					cartList = dao.showUserCartList(session.get("tempUserId").toString());
				}else{
					count = dao.putProductIntoCart(session.get("tempUserId").toString(), Integer.parseInt(productId),
							productCount, totalPrice);
					cartList = dao.showUserCartList(session.get("tempUserId").toString());
				}
			  }

		//検索画面で購入個数をマイナスにした場合は"CountError"を返して別のページに飛ぶ
			if(productCount < 0){
				return "CountError";
			}
			totalPrice = calcTotalPrice(cartList);
			return SUCCESS;
		}

		public Map<String,Object>getSession(){
			return session;
		}

		public void setSession(Map<String,Object>session){
			this.session = session;
		}

		public String getProductId(){
			return productId;
		}

		public void setProductId(String productId){
			this.productId = productId;
		}

		public String getProductNameKana(){
			return productNameKana;
		}

		public void setProductNameKana(String productNameKana){
			this.productNameKana = productNameKana;
		}

		public String getProductName(){
			return productName;
		}

		public void setProductName(String productName){
			this.productName = productName;
		}

		public String getProductDescription(){
			return productDescription;
		}

		public void setProductDescription(String productDescription){
			this.productDescription = productDescription;
		}

		public String getPrice(){
			return price;
		}

		public void setPrice(String price){
			this.price = price;
		}

		public String getImageFileName(){
			return imageFileName;
		}

		public void setImageFileName(String imageFileName){
			this.imageFileName = imageFileName;
		}

		public String getReleaseCompany(){
			return releaseCompany;
		}

		public void setReleaseCompany(String releaseCompany){
			this.releaseCompany = releaseCompany;
		}

		public ArrayList<CartInfoDTO>getCartList(){
			return cartList;
		}

		public void setCartList(ArrayList<CartInfoDTO>cartList){
			this.cartList = cartList;
		}

		//重複フラグ
		public boolean DuplicationFlg(){
			return duplicationFlg;
		}

		public void setDuplicationFlg(boolean duplicationFlg){
			this.duplicationFlg = duplicationFlg;
		}

		public int getTotalPrice(){
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice){
			this.totalPrice = totalPrice;
		}

		//合計金額計算メソッド
		public int calcTotalPrice(ArrayList<CartInfoDTO>cartList){
			int totalPrice = 0;
			for(CartInfoDTO dto : cartList){
				totalPrice += dto.getPrice()*dto.getProductCount();
				System.out.println("合計" + totalPrice + "円");
			}
			return totalPrice;
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
	}