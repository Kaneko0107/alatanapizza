package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.internousdev.alatanapizza.util.DBConnector;


public class DestinationKessaiDAO {
	/**
	 * DBにコネクトするため
	 */
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();

	//指定したユーザーの宛先情報取得 obtaining==入手
	public ArrayList<DestinationDTO> obtainingDestinationInfo(String userId)throws SQLException{
		ArrayList<DestinationDTO> destinationList =new ArrayList<DestinationDTO>();

		String sql ="SELECT id,family_name,first_name,family_name_kana,first_name_kana,"
				+ "user_address,tel_number,email,postal_code FROM destination_info WHERE user_id =?";

		try{

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
				destinationDTO.setAddr11(rs.getString("user_address"));
				destinationDTO.setTelNumber(rs.getString("tel_number"));
				destinationDTO.setEmail(rs.getString("email"));
				destinationDTO.setZip11(rs.getString("postal_code"));
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


