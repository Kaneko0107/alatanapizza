package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.MasterAddConfirmDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.ErrorMessageConstants;
import com.opensymphony.xwork2.ActionSupport;


public class MasterAddConfirmAction extends ActionSupport implements SessionAware,ErrorMessageConstants{

	MasterAddConfirmDAO dao=new MasterAddConfirmDAO();
	ProductDTO dto=new ProductDTO();

	Map<String,Object>session;

	private String itemName;
	private String itemKanaName;
	private String itemPrice;
	private String itemStock;
	private String imageName;
	private String imageContentType;
	private String imageFileName;
	private ArrayList<String> errorMessageList=new ArrayList<>();


	public String execute() throws SQLException{

		String result = ERROR;
		if (itemName == null || itemPrice == null || itemStock == null || itemKanaName == null || imageName == null) {
			errorMessageList.add("全ての項目を入力してください");
			return result;
		}
		//文字列が空白でなければsuccessを返す。何か空白が入っている場合は、errorを返す。

		if (itemName.length() != 0 && itemKanaName.length() !=0 && itemPrice.length() != 0 && itemStock.length() != 0 && imageName.length() != 0) {
			dto = dao.checkItemInfo(itemName,itemKanaName);
			session.put("itemKanaName", itemKanaName);
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
			session.put("imageName", imageName);

			result = SUCCESS;
			return result;
		}else {
			errorMessageList.add("全ての項目を入力してください");
		}
		return result;
	}


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
	public String getItemKanaName() {
		return itemKanaName;
	}
	public void setItemKanaName(String itemKanaName) {
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
	public void setImageName(String image) {
		this.imageName = image;
	}
	public String getImageName() {
		return imageName;
	}
	//---------------------------------------------------
	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}
	//---------------------------------------------------
	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}
	//---------------------------------------------------
	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

}




