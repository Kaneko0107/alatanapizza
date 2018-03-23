package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.alatanapizza.dto.UserUpdateDTO;
import com.internousdev.alatanapizza.util.DBConnector;


public class UserUpdateConfirmDAO {



	public Map<String,Object> session;

	public UserUpdateDTO getUserInfo(String user_id){
		UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql="select * from user_info where  user_id=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,user_id);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				userUpdateDTO.setUser_id(rs.getString("user_id"));
				userUpdateDTO.setPassword(rs.getString("password"));
				userUpdateDTO.setEmail(rs.getString("email"));
				userUpdateDTO.setFamilyName(rs.getString("family_name"));
				userUpdateDTO.setFirstName(rs.getString("first_name"));
				userUpdateDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				userUpdateDTO.setFirstNameKana(rs.getString("first_name_kana"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return userUpdateDTO;
	}


}
