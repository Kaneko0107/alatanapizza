package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.mysql.jdbc.PreparedStatement;
import com.opensymphony.xwork2.ActionSupport;

public class CartInfoDAO extends ActionSupport{

	DBConnector db = new DBConnector();
	Connection con = null;

	public int putProductIntoCart(String userId, int productId, int productCount, int price)throws SQLException{
		System.out.println("putProductIntoCart");
		int count = 0;

		System.out.println(userId);
		System.out.println(productId);
		System.out.println(productCount);
		String sql = "INSERT INTO cart_info(user_id,temp_user_id,product_id,product_count,price,regst_date)" + "VALUES(?,?,?,?,?,NOW())";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userId);
			ps.setInt(3, productId);
			ps.setInt(4, productCount);
			ps.setInt(5, price);
			count = ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;
	}

	//ログインユーザーのカート情報を引き出す
	public ArrayList<CartInfoDTO>showUserCartList(String userId)throws SQLException{
		System.out.println("しょｗUserCartList");
		ArrayList<CartInfoDTO>cartList = new ArrayList<>();

		String sql = "SE"

	}

}
