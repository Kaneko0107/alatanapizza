package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;


public class ChangePasswordCompleteDAO {


	private int result;


	public int changeComplete(String newpass,String userid,String secret_answer) throws SQLException{
		result=0;

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		String sql="update user_info set password=? where user_id=? and secret_answer=?";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,newpass);
			ps.setString(2, userid);
			ps.setString(3, secret_answer);
			ps.executeUpdate();
			result=ps.executeUpdate();


		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return result;

	}










}



