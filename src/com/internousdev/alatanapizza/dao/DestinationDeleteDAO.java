package com.internousdev.alatanapizza.dao;
//宛先登録の削除
//①全削除
//②個別削除
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.util.DBConnector;

public class DestinationDeleteDAO {


	//全削除
	public int deleteAllDestination(String userId) throws SQLException{
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();


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
	public int deletePartDestination(int Id)throws SQLException{

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "DELETE FROM destination_info where id = ?";


		int result=0;



		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,Id);
			result = ps.executeUpdate();






		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			con.close();
		}
		return result;
	}








	}







