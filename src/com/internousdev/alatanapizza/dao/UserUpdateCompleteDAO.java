package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;
import com.internousdev.alatanapizza.util.DateUtil;

public class UserUpdateCompleteDAO {


	public int userUpdatePassword(String newPassword,String user_id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql="update user_info set password=?,update_date=? where user_id=?";
		int count=0;

		try{
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1,newPassword);
		ps.setString(2,dateUtil.getDate());
		ps.setString(3,user_id);
		count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;

	}

	public int userUpdateEmail(String newEmail,String user_id) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql="update user_info set email=?,update_date=? where user_id=?";
		int count=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newEmail);
			ps.setString(2,dateUtil.getDate());
			ps.setString(3,user_id);
			count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;
	}

	public int userUpdateDouble(String newPassword,String newEmail,String user_id)throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql="update user_info set password=?,email=?,update_date=? where user_id=?";
		int count=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newPassword);
			ps.setString(2,newEmail);
			ps.setString(3,dateUtil.getDate());
			ps.setString(4,user_id);
			count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;

	}















}
