package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;
import com.internousdev.alatanapizza.util.DateUtil;

public class UserUpdateCompleteDAO {






	public int userUpdate(String newPassword,String newEmail,String familyName,String firstName,String familyNameKana,String firstNameKana,String user_id)throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql="update user_info set password=?,email=?,family_name=?,first_name=?,family_name_kana=?,first_name_kana=?,update_date=? where user_id=?";
		int count=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newPassword);
			ps.setString(2,newEmail);
			ps.setString(3,familyName);
			ps.setString(4,firstName);
			ps.setString(5,familyNameKana);
			ps.setString(6,firstNameKana);
			ps.setString(8,user_id);
			ps.setString(7,dateUtil.getDate());
			count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;

	}

	public int userUpdate2(String newEmail,String familyName,String firstName,String familyNameKana,String firstNameKana,String user_id)throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		DateUtil dateUtil = new DateUtil();
		String sql="update user_info set email=?,family_name=?,first_name=?,family_name_kana=?,first_name_kana=?,update_date=? where user_id=?";
		int count=0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newEmail);
			ps.setString(2,familyName);
			ps.setString(3,firstName);
			ps.setString(4,familyNameKana);
			ps.setString(5,firstNameKana);
			ps.setString(7,user_id);
			ps.setString(6,dateUtil.getDate());
			count=ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return count;

	}













}
