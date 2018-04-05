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

	private int productId;//商品ID_商品購入ページから持ってくる
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

	//totalPriceは2種類の意味を持っている
	//カート全体の金額を入れる場合と、個別の商品金額を入れる場合
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
	    //もし商品IDまたは商品個数が0だった場合
		if (productId == 0 || productCount == 0) {
			//userIdのカートリストを取得する
			cartList = dao.showUserCartList(userId);
			//カートリストを渡して、カート全体の合計金額を計算する
			totalPrice = calcTotalPrice(cartList);
			return "success";
		}

		//getProductDetailsInfoがStringで値を取るようになっている為、productIdをString型にしている
		//DAOからproductId（商品情報）を取得し、DTOのdetailという変数に代入している
		ProductDTO detail = productDetailsDAO.getProductDetailsInfo(Integer.valueOf(productId).toString());
		//もし、商品個数がマイナスだったら
		if(productCount < 0){
			//userIdのカートリストを取得する
			cartList = dao.showUserCartList(userId);
			//カートリストを渡して、カート全体の合計金額を計算する
			totalPrice = calcTotalPrice(cartList);
			//エラーメッセージを表示する
			errorMessage = "購入個数が不正です。";
			//successを返して、74行目と同じjspを表示させる
			return "success";
		}

		//カートにトッピング追加時のための処理
		//もし、トッピングidがnullではない場合、add(追加)する
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

		//ピザをカートに入れる時に、MサイズかLサイズか判別するコード
		//ピザサイズを未設定にする(nullを代入する）
		String pizzaSize = null;
		//product（追加した商品価格）が0ではない場合
		if (product != 0) {
			//追加した商品価格がMサイズの価格ならばピザサイズをMにする
			if (detail.getMsize_price() == product) {
				pizzaSize = "M";
			//追加した商品価格がLサイズの価格ならばピザサイズをLにする
			} else if (detail.getLsize_price() == product) {
				pizzaSize = "L";
			}
		}

		//カートが重複しているか確認する
		//カートに追加ボタンを押して同じ商品だった場合、数を増やす機能

		//CartInfoDAOのisAlreadyIntoCartで商品情報が重複しているか確認する
		//確認した結果をcartIdに代入している
		Integer cartId = dao.isAlreadyIntoCart(userId, productId, pizzaSize, toppings);

		//cartIdがnullではない場合（商品情報が重複している場合）
		if(cartId != null){
			//CartInfoDAOのchangeProductStockで重複している商品の個数を変更する
			//cartId(重複している商品のIdが入っている）
			//productCount(カートに入れた個数が入っている）
			count = dao.changeProductStock(productCount,cartId);

		//商品情報が重複していない場合
		}else{
			//totalPrice（商品別の金額/ピザの場合はトッピング込みの金額）
			//商品が重複していない為、全ての情報をputProductIntoCartに渡して、カート情報をつくっている
			//作成したカート情報をcountに代入している
			count = dao.putProductIntoCart(userId,productId,productCount,totalPrice, pizzaSize, toppings);
		}

		//userIdのカートリストを取得する
		cartList = dao.showUserCartList(userId);

		//カートリストを渡して、カート全体の合計金額を計算する
		totalPrice = calcTotalPrice(cartList);
		return SUCCESS;
	}

	//合計金額計算を計算するメソッドの定義
	//calcTotalPriceの処理内容

	//カートリストが渡される
	public int calcTotalPrice(ArrayList<CartInfoDTO>cartList){
		//合計金額を初期化する
		int totalPrice = 0;
		//cartList内の個別のカート情報（dto)をfor文でまわしている
		for(CartInfoDTO dto : cartList){
			//totalPriceにgetした金額を足し合わせている
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