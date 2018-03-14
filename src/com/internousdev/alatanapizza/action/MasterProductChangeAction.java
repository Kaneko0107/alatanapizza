package com.internousdev.alatanapizza.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ProductListDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MasterProductChangeAction extends ActionSupport implements SessionAware {

	//セッション
	private Map<String,Object>session;
    private ProductListDAO productListDAO = new ProductListDAO();
    public ArrayList<ProductDTO> productList = new ArrayList<>();
    private Integer stock;
    private Integer productId;
    public String errorMessage;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	//管理者フラグを確認する
	public String execute() throws SQLException {
		String result;
		if (session.containsKey("masterFlg") && ((Boolean) session.get("masterFlg"))) {
			result = "master";
		} else {
			result = "error";
			return result;
		}
		System.out.println("新しい在庫数: " + productId + "    " + stock);
		productList = productListDAO.getProductInfo();

		if (productId != null && stock != null) {
			if (stock < 0 || stock > 100) {
				errorMessage = "カートの個数は0以上100未満です";
				return result;
			}
			productListDAO.updateStock(productId, stock);
			productList = productListDAO.getProductInfo();
		}

		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}


	}

