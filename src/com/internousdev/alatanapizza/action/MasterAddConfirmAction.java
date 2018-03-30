package com.internousdev.alatanapizza.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
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
	private String imagePath;
	private ArrayList<String> errorMessageList=new ArrayList<>();
	private ArrayList<String> imageFileNames = new ArrayList<String>();


	public String execute() throws SQLException{
		String result = ERROR;

		String context = ServletActionContext.getServletContext().getRealPath("/images/newSide");
		File[] files = new File(context).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				imageFileNames.add(file.getName());
			}
		}

		//管理者フラグを確認する
		if (!session.containsKey("masterFlg") || ((Boolean) session.get("masterFlg")) == false) {
			return "other";
		}

		if (itemName == null || itemPrice == null || itemStock == null || itemKanaName == null || imageName == null) {
			errorMessageList.add("【全ての項目を入力してください】");
			return result;
		}
		//文字列が空白でなければsuccessを返す。何か空白が入っている場合は、errorを返す。

		if (itemName.length() != 0 && itemKanaName.length() !=0 && itemPrice.length() != 0 && itemStock.length() != 0 && imageName.length() != 0) {
			if (dao.checkItemInfo(itemName,itemKanaName)) {
				errorMessageList.add("【すでに登録されています】");
			}
			if(itemName.length() > 20){
				errorMessageList.add("【商品名は20文字以下で入力してください】");
			}
			if(!itemName.matches("^[a-zA-Z.ぁ-ん.ァ-ン.一-龠]*$")) {
				errorMessageList.add("【商品名に記号は使えません】");
			}
			if(itemKanaName.length() > 30){
				errorMessageList.add("【商品名(ひらがな)は30文字以下で入力してください】");
			}
			if (!itemKanaName.matches("^[ぁ-ん]+$")) {
				errorMessageList.add("【商品名(ひらがな)はひらがなで入力してください】");
			}
			if(!itemPrice.matches("^[1-9][0-9]{0,5}$")){ //itemPriceが数字でない時（あるいは0の時も）
				errorMessageList.add("【価格は半角数字で正しい値（上限1万円)を入力してください】");
			} else if(Integer.parseInt(itemPrice) > 10000) {
				errorMessageList.add("【価格は1万円以内にしてください】");
			}
			imagePath = "./images/newSide/" + imageName;
			session.put("itemKanaName", itemKanaName);
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
			session.put("imageName", imageName);
			if (!errorMessageList.isEmpty()) {
				return result;
			}

			result = SUCCESS;
			return result;
		}else {
			errorMessageList.add("【全ての項目を入力してください】");
		}
		return result;
	}


	public void setSession(Map<String,Object>session) {
		this.session=session;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	public String getItemKanaName() {
		return itemKanaName;
	}
	public void setItemKanaName(String itemKanaName) {
		this.itemKanaName=itemKanaName;
	}

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice=itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock=itemStock;
	}

	public void setImageName(String image) {
		this.imageName = image;
	}
	public String getImageName() {
		return imageName;
	}

	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	public ArrayList<String> getErrorMessageList() {
		return errorMessageList;
	}
	public void setErrorMessageList(ArrayList<String> errorMessageList) {
		this.errorMessageList = errorMessageList;
	}

	public String getImagePath() {
		return imagePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imagePath = imageFilePath;
	}

	public ArrayList<String> getImageFileNames() {
		return imageFileNames;
	}
	public void setImageFileNames(ArrayList<String> imageFileNames) {
		this.imageFileNames = imageFileNames;
	}
}

