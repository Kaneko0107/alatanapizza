package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.alatanapizza.dto.UserUpdateDTO;
import com.internousdev.alatanapizza.util.DBConnector;


public class UserUpdateConfirmDAO {

	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();
	UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
	public Map<String,Object> session;

	public UserUpdateDTO getUserInfo(String password,String user_id){
		String sql="select * from user_info where password=? and user_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,password);
			ps.setString(2,user_id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				userUpdateDTO.setUser_id(rs.getString("user_id"));
				userUpdateDTO.setPassword(rs.getString("password"));
				userUpdateDTO.setEmail(rs.getString("email"));
				return userUpdateDTO;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userUpdateDTO;
	}


}
