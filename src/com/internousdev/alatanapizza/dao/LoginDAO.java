package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.alatanapizza.dto.LoginDTO;
import com.internousdev.alatanapizza.util.DBConnector;

public class LoginDAO  {

	private LoginDTO loginDTO=new LoginDTO();
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	public LoginDTO select(String userId,String password){

		String sql="select * from user_info where user_id = ? and password = ?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);

			ps.setString(1, userId);
			ps.setString(2, password);

			ResultSet rs=ps.executeQuery();

			if(rs.next()){

				loginDTO.setUserId(rs.getString("user_id"));
				loginDTO.setPassword(rs.getString("password"));
				loginDTO.setFamilyName(rs.getString("family_name"));
				loginDTO.setFirstName(rs.getString("first_name"));
				loginDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				loginDTO.setFirstNameKana(rs.getString("first_name_kana"));
				loginDTO.setEmail(rs.getString("email"));
				loginDTO.setMaster(rs.getBoolean("master"));
				}else{
				loginDTO.setUserId("noID");
				loginDTO.setPassword("noPASS");
			}
		}catch(SQLException e){

			e.printStackTrace();
		}
		return loginDTO;

	}

	//ログイン判定
	public boolean login(LoginDTO loginDTO)throws SQLException{
		boolean result = false;
		int updateCount =  0;
		DBConnector db= new DBConnector();
		Connection con = db.getConnection();

		//ログインしたユーザーのログインフラグの値を1にする
		String sql = "UPDATE user_info SET logined=1 WHERE user_id=?";
		try{ //例外が発生する可能性のある処理
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginDTO.getUserId());
			updateCount=ps.executeUpdate();
			//カウントが1以上ならtrue
			if(updateCount>0){
				result =true;
			}
		}catch(SQLException e){ //例外が発生した場合の処理(例外が発生しなければ行われない処理)

			e.printStackTrace();

		}finally{ //例外の有無に関わらず、最後に必ず実行される処理
			con.close();
		}
		return result;
	}

	//userIdが存在するかどうかのチェック
	public boolean existsUserId(String userId)throws SQLException{
		boolean result = false;
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info WHERE user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();

		}finally{
			con.close();
		}
		return result;
	}
}

