package com.internousdev.alatanapizza.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.DBConnector;



public class MasterAddConfirmDAO {

	private DBConnector dbConnector=new DBConnector();

	private Connection connection=dbConnector.getConnection();

	ProductDTO dto=new ProductDTO();


	private String sql="SELECT * from product_info where product_name= ? or product_name_kana = ?";



	public boolean checkItemInfo(String itemName,String itemKanaName) throws SQLException{

		try{
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setString(1, itemName);
			preparedStatement.setString(2, itemKanaName);


			ResultSet resultSet=preparedStatement.executeQuery();
			return resultSet.next();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			connection.close();
		}
	}
}

