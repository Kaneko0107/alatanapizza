package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.util.DBConnector;


/**
 * ログインフラグ？
 * ログインした状態であるかの判定が必要かどうか不安
 * とりあえずデータ格納できるようには書いた
 * @author internousdev
 *
 */
public class DestinationDAO {
	/**
	 * DBにコネクトするため
	 */
	DBConnector db = new DBConnector();
	Connection con =null;
	/**
	 * 更新日をつけるためのインポート
	 */
	public boolean registerDestination(DestinationDTO destinationDTO) throws SQLException{

	int updateCount =0;
	boolean result =false;
	/**
	 * sql文生成
	 *
	 *
	 */


	//■高木君へ　性別情報を全てコメントにしているので、ＳＱＬ文の「？」の数もひとつ減らしています。
	//実行する際に？を足してください！！　3/15　上原

	String sql="INSERT INTO destination_info("
			+ "user_id"
			+ ",family_name"
			+ ",first_name"
			+ ",family_name_kana"
			+ ",first_name_kana"
			+ ",user_address"
			+ ",tel_number"
			+ ",email"
			+ ",regist_date"
			+ ")VALUES(?,?,?,?,?,?,?,?,NOW())";
	try{
		System.out.println("INSERTsql文実行");
		con =db.getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, destinationDTO.getUserId());
		ps.setString(2, destinationDTO.getFamilyName());
		ps.setString(3, destinationDTO.getFirstName());
		ps.setString(4, destinationDTO.getFamilyNameKana());
		ps.setString(5, destinationDTO.getFirstNameKana());
		ps.setString(6, destinationDTO.getUserAddress());
		ps.setString(7, destinationDTO.getTelNumber());
		ps.setString(8, destinationDTO.getEmail());
//		System.out.println(ps);
		updateCount = ps.executeUpdate();

	}catch(SQLException e){
		//エラーになったらエラー文
		System.out.println("例外が発生しました");
		e.printStackTrace();
	}finally{
		//接続を切る
		con.close();
	}

	if(updateCount==1){
		result =true;
	}
	System.out.println(result);
	return result;
}

	//指定したユーザーの宛先情報取得 obtaining==入手
	public ArrayList<DestinationDTO> obtainingDestinationInfo(String userId)throws SQLException{
		ArrayList<DestinationDTO> destinationList =new ArrayList<DestinationDTO>();


		String sql ="SELECT id,family_name,first_name,family_name_kana,first_name_kana,"
				+ "user_address,tel_number,email FROM destination_info WHERE user_id =?";

		try{

			con =db.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs =ps.executeQuery();
			System.out.println("SELECTsql文実行");

			while(rs.next()){
				DestinationDTO destinationDTO =new DestinationDTO();
				destinationDTO.setId(rs.getInt("id")); //int型でidをsessionから取り出し
				destinationDTO.setFamilyName(rs.getString("family_name")); //String型でfamily_nameをsessionから取り出し
				destinationDTO.setFirstName(rs.getString("first_name"));
				destinationDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationDTO.setEmail(rs.getString("email"));
				destinationDTO.setTelNumber(rs.getString("tel_number"));
				destinationDTO.setUserAddress(rs.getString("user_address"));
				destinationList.add(destinationDTO);
			}
		}catch(SQLException e){
			System.out.println("例外が発生しました");
			e.printStackTrace();
		}finally{
			con.close();
		}
		return destinationList;
	}
}

	/*	/**
	 * 値定義
	 * @param userId
	 * @param familyName
	 * @param firstName
	 * @param familyNameKana
	 * @param firstNameKana
	 * @param email
	 * @param telNumber
	 * @param userAddress
	 * @throws SQLException
	 */

	/*
	public void createDestination(
			String userId,
			String familyName,
			String firstName,
			String familyNameKana,
			String firstNameKana,
			String email,
			String telNumber,
			String userAddress)throws SQLException{
		/**
		 * IDはSQLファイルのほうでAUTO_INCREMENTがされているので
		 * その他の項目をpreparedStatementでセットさせてる
		 *

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, familyName);
			preparedStatement.setString(3, firstName);
			preparedStatement.setString(4, familyNameKana);
			preparedStatement.setString(5, firstNameKana);
			preparedStatement.setString(6, email);
			preparedStatement.setString(7, telNumber);
			preparedStatement.setString(8, userAddress);
			preparedStatement.setString(9, dateUtil.getDate());

			preparedStatement.execute();

		}catch(Exception e){
			/**
			 * エラーなったらエラー文出す
			 *
			e.printStackTrace();
		}finally{
			/**
			 * 切断
			 *
			con.close();
		}
	}

*/
