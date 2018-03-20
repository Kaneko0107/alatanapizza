package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.alatanapizza.dto.ChangePasswordDTO;
import com.internousdev.alatanapizza.util.DBConnector;

public class ChangePasswordConfirmDAO{


	public  ChangePasswordDTO CheckAnswer(String userid,int question,String answer){
		ChangePasswordDTO result = null;
		DBConnector db=new DBConnector();
		Connection con=db.getConnection();


		try{

			String sql="select * from user_info where user_id=? and secret_question=? and secret_answer=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setInt(2,question);
			ps.setString(3,answer);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
					ChangePasswordDTO CPDTO=new ChangePasswordDTO();
				CPDTO.setPassword(rs.getString("password"));
				CPDTO.setUserid(rs.getString("user_id"));
				CPDTO.setAnswer(rs.getString("secret_answer"));
				result=CPDTO;

				}




		}catch(Exception e){
			e.printStackTrace();
		}

		return result;
	}









}





