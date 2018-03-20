package com.internousdev.alatanapizza.dao;
//宛先登録の削除
//①全削除
//②個別削除
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.internousdev.alatanapizza.util.DBConnector;

public class DestinationDeleteDAO {


	//全削除
	public int deleteAllDestination(String userId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//deleteFlg.equals("1")
		String sql="DELETE FROM destination_info where user_id =?";

		int result = 0;

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,userId);
			result = ps.executeUpdate();

		}catch (SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;

	}

	//選択削除メソッド
	public int deletePartDestination(List<String>checkList)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		//(checkFlg.equals("2"))
		String sql = "DELETE FROM destination_info where id = ?";

		PreparedStatement ps =con.prepareStatement(sql);
		int result1=0;

		try{
			for(int i=0;i<checkList.size();i++){
				String checkId =checkList.get(i);
				ps.setString(1, checkId);
				result1+=ps.executeUpdate();
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result1;
	}








	}//







