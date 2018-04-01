package com.internousdev.alatanapizza.action;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.ProductListDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.opensymphony.xwork2.ActionSupport;


public class MasterProductChangeAction extends ActionSupport implements SessionAware {

	private Map<String,Object>session;
	private ProductListDAO productListDAO = new ProductListDAO();
	public ArrayList<ProductDTO> productList = new ArrayList<>();
	public Map<Integer, int[]> productStockList = new HashMap<Integer, int[]>();
	private String stock;
	private Integer productId;
	public String message;

	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}

	public String execute() throws SQLException {
		String result;

		//管理者フラグを確認する
		if (session.containsKey("masterFlg") && ((Boolean) session.get("masterFlg"))) {
			result = "master";
		} else {
			result = "error";
			return result;
		}


		if (productId != null && stock != null) {
			int stock = Integer.parseInt(this.stock);
			productList = productListDAO.getProductInfo();
			for (ProductDTO product: productList) {
				if (product.getProduct_id() == productId && product.getStock() != stock) {
					message = "在庫を変更しました。";
					productListDAO.updateStock(productId, stock);
				}
			}
		}
		productList = productListDAO.getProductInfo();
		for (ProductDTO product: productList) {
			productStockList.put(
					product.getProduct_id(),
					IntStream.range(
							Math.max(0, product.getStock() - 20),
							Math.min(product.getStock() + 20, 100) + 1
							).toArray()
					);
		}
		return result;
	}

	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}

