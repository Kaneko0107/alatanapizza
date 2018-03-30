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

	private String sql="INSERT INTO product_info (product_id, product_name, image_file_path, image_file_name, price, msize_price, lsize_price, stock, regist_date, update_date, product_name_kana, product_description, category_id, release_company, release_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'ALATANAPIZZA', NOW(), 1)";

	public ProductDTO productDTO(String itemName, String itemKanaName, String itemPrice, String itemStock, String imageName) throws SQLException{

		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			int i = 1;
			ps.setInt(i++, Integer.valueOf((int) (Math.random() * 1000000)));
			ps.setString(i++, itemName);
			ps.setString(i++, "./images/newSide/" + imageName); // サイドメニューのみ
			ps.setString(i++, imageName);
			ps.setString(i++, itemPrice);
			ps.setInt(i++, 0); // ピザのMサイズ用の値段。今はサイドメニューしか対応しないので固定で0
			ps.setInt(i++, 0); // ピザのLサイズ用の値段。今はサイドメニューしか対応しないので固定で0
			ps.setString(i++, itemStock);
			ps.setString(i++, dateUtil.getDate());
			ps.setString(i++, dateUtil.getDate());
			ps.setString(i++, itemKanaName);
			ps.setString(i++, "新商品！");//今はコメント変更付加
			ps.setString(i++, "3"); // 今はサイドメニューのみ対応
			
			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			connection.close();
		}

		return productDTO;
	}
}
