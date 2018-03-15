package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.DBConnector;
import com.internousdev.alatanapizza.util.DateUtil;

public class MasterProductDAO {
	private DBConnector dbConnector=new DBConnector();

	private Connection connection=dbConnector.getConnection();

	private ProductDTO productDTO =new ProductDTO();

	private DateUtil dateUtil=new DateUtil();

	private String sql="INSERT INTO product_info (product_id, product_name, price, stock, regist_date, product_name_kana, product_description, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

	public ProductDTO productDTO(String itemName, String itemKanaName, String itemPrice, String itemStock) throws SQLException{

		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, Double.valueOf(Math.random() * 1000).toString());
			ps.setString(2, itemName);
			ps.setString(3, itemPrice);
			ps.setString(4, itemStock);
			ps.setString(5, dateUtil.getDate());
			ps.setString(6, itemKanaName);
			ps.setString(7, "11");
			ps.setString(8, "11");


			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			connection.close();
		}

		return productDTO;
	}
}
