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

	private String sql="INSERT INTO product_info (product_id, product_name, price, msize_price, lsize_price, stock, regist_date, update_date, product_name_kana, product_description, category_id, release_company, release_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 'ALATANAPIZZA', NOW())";

	public ProductDTO productDTO(String itemName, String itemKanaName, String itemPrice, String itemStock) throws SQLException{

		try{
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setInt(1, Integer.valueOf((int) (Math.random() * 1000000)));
			ps.setString(2, itemName);
			ps.setString(3, itemPrice);
			ps.setInt(4, 0); // ピザのMサイズ用の値段。今はサイドメニューしか対応しないので固定で0
			ps.setInt(5, 0); // ピザのLサイズ用の値段。今はサイドメニューしか対応しないので固定で0
			ps.setString(6, itemStock);
			ps.setString(7, dateUtil.getDate());
			ps.setString(8, dateUtil.getDate());
			ps.setString(9, itemKanaName);
			ps.setString(10, "商品説明。まだ変更できません。。");
			ps.setString(11, "3"); // 今はサイドメニューのみの対応とします。

			System.out.println(ps);
			ps.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e);
		}finally{
			connection.close();
		}

		return productDTO;
	}
}
