package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.util.DBConnector;

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
	 */

	String sql="INSERT INTO destination_info("
			+ "user_id"
			+ ",family_name"
			+ ",first_name"
			+ ",family_name_kana"
			+ ",first_name_kana"
			+ ",user_address"
			+ ",tel_number"
			+ ",email"
			+ ",postal_code"
			+ ",regist_date"
			+ ")VALUES(?,?,?,?,?,?,?,?,?,NOW())";
	try{
		System.out.println("INSERTsql文実行");
		con =db.getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setString(1, destinationDTO.getUserId());
		ps.setString(2, destinationDTO.getFamilyName());
		ps.setString(3, destinationDTO.getFirstName());
		ps.setString(4, destinationDTO.getFamilyNameKana());
		ps.setString(5, destinationDTO.getFirstNameKana());
		ps.setString(6, destinationDTO.getAddr11());
		ps.setString(7, destinationDTO.getTelNumber());
		ps.setString(8, destinationDTO.getEmail());
		ps.setString(9, destinationDTO.getZip11());

		updateCount = ps.executeUpdate();

	}catch(SQLException e){
		//例外時
		e.printStackTrace();
	}finally{
		//接続を切る
		con.close();
	}

	if(updateCount==1){
		result =true;
	}
	return result;
}

	//指定したユーザーの宛先情報取得 obtaining==入手
	public ArrayList<DestinationDTO> obtainingDestinationInfo(String userId)throws SQLException{
		ArrayList<DestinationDTO> destinationList =new ArrayList<DestinationDTO>();


		String sql ="SELECT id"
				+ ",family_name"
				+ ",first_name"
				+ ",family_name_kana"
				+ ",first_name_kana"
				+ ",user_address"
				+ ",tel_number"
				+ ",email"
				+ ",postal_code"
				+ " FROM destination_info WHERE user_id =?";

		try{

			con =db.getConnection();
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, userId);
			ResultSet rs =ps.executeQuery();

			while(rs.next()){
				DestinationDTO destinationDTO =new DestinationDTO();
				destinationDTO.setId(rs.getInt("id")); //int型でidをsessionから取り出し
				destinationDTO.setFamilyName(rs.getString("family_name")); //String型でfamily_nameをsessionから取り出し
				destinationDTO.setFirstName(rs.getString("first_name"));
				destinationDTO.setFamilyNameKana(rs.getString("family_name_kana"));
				destinationDTO.setFirstNameKana(rs.getString("first_name_kana"));
				destinationDTO.setEmail(rs.getString("email"));
				destinationDTO.setTelNumber(rs.getString("tel_number"));
				destinationDTO.setZip11(rs.getString("postal_code"));
				destinationDTO.setAddr11(rs.getString("user_address"));
				destinationList.add(destinationDTO);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return destinationList;
	}
}

