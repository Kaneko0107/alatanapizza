package com.internousdev.alatanapizza.action;
//こちらの商品も一緒にいかがですか？のAction　担当：上原
//決済確認を押す前に表示する。カートアクション内で。
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ProductInfoCategoryDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductInfoCategoryAction extends ActionSupport implements SessionAware {

	// セッション情報取得

	private String id;
	private String product_id;
	private String category_name;
	private int price;
	private int category_id;
	private Map<String,Object> session;


	// こちらの商品もどうですか？情報リスト
	public List<ProductDTO> notSameCategoryList = new ArrayList<ProductDTO>();
	public ProductDTO dto = new ProductDTO();
	public ProductInfoCategoryDAO dao = new ProductInfoCategoryDAO();



	public String execute() throws SQLException {

		try {
			notSameCategoryList = dao.notSameCategoryList(category_id);
			if (notSameCategoryList != null) {
				session.put("notSameCategoryList", notSameCategoryList);
				session.put("a_product_name", dto.getProduct_name());
				session.put("product_name_kana", dto.getProduct_name_kana());
				session.put("image_file_name", dto.getImage_file_name());
				session.put("image_file_path", dto.getImage_file_path());



			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String result = SUCCESS;
		return result;

	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setNotSameCategoryList(List<ProductDTO> notSameCategoryList ){

		this.notSameCategoryList=notSameCategoryList;
	}

	public List<ProductDTO> getNotSameCategoryList(){
		return notSameCategoryList;
	}

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
