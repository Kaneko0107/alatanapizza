package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import com.internousdev.alatanapizza.util.DBConnector;


public class ChangePasswordCompleteDAO {

	private DBConnector db=new DBConnector();
	Connection con=db.getConnection();
	public Map<String,Object>session;
	private String newpass;
	private String userid;
	private String secret_answer;
	private int result=0;
	private String sql="update user_info set password=? where user_id=? and secret_answer=?";

	public int changeComplete(String newpass,String userid,String secret_answer) throws SQLException{
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
		System.out.println(result);
		return result;

	}








	public String getNewpass() {
		return newpass;
	}
	public void setNewpass(String newpass) {
		this.newpass = newpass;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getSecret_answer() {
		return secret_answer;
	}
	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}








	public int getResult() {
		return result;
	}








	public void setResult(int result) {
		this.result = result;
	}







}
