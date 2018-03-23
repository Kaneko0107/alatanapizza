package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.MyPageDTO;
import com.internousdev.alatanapizza.util.DBConnector;

public class MyPageDAO {


	/**
	 * ユーザー情報を取得
	 *
	 * @return myPageList
	 */
	public ArrayList<MyPageDTO> getMyPageUserInfo(String userId) {
		MyPageDTO myPageDTO = new MyPageDTO();
		ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM user_info where user_id = ? ";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				myPageDTO.setUserId(rs.getString("user_id"));

				myPageDTO.setFamilyName(rs.getString("family_name"));

				myPageDTO.setFirstName(rs.getString("first_name"));

				myPageDTO.setFamilyNameKana(rs.getString("family_name_kana"));

				myPageDTO.setFirstNameKana(rs.getString("first_name_kana"));

				myPageDTO.setSex(rs.getBoolean("sex"));

				myPageDTO.setEmail(rs.getString("email"));

				myPageDTO.setPassword(rs.getString("password"));

				myPageDTO.setSecretQuestion(rs.getInt("secret_question"));

				myPageDTO.setSecretAnswer(rs.getString("secret_answer"));


				myPageList.add(myPageDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return myPageList;
	}

}
