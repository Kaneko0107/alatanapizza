package com.internousdev.alatanapizza.action;

import java.io.File;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.MasterAddConfirmDAO;
import com.internousdev.alatanapizza.dto.ProductDTO2;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;


public class MasterAddConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants{

	MasterAddConfirmDAO dao=new MasterAddConfirmDAO();
	ProductDTO2 dto=new ProductDTO2();

	Map<String,Object>session;

	private String itemName;
	private String itemKanaName;
	private String itemPrice;
	private String itemStock;


	private File image;
	private String imageContentType;
	private String imageFileName;

	//ゲッター、セッター
	//---------------------------------------------------

	public void setSession(Map<String,Object>session) {
		this.session=session;
	}

	//---------------------------------------------------

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	//---------------------------------------------------

	public String getItemNameKana() {
		return itemKanaName;
	}

	public void setItemNameKana(String itemKanaName) {
		this.itemKanaName=itemKanaName;
	}

	//---------------------------------------------------

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice=itemPrice;
	}

	//---------------------------------------------------

	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock=itemStock;
	}

	//---------------------------------------------------
	public void setImage(File image) {
		this.image = image;
	}


	public File getImage() {
		return image;
	}

	//---------------------------------------------------

	public String execute() throws SQLException{

		String result = ERROR;
		if (itemName == null && itemPrice == null && itemStock == null && itemKanaName==null) {
			return "form";
		}
		//文字列が空白でなければsuccessを返す。何か空白が入っている場合は、errorを返す。

		if (itemName.length() != 0 && itemKanaName.length() !=0 && itemPrice.length() != 0 && itemStock.length() != 0) {
			dto = dao.checkItemInfo(itemName,itemKanaName);
			session.put("itemKanaName", itemKanaName);
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);



			result = SUCCESS;
			return result;
		}
		return result;
	}

}




