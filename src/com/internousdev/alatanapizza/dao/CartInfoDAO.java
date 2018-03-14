package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class CartInfoDAO extends ActionSupport{

	DBConnector db = new DBConnector();
	Connection con = null;

	//ログインユーザーの商品をカートに入れる
	public int putProductIntoCart(String userId, int productId, int productCount, int price)throws SQLException{
		int count = 0;

		System.out.println(userId);

		System.out.println(productId);

		System.out.println(productCount);

		String sql = "INSERT INTO cart_info(user_id,temp_user_id,product_id,product_count,price,regst_date)" + "VALUES(?,?,?,?,?,NOW())";

		try{
			con = db.getConnection();
			PreparedStatement ps =(PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userId);
			ps.setInt(3, productId);
			ps.setInt(4, productCount);
			ps.setInt(5, price);
			count = ps.executeUpdate();
		}catch(SQLException e){
			throw new RuntimeException(e);
		}finally{
			con.close();
		}
		return count;
	}

	//ゲストユーザーの商品をカートに入れる（temp_user_id）
	public int putProductIntoCartOfGuestUser(String tempUserId, int productId, int price, int productCount)
			throws SQLException {
		System.out.println("putProductIntoCartOfGuestUser");
		int count = 0;

		String sql = "INSERT INTO cart_info(user_id,temp_user_id, product_id, product_count, price, regist_date)"
				+ "VALUES(?,?, ?, ?, ?, NOW())";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, tempUserId);
			ps.setString(2, tempUserId);
			ps.setInt(3, productId);
			ps.setInt(4, productCount);
			ps.setInt(5, price);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
		return count;
	}

	//ログインユーザーのカート情報を全表示させる
	public ArrayList<CartInfoDTO> showUserCartList(String userId) throws SQLException {
		System.out.println("showUserCartList");
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT cart_info.product_id, pi.product_name, pi.product_name_kana, pi.image_file_name, pi.price, pi.release_company, pi.release_date, product_count"
				+ " FROM cart_info LEFT JOIN product_info as pi ON cart_info.product_id = pi.product_id"
				+ " WHERE user_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				dto.setProductCount(rs.getInt("product_count"));
				cartList.add(dto);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
		return cartList;
	}


	//ゲストユーザーのカート情報を全表示させる
	public ArrayList<CartInfoDTO> showTempUserCartList(String tempUserId) throws SQLException {
		System.out.println("showTempUserCartList");
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT cart_info.product_id, cart_info.product_count, pi.product_name, pi.product_name_kana, pi.image_file_name, pi.price, pi.release_company, pi.release_date"
				+ " FROM cart_info LEFT JOIN product_info as pi ON cart_info.product_id = pi.product_id"
				+ " WHERE temp_user_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, tempUserId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				dto.setProductName(rs.getString("product_name"));
				dto.setProductNameKana(rs.getString("product_name_kana"));
				dto.setImageFileName(rs.getString("image_file_name"));
				dto.setPrice(rs.getInt("price"));
				dto.setReleaseCompany(rs.getString("release_company"));
				dto.setReleaseDate(rs.getString("release_date"));
				cartList.add(dto);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
		return cartList;
	}

	//ログインユーザーのカート情報を取得
	public ArrayList<CartInfoDTO> aquireUserCartInfo(String userId) throws SQLException {
		System.out.println("aquireUserCartInfo");
		Connection con = db.getConnection();
		ArrayList<CartInfoDTO> cartList = new ArrayList<>();

		String sql = "SELECT * FROM cart_info WHERE user_id = ?";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CartInfoDTO dto = new CartInfoDTO();
				dto.setProductId(rs.getInt("product_id"));
				dto.setProductCount(rs.getInt("product_count"));
				cartList.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return cartList;
	}


	//ログイン時、カートに商品が入っているかどうか確認
	public boolean isAlreadyIntoCart(String userId, int productId) throws SQLException {
		System.out.println("isAlreadyIntoCart");
		boolean result = false;
		String sql = "SELECT * FROM cart_info WHERE user_id = ? AND product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = true;

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			con.close();

		}

		return result;
	}


	//ゲストユーザー時、カートに商品が入っているかどうか確認
	public boolean isAlreadyIntoTempCart(String tempUserId, int productId) throws SQLException {
		System.out.println("isAlreadyIntoTempCart");
		boolean result = false;
		String sql = "SELECT * FROM cart_info WHERE temp_user_id = ? AND product_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, tempUserId);
			ps.setInt(2, productId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				result = true;

			}

		} catch (SQLException e) {
			throw new RuntimeException(e);

		} finally {
			con.close();

		}

		return result;
	}


	//ログインユーザーのカート内商品の購入予定個数を変更
	public int updateUsersCount(int productCount, String userId, String productId) throws SQLException {
		System.out.println("updateUsersCount");
		int count = 0;
		String sql = "UPDATE cart_info SET product_count = product_count +" + productCount
				+ " WHERE user_id = ? AND product_id=?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productCount);
			ps.setString(2, userId);
			ps.setString(3, productId);

			count = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}

		return count;
	}

	//ゲストユーザーのカート内商品の購入予定個数を変更
	public int updateTempUsersCount(int productCount, String tempUserId) throws SQLException {
		System.out.println("updateTempUsersCount");
		int count = 0;
		String sql = "UPDATE cart_info SET count = ? WHERE temp_user_id = ?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productCount);
			ps.setString(2, tempUserId);

			count = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}

		return count;
	}
	public int UpdateProductCount(String userId, int productId, int productCount, int price) throws SQLException {
		System.out.println("UpdateProductCount");
		int count = 0;

		System.out.println(userId);

		System.out.println(productId);

		System.out.println(productCount);

		String sql = "UPDATE cart_info SET product_count=product_count +" + productCount
				+ " WHERE user_id=? AND product_id=?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, productId);
			count = ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
		return count;
	}
	//ログインをした際にカート内のユーザー情報を引き継ぐ←メソッド
	public void changeUserId(String tempUserId, String userId) throws SQLException {
		System.out.println("changeUserId");
		String sql = "UPDATE cart_info SET user_id=? , temp_user_id=? where temp_user_id=?";
		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, userId);
			ps.setString(3, tempUserId);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			con.close();
		}
	}

	//在庫更新
	public void changeProductStock(int productStock, int productId) throws SQLException {
		System.out.println("Stockを変更");
		String sql = "UPDATE product_info SET stock=stock-? WHERE product_id=?";

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

	public void changeProductStockId(int productStock, int productId,String userId) throws SQLException {
		System.out.println("Stockを変更");
		String sql = "UPDATE cart_info SET product_count=product_count+? WHERE product_id=? AND user_id=?";

		try {
			con = db.getConnection();
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setInt(1, productStock);
			ps.setInt(2, productId);
			ps.setString(3, userId);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}/* finally {
			con.close();
		}*/

	}

	//カート内の商品を1件ずつ削除
	public void deleteSeparate(String userId, Integer integer) {
		String sql = "DELETE FROM cart_info WHERE user_id = ? AND product_id=?";

		try {
			PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setLong(2, integer);

			ps.executeUpdate();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	}
