package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.CartInfoDAO;
import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dao.DestinationDeleteDAO;
import com.internousdev.alatanapizza.dao.ProductInfoCategoryDAO;
import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DestinationDeleteAction extends ActionSupport implements SessionAware {

	private Map<String, Object> session;
	private ArrayList<DestinationDTO> destinationList = new ArrayList<DestinationDTO>();
	private String message; // 削除メッセージ
	private String deleteFlg; // 削除フラグ
	private DestinationDeleteDAO dao = new DestinationDeleteDAO();
	private DestinationDAO destinationdao=new DestinationDAO();
	private int id; // 個別削除id取得 DAOメソッドの戻り値
	String userId;
	private List<CartInfoDTO> cartList = new ArrayList<CartInfoDTO>(); // カート情報一覧
	public List<CartInfoDTO> getCartList() {
		return cartList;
	}

	public void setCartList(List<CartInfoDTO> cartList) {
		this.cartList = cartList;
	}

	private ArrayList<DestinationDTO> destinationListDTO = new ArrayList<DestinationDTO>();
	public ArrayList<DestinationDTO> getDestinationListDTO() {
		return destinationListDTO;
	}

	public void setDestinationListDTO(ArrayList<DestinationDTO> destinationListDTO) {
		this.destinationListDTO = destinationListDTO;
	}

	private int totalPrice = 0; // 合計金額
	public List<ProductDTO> notSameCategoryList = new ArrayList<ProductDTO>();
	public ProductInfoCategoryDAO categorydao = new ProductInfoCategoryDAO();
	public ProductDTO dto = new ProductDTO();
	private int category_id;


	public String execute() throws SQLException{

		userId =(String)session.get("userId");
		String result=SUCCESS;


		if(deleteFlg.equals("1")) {
			delete();
			result = "DESTINATION";


		}else if(deleteFlg.equals("2")) {
			deletePart();
			destinationList=destinationdao.obtainingDestinationInfo(userId);
			result=SUCCESS;
		}

		// ログインユーザーのカート情報を全表示
		CartInfoDAO cartInfoDAO = new CartInfoDAO();
		cartList = cartInfoDAO.showUserCartList(userId);

		if((boolean)session.get("loginFlg")) {
			DestinationDAO destinationInfoDAO = new DestinationDAO();
			destinationListDTO.addAll(destinationInfoDAO.obtainingDestinationInfo(session.get("userId").toString()));
		}
		else {
			return ERROR;
		}

		if (cartList.size() == 0) {
			return "other";
		}
		for (CartInfoDTO dto : cartList) {
			setTotalPrice(getTotalPrice() + dto.getPrice());
		}

		if (destinationListDTO.size() > 0) {
			result = SUCCESS;
		}
		else {
			result = "DESTINATION";
		}

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

	// 全件削除メソッド
	public void delete() throws SQLException {

		String user_id = session.get("userId").toString();

		int res = dao.deleteAllDestination(user_id);

		if (res > 0) {
			destinationList = null;
			setMessage("注文履歴をすべて削除しました");
		} else if (res == 0) {
			setMessage("履歴の削除に失敗しました。");
		}
	}

	//個別削除メソッド
	public void deletePart() throws SQLException {
		int res=dao.deletePartDestination(id);

		if(res>0){
			setMessage(res + "件削除しました");
		}else if (res == 0){
			setMessage("削除できませんでした");
		}
	}


	public String getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}


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

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public ArrayList<DestinationDTO> getDestinationList() {
		return destinationList;
	}
	public void setDestinationList(ArrayList<DestinationDTO> destinationList) {
		this.destinationList = destinationList;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

}
