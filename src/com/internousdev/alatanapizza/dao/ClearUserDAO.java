package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;

public class ClearUserDAO {

	public int deleteUserInfo(String user_id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		String sql="DELETE FROM user_info WHERE user_id = ?";
		int result = 0;
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1,user_id);
			result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
	public int deleteCartInfo(String user_id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		String sql="DELETE FROM cart_info WHERE user_id = ?";
		int result =0;
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,user_id);
		result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}

	public int deleteFavoriteInfo(String user_id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		String sql="DELETE FROM favorite_info WHERE user_id = ?";
		int result =0;
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,user_id);
		result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
	public int deletePurchaseHistoryInfo(String user_id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		String sql="DELETE FROM purchase_history_info WHERE user_id = ?";
		int result =0;
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,user_id);
		result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}
	public int deleteDestinationInfo(String user_id) throws SQLException{
		DBConnector db=new DBConnector();
		Connection con = db.getConnection();
		String sql="DELETE FROM destination_info WHERE user_id = ?";
		int result =0;
		try{
			PreparedStatement preparedStatement = con.prepareStatement(sql);
		preparedStatement.setString(1,user_id);
		result = preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;
	}



}
