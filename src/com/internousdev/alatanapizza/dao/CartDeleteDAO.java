package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;


public class CartDeleteDAO {

	public int AlldeleteCart(String userId){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart_info WHERE user_id=?";
		int res =0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userId);
			res=ps.executeUpdate();


		}catch(SQLException e){
			throw new RuntimeException(e);

		}return res;
	}

	public int PartDeleteCart(String userId,String productid){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart_info WHERE user_id=? AND id=?";
		int res=0;
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			ps.setString(2,productid);
			res=ps.executeUpdate();

		}catch(SQLException e){
			throw new RuntimeException(e);

		}return res;
	}


	public int AlldeleteCartGest(String tempUserId){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart_info WHERE user_id = ?";
		int res=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, tempUserId);
			res=ps.executeUpdate();


		}catch(SQLException e){
			throw new RuntimeException(e);

		}return res;
	}

	public int PartDeleteCartGest(String tempUserId,String productid){
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="DELETE FROM cart_info WHERE user_id=? AND id=?";
		int res=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,tempUserId);
			ps.setString(2,productid);
			res=ps.executeUpdate();


		}catch(SQLException e){
			throw new RuntimeException(e);

		}return res;
	}
}

