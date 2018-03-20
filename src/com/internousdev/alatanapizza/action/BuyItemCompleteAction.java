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
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class BuyItemCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session; //
	private int totalPrice = 0; // 合計金額
	private int productCount; // 個数
	private List<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>(); // カート情報一覧
	private ArrayList<DestinationDTO> destinationListDTO = new ArrayList<DestinationDTO>();
	// ↑宛先情報一覧（ログイングループ）

	public String execute() throws SQLException {
		String result = ERROR;
		System.out.println("-----------BuyItemCompleteAction--------------");

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

		// ↓ログインユーザーのカート情報を全表示させる（金子さん担当アクション）↓
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartList = cartInfoDAO.showUserCartList(userId);

		// もしログインしていたら
		// ↓指定したユーザーの宛先情報取得 obtaining==入手（高木さん担当アクション）
		//↓"containsKey"はログインフラグの有無を確認しているだけで中身を取り出していないのでgetにする
		// if (session.containsKey("loginFlg")) {

		if((boolean)session.get("loginFlg")) {
			DestinationDAO destinationInfoDAO = new DestinationDAO();
			destinationListDTO.addAll(destinationInfoDAO
					.obtainingDestinationInfo(session.get("userId").toString()));
		}

		// もしログインしてなければログインに飛ばす
		// elseで動くので、簡単にする
		// else if (!session.containsKey("loginFlg")) {
		else {
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
			return result;
		}

		return result;
	}

	/**
	 * // 宛先情報取得メソッド 上の文に書き換えてみた↑ こっちがもともとの文面 if ((boolean)
	 * session.get("loginFlg")) { DestinationInfoDAO destinationInfoDAO = new
	 * DestinationInfoDAO(); destinationInfoListDTO =
	 * destinationInfoDAO.obtainingDestinationInfo(session.get("userId").
	 * toString()); }
	 *
	 * if (destinationInfoListDTO.size() > 0) { result = SUCCESS;//
	 * ■settlement.jspへ
	 *
	 * } else if (!(boolean) session.get("loginFlg")) { result = ERROR; //
	 * ■login.jspへ kessai = 1; return result;
	 *
	 * } else { result = "DESTINATION";
	 *
	 * }
	 *
	 */

	/**
	 * @return session
	 */
	public Map<String, Object> getSession() {
		return session;
	}

	/**
	 * @param session
	 *            セットする session
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
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

}
