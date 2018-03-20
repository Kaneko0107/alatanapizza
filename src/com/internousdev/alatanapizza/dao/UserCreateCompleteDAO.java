package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;
import com.internousdev.alatanapizza.util.DateUtil;


public class UserCreateCompleteDAO {


	private String sql="INSERT INTO user_info(user_id,password,family_name,first_name,family_name_kana,first_name_kana,sex,email,secret_question,secret_answer,regist_date) VALUES(?,?,?,?,?,?,?,?,?,?,?)";


	// UserCreateCompleteActionで受け取ったユーザー情報をsqlに流す
	public void createUser(String userid, String password, String familyname, String firstname, String familynamekana,String firstnamekana, int sex, String email, int secretquestion, String secretanswer) throws SQLException {

		DBConnector db=new DBConnector();
		Connection con=db.getConnection();
		DateUtil dateUtil=new DateUtil();

		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, userid);
			ps.setString(2, password);
			ps.setString(3, familyname);
			ps.setString(4, firstname);
			ps.setString(5, familynamekana);
			ps.setString(6, firstnamekana);
			ps.setInt(7, sex);
			ps.setString(8, email);
			ps.setInt(9, secretquestion);
			ps.setString(10, secretanswer);
			ps.setString(11, dateUtil.getDate());
            ps.execute();

		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
		    con.close();
		}
        }
}

