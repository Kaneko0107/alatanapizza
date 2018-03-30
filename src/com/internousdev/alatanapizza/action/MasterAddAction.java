package com.internousdev.alatanapizza.action;

import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.MasterProductDAO;
import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.DateUtil;
import com.opensymphony.xwork2.ActionSupport;

public class MasterAddAction extends ActionSupport implements SessionAware {

	public void setImage(String imageName) {
		this.imageName = imageName;
	}

	private String imageContentType;
	private String imageFileName;

	private String itemName;

	private String itemKanaName;

	private String itemPrice;

	private String itemStock;

	private String imageName;

	private ArrayList<String> imageFileNames = new ArrayList<String>();

	public String getImage() {
		return imageName;
	}

	public Map<String, Object> session;

	private DateUtil dateUtil = new DateUtil();

	private MasterProductDAO dao = new  MasterProductDAO();
	private ProductDTO dto = new ProductDTO();

	public String execute() throws SQLException {
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

		if (itemName == null || itemPrice == null || itemStock == null || itemKanaName==null || imageName == null) {
			return "form";
		}
		//文字列が空白でなければsuccessを返す。何か空白が入っている場合は、errorを返す。

		if (itemName.length() != 0 && itemKanaName.length() !=0 && itemPrice.length() != 0 && itemStock.length() != 0) {
			dto = dao.productDTO(itemName, itemKanaName, itemPrice, itemStock, imageName);
			session.put("ItemInsert", dto);
			session.put("itemName", itemName);
			session.put("itemPrice", itemPrice);
			session.put("itemStock", itemStock);
			session.put("insertDate", dateUtil.getDate());

			result = SUCCESS;

			return result;
		}
		return result;
	}

	public ArrayList<String> getImageFileNames() {
		return imageFileNames;
	}
	public void setImageFileNames(ArrayList<String> imageFileNames) {
		this.imageFileNames = imageFileNames;
	}

	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemKanaName() {
		return itemName;
	}
	public void setItemKanaName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}

	public String getImageFileName() {
		return imageFileName;
	}
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getImageContentType() {
		return imageContentType;
	}
	public void setImageContentType(String imageContentType) {
		this.imageContentType = imageContentType;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
