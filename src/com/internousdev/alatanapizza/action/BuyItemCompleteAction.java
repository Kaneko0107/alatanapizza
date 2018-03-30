package com.internousdev.alatanapizza.action;
//決済確認画面　担当：上原

//<result>
//ERROR→ログインからやり直し（login.jspへ）
//SUCCESS→決済完了画面へ（settlement.jsp）
//DESTINATION→宛先新規登録画面へ（destinationinfo.jsp)
//other→カートが空です（cart.jspへ）

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dao.ProductInfoCategoryDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session; //
	private int totalPrice = 0; // 合計金額
	private int productCount; // 個数
	private List<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>(); // カート情報一覧
	private ArrayList<DestinationDTO> destinationListDTO = new ArrayList<DestinationDTO>();
	// ↑宛先情報一覧（ログイングループ）

	private String message; // 削除メッセージ
	private String deleteFlg; // 削除フラグ
	public ArrayList<DestinationDTO> destinationList = new ArrayList<DestinationDTO>();
	String userId;
	private int id; // 個別削除id取得 DAOメソッドの戻り値
	private int category_id;
	private List<String> checkList;// checkBoxの値
	public List<ProductDTO> notSameCategoryList = new ArrayList<ProductDTO>();
	public ProductDTO dto = new ProductDTO();
	public ProductInfoCategoryDAO categorydao = new ProductInfoCategoryDAO();
	public String execute() throws SQLException {
		String result = ERROR;

		// 決済情報取得メソッド
		// 確認画面の商品情報は、カート情報をそのままもってきている。
		// だから、このActionにはDAOはないです。
		// 宛先情報とカーと情報をただのせるだけのページ。

		//"userId"を定義し、その中に"登録ユーザー"と"ゲストユーザー"を入れて処理する
		String userId;
		//"登録ユーザー"と"ゲストユーザー"のどちらでログインしているか確認し、定義した"userId"に代入する




		if((boolean)session.get("loginFlg")){
			userId =(String)session.get("userId");
		}
		else{
			userId =(String)session.get("tempUserId");
		}

		// ↓ログインユーザーのカート情報を全表示させる↓
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartList = cartInfoDAO.showUserCartList(userId);

		// もしログインしていたら
		// ↓指定したユーザーの宛先情報取得 obtaining==入手
		//↓"containsKey"はログインフラグの有無を確認しているだけで中身を取り出していないのでgetにする
		// if (session.containsKey("loginFlg"))
		if((boolean)session.get("loginFlg")) {
			DestinationDAO destinationInfoDAO = new DestinationDAO();
			destinationListDTO.addAll(destinationInfoDAO.obtainingDestinationInfo(session.get("userId").toString()));

		}

		// もしログインしてなければログインに飛ばす
		// elseで動くので、簡単にする
		// else if (!session.containsKey("loginFlg")) {
		else {
			session.put("target","payment");
			return ERROR; // ■login.jspへ
		}

		// カートに何も入っていない場合
		if (cartList.size() == 0) {
			return "other";// ■cart.jspへ。
		}
		for (CartInfoDTO dto : cartList) {
			totalPrice += dto.getPrice();
		}

		// もし宛先情報が入っていれば、
		if (destinationListDTO.size() > 0) {
			result = SUCCESS;// ■決済完了画面へ（settlement.jsp）
		}
		// 宛先情報が入っていなければ、
		else {
			result = "DESTINATION"; // ■宛先新規登録画面へ（destinationinfo.jsp)

		}





		//こちらの商品もいかがですか？機能
		try {
			notSameCategoryList = categorydao.notSameCategoryList(category_id);
			if (notSameCategoryList != null) {
				session.put("notSameCategoryList", notSameCategoryList);
				session.put("a_product_name", dto.getProduct_name());
				session.put("product_name_kana", dto.getProduct_name_kana());
				session.put("image_file_name", dto.getImage_file_name());
				session.put("image_file_path", dto.getImage_file_path());
				session.put("category_id", dto.getCategory_id());


			}

		} catch (SQLException e) {
			e.printStackTrace();
		}


		return result;
	}









	/**
	 * @return cartInfoDTOList
	 */
	public List<CartInfoDTO> getCartList() {
		return cartList;
	}

	/**
	 * @param cartInfoDTOList
	 *            セットする cartInfoDTOList
	 */
	public void setCartList(List<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	/**
	 * @return totalPrice
	 */
	public int getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice
	 *            セットする totalPrice
	 */
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ArrayList<DestinationDTO> getDestinationListDTO() {
		return destinationListDTO;
	}

	public void setDestinationListDTO(ArrayList<DestinationDTO> destinationListDTO) {
		this.destinationListDTO = destinationListDTO;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
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

}
