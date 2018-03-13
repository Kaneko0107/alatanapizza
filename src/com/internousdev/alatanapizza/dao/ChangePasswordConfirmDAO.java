package com.internousdev.alatanapizza.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.internousdev.alatanapizza.util.DBConnector;

public class ChangePasswordConfirmDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	public Map<String,Object>session;

	private String password;
	private String userid;
	private String secret_answer;

	private boolean result=false;
	public boolean CheckAnswer(String userid,int secret_question,String secret_answer){

		try{
			//値の確認出力
			System.out.println(userid);
			System.out.println(secret_answer);
			System.out.println(secret_question);

			String sql="select * from user_info where user_id=? and secret_question=? and secret_answer=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userid);
			ps.setInt(2,secret_question);
			ps.setString(3,secret_answer);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
					result=true;
				setPassword(rs.getString("password"));
				setUserid(rs.getString("user_id"));
				setSecret_answer(rs.getString("secret_answer"));


				}
			//値の確認出力



		}catch(Exception e){
			e.printStackTrace();
		}
		//値の確認出力
		System.out.println(result);
		return result;
	}

	public String getSecret_answer() {
		return secret_answer;
	}

	public void setSecret_answer(String secret_answer) {
		this.secret_answer = secret_answer;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;







}}





