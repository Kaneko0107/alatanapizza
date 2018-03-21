package com.internousdev.alatanapizza.dto;

import java.util.Date;


public class ProductDTO {
    private int id; //ID
    private int product_id; //商品ID
    private int category_id; //カテゴリーID
    private int topping_id; //トッピングID
    private int msize_price; //Mサイズ価格
    private int lsize_price; //Lサイズ価格
    private int price; //サイドメニュー、ドリンク価格
    private int stock; //在庫
    private int status; //ステータス
    private String product_name; //商品名
    private String product_name_kana; //商品かな
    private String product_description; //商品詳細
    private String image_file_path; //画像ファイルパス
    private String image_file_name; //画像ファイル名
    private String release_date; //発売年月日
    private String release_company; //発売会社
    private String category_name; //カテゴリー名
    private String topping_name; //トッピング名
	private Date regist_date; //ピザ登録日
    private Date update_date; //更新日
    private Date insert_date; //トッピング登録日

    //下記管理者ページで使用
    private String itemName; //商品名
    private String itemKanaName; //商品かな
    private String itemPrice; //商品価格
    private String itemStock; //商品在庫

    public String getCategoryName() {
       return category_name;
    }
    public void setCategoryName(String categoryName) {
       this.category_name = categoryName;
    }

	public int getId() {
		return id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public int getTopping_id() {
		return topping_id;
	}
	public int getMsize_price() {
		return msize_price;
	}
	public int getLsize_price() {
		return lsize_price;
	}
	public int getPrice() {
		return price;
	}
	public int getStock() {
		return stock;
	}
	public int getStatus() {
		return status;
	}
	public String getProduct_name() {
		return product_name;
	}
	public String getProduct_name_kana() {
		return product_name_kana;
	}
	public String getProduct_description() {
		return product_description;
	}
	public String getImage_file_path() {
		return image_file_path;
	}
	public String getImage_file_name() {
		return image_file_name;
	}
	public String getRelease_date() {
		return release_date;
	}
	public String getRelease_company() {
		return release_company;
	}
	public String getCategory_name() {
		return category_name;
	}
	public String getTopping_name() {
		return topping_name;
	}
	public Date getRegist_date() {
		return regist_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public Date getInsert_date() {
		return insert_date;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public void setTopping_id(int topping_id) {
		this.topping_id = topping_id;
	}
	public void setMsize_price(int msize_price) {
		this.msize_price = msize_price;
	}
	public void setLsize_price(int lsize_price) {
		this.lsize_price = lsize_price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public void setProduct_name_kana(String product_name_kana) {
		this.product_name_kana = product_name_kana;
	}
	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}
	public void setImage_file_path(String image_file_path) {
		this.image_file_path = image_file_path;
	}
	public void setImage_file_name(String image_file_name) {
		this.image_file_name = image_file_name;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public void setRelease_company(String release_company) {
		this.release_company = release_company;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public void setTopping_name(String topping_name) {
		this.topping_name = topping_name;
	}
	public void setRegist_date(Date regist_date) {
		this.regist_date = regist_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	//商品名
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName=itemName;
	}

	//商品かな
	public String getItemKanaName() {
		return itemKanaName;
	}

	public void setItemKanaName(String itemKanaName) {
		this.itemKanaName=itemKanaName;
	}

	//商品価格
	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice=itemPrice;
	}

	//商品在庫
	public String getItemStock() {
		return itemStock;
	}

	public void setItemStock(String itemStock) {
		this.itemStock=itemStock;
	}

 }
