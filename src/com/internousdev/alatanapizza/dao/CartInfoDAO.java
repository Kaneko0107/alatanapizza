package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class CartInfoDAO extends ActionSupport{

	DBConnector db = new DBConnector();
	Connection con = null;

	//ユーザーの商品をカートに入れる
	public int putProductIntoCart(String userId, int productId, int productCount, int price, String pizzaSize, ArrayList<Integer> toppings) throws SQLException {
		int count = 0;
		String sql = "INSERT INTO cart_info(id, user_id,temp_user_id,product_id,product_count,price,pizza_size,regist_date)" + "VALUES(?, ?,?,?,?,?,?,NOW())";
		int cartId = (int)(Math.random() * 1000000);

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, cartId);
			ps.setString(2, userId);
			ps.setString(3, userId);
			ps.setInt(4, productId);
			ps.setInt(5, productCount);
			ps.setInt(6, price);
			ps.setString(7, pizzaSize);

			count = ps.executeUpdate();
			for (Integer topping: toppings) {
				String cartSql = "INSERT INTO cart_topping_info(cart_id, topping_id, regist_date, update_date)" +
						"VALUES(?,?,NOW(),NOW())";
				PreparedStatement cartPs = (PreparedStatement) con.prepareStatement(cartSql);
				cartPs.setInt(1, cartId);
				cartPs.setInt(2, topping);
				count = cartPs.executeUpdate();
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return count;
	}

	//ユーザーのカート情報を全表示させる
	public ArrayList<CartInfoDTO>showUserCartList(String userId)throws SQLException{
		ArrayList<CartInfoDTO>cartList = new ArrayList<>();

		String sql = "SELECT cart_info.id, cart_info.product_id, cart_info.user_id, cart_info.pizza_size, pi.product_name, pi.product_name_kana, pi.image_file_path, cart_info.price,pi.product_description, pi.release_company, pi.release_date, product_count"
				+ " FROM cart_info LEFT JOIN product_info as pi ON cart_info.product_id = pi.product_id"
				+ " WHERE user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				int cartId = rs.getInt("cart_info.id");
				dto.setId(cartId);
				dto.setUserId(rs.getString("cart_info.user_id"));
				dto.setProductName(rs.getString("pi.product_name"));
				dto.setProductNameKana(rs.getString("pi.product_name_kana"));
				dto.setImageFilePath(rs.getString("pi.image_file_path"));
				dto.setProductId(rs.getInt("product_id"));
				dto.setPrice(rs.getInt("cart_info.price"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setReleaseCompany(rs.getString("pi.release_company"));
				dto.setReleaseDate(rs.getString("pi.release_date"));
				dto.setProductDescription(rs.getString("pi.product_description"));
				dto.setPizzaSize(rs.getString("cart_info.pizza_size"));

				ArrayList<String> toppings = new ArrayList<String>();
				ArrayList<Integer> toppingIds = new ArrayList<Integer>();
				String toppingSql = "SELECT m_topping.topping_id, m_topping.topping_name FROM cart_topping_info " +
						"LEFT JOIN m_topping " +
						"ON cart_topping_info.topping_id = m_topping.id WHERE cart_topping_info.cart_id = ?";
				PreparedStatement toppingPs = con.prepareStatement(toppingSql);
				toppingPs.setInt(1, cartId);
				ResultSet toppingRs = toppingPs.executeQuery();
				while (toppingRs.next()) {
					toppings.add(toppingRs.getString("m_topping.topping_name"));
					toppingIds.add(toppingRs.getInt("m_topping.topping_id"));
				}
				dto.setToppings(toppings);
				dto.setToppingIds(toppingIds);
				cartList.add(dto);
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return cartList;
	}

	//ログインユーザーのカート情報を取得
	public ArrayList<CartInfoDTO>aquireUserCartInfo(String userId)throws SQLException{
		Connection con = db.getConnection();
		ArrayList<CartInfoDTO>cartList = new ArrayList<>();

		String sql = "SELECT * FROM cart_info WHERE user_id = ?";

		try{
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductCount(rs.getInt("product_count"));
				cartList.add(dto);
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		try{
			con.close();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}
		return cartList;
	}

	//カートに商品が入っているかどうか確認
	public Integer isAlreadyIntoCart(String userId,int productId, String pizzaSize, ArrayList<Integer> toppings)throws SQLException{
		String sql;
		if (pizzaSize != null) {
			sql = "SELECT * FROM cart_info WHERE user_id = ? AND product_id = ? AND pizza_size = ?";
		} else {
			sql = "SELECT * FROM cart_info WHERE user_id = ? AND product_id = ?";
		}

		try{
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			if (pizzaSize != null) {
				ps.setString(3, pizzaSize);
			}

			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				int cartId = rs.getInt("id");
				String toppingSql = "SELECT topping_id FROM cart_topping_info  WHERE cart_topping_info.cart_id = ?";
				PreparedStatement toppingPs = con.prepareStatement(toppingSql);
				toppingPs.setInt(1, cartId);
				ResultSet toppingRs = toppingPs.executeQuery();
				ArrayList<Integer> cartToppings = new ArrayList<Integer>();
				while (toppingRs.next()) {
					cartToppings.add(toppingRs.getInt("topping_id"));
				}
				Collections.sort(toppings);
				Collections.sort(cartToppings);
				if (toppings.equals(cartToppings)) {
					return new Integer(cartId);
				}
			}
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return null;
	}

	//ユーザーのカート内商品の購入予定個数を変更
	public int UpdateProductCount(int productCount,String tempUserId)throws SQLException{
		int count = 0;
		String sql = "UPDATE cart_info SET count = ? WHERE temp_user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productCount);
			ps.setString(2, tempUserId);

			count = ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return count;
	}

	public int changeProductStock(int productCount, Integer cartId)throws SQLException{
		int count = 0;
		String sql = "UPDATE cart_info SET price = (product_count + ?) * (price / product_count), product_count = product_count + ? WHERE id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productCount);
			ps.setInt(2, productCount);
			ps.setInt(3, cartId);
			count = ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return count;
	}
	//ログインをした際にカート内のユーザー情報を引き継ぐ←メソッド
	public void changeUserId(String tempUserId,String userId)throws SQLException{
		String sql = "UPDATE cart_info SET user_id = ?, temp_user_id = ? where temp_user_id = ?";

		try{
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userId);
			ps.setString(3, tempUserId);
			ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
	}

	//在庫更新
	public void changeStockCount(int productStock, int productId) throws SQLException {
		String sql = "UPDATE product_info SET stock=stock - ? WHERE product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productStock);
			ps.setInt(2, productId);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}

	//カート内の商品を1件ずつ削除
	public void deleteSeparate(Integer cartId){
		String sql = "DELETE FROM cart_info WHERE id=?";

		try{
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, cartId);
			ps.executeUpdate();

		}catch(SQLException e){
			throw new RuntimeException(e);
		}
	}

}
