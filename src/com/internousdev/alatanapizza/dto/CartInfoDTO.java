package com.internousdev.alatanapizza.dto;

import java.util.ArrayList;
import java.util.Date;

public class CartInfoDTO {

	private int id;
	private String userId;
	private String tempUserId;
	private String productName;
	private String imageFilePath;
	private String releaseCompany;
	private String releaseDate;
	private String pizzaSize;
	private int productId;
	private int productCount;
	private int stock;
	private String itemStock;
	private int price;
	private Date registDate;
	private Date updateDate;
	private ArrayList<String> toppings;
	private ArrayList<Integer> toppingIds;

	private String productDescription;
	private String productNameKana;


	public int getId(){
		return id;
	}
	public void setId(int id){
		this.id = id;
	}

	public String getUserId(){
		return userId;
	}
	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getTempUserId(){
		return tempUserId;
	}
	public void setTempUserId(String tempUserId){
		this.tempUserId = tempUserId;
	}

	public int getProductId(){
		return productId;
	}
	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductCount(){
		return productCount;
	}
	public void setProductCount(int productCount){
		this.productCount = productCount;
	}

	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrice(){
		return price;
	}
	public void setPrice(int price){
		this.price = price;
	}

	public Date getRegistDate(){
		return registDate;
	}
	public void setRegistDate(Date registDate){
		this.registDate = registDate;
	}

	public Date getUpdateDate(){
		return updateDate;
	}
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getImageFilePath() {
		return imageFilePath;
	}
	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	public ArrayList<String> getToppings() {
		return toppings;
	}
	public void setToppings(ArrayList<String> toppings) {
		this.toppings = toppings;
	}

	public String getReleaseCompany() {
		return releaseCompany;
	}
	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getProductNameKana() {
		return productNameKana;
	}
	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPizzaSize() {
		return pizzaSize;
	}
	public void setPizzaSize(String pizzaSize) {
		this.pizzaSize = pizzaSize;
	}

	public ArrayList<Integer> getToppingIds() {
		return toppingIds;
	}
	public void setToppingIds(ArrayList<Integer> toppingIds) {
		this.toppingIds = toppingIds;
	}

	public String getItemStock() {
		return itemStock;
	}
	public void setItemStock(String itemStock) {
		this.itemStock = itemStock;
	}
}
