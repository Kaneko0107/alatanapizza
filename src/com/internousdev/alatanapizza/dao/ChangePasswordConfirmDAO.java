package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.alatanapizza.dto.ChangePasswordDTO;
import com.internousdev.alatanapizza.util.DBConnector;

public class ChangePasswordConfirmDAO{


	public  ChangePasswordDTO CheckAnswer(String userid){
		ChangePasswordDTO result = null;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		try{

			String sql="select * from user_info where user_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
					ChangePasswordDTO CPDTO=new ChangePasswordDTO();
				CPDTO.setPassword(rs.getString("password"));
				CPDTO.setUserid(rs.getString("user_id"));
				CPDTO.setAnswer(rs.getString("secret_answer"));
				CPDTO.setQuestion(rs.getInt("secret_question"));
				result=CPDTO;

				}




		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	}









}





