package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.internousdev.alatanapizza.dto.ProductDTO;
import com.internousdev.alatanapizza.util.DBConnector;

public class ProductDetailsDAO {

	// 商品詳細情報取得( getProductDetailsInfo)
	public ProductDTO getProductDetailsInfo(String product_id) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ProductDTO dto = new ProductDTO();
		String sql = "SELECT * FROM product_info where product_id=? AND status = 1";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product_id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				dto.setId(rs.getInt("id"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setProduct_description(rs.getString("product_description"));
				dto.setCategory_id(rs.getInt("category_id"));
				dto.setMsize_price(rs.getInt("msize_price"));
				dto.setLsize_price(rs.getInt("lsize_price"));
				dto.setPrice(rs.getInt("price"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setRelease_date(rs.getString("release_date"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setRegist_date(rs.getDate("regist_date"));
				dto.setUpdate_date(rs.getDate("update_date"));
				dto.setStock(rs.getInt("stock"));
			} else {
				dto = null;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return dto;
	}


	// 商品詳細情報取得(getProductDetailsInfoList)
	public List<ProductDTO> getProductDetailsInfoList(String[] productIdList) throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		ArrayList<ProductDTO> detailsList = new ArrayList<>();
		for (int i = 0; i < productIdList.length; i++) {

			String sql = "SELECT * FROM product_info where product_id = ? AND status = 1";

			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, String.valueOf(productIdList[i]));
				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					ProductDTO dto = new ProductDTO();

					dto.setId(rs.getInt("id"));
					dto.setProduct_id(rs.getInt("product_id"));
					dto.setProduct_name(rs.getString("product_name"));
					dto.setProduct_name_kana(rs.getString("product_name_kana"));
					dto.setProduct_description(rs.getString("product_description"));
					dto.setCategory_id(rs.getInt("category_id"));
					dto.setMsize_price(rs.getInt("msize_price"));
					dto.setLsize_price(rs.getInt("lsize_price"));
					dto.setPrice(rs.getInt("price"));
					dto.setImage_file_path(rs.getString("image_file_path"));
					dto.setImage_file_name(rs.getString("image_file_name"));
					dto.setRelease_date(rs.getString("release_date"));
					dto.setRelease_company(rs.getString("release_company"));
					dto.setRegist_date(rs.getDate("regist_date"));
					dto.setUpdate_date(rs.getDate("update_date"));
					dto.setStock(rs.getInt("stock"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return detailsList;
	}


	// おすすめ商品リスト
	public ArrayList<ProductDTO> getSuggestProductInfo(String product_id) throws SQLException {
		ArrayList<ProductDTO> suggestList = new ArrayList<ProductDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		//商品を3件取得
		String sql = "SELECT * FROM product_info WHERE status = 1 AND product_id NOT IN(?) ORDER BY RAND() LIMIT 3";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, product_id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductDTO dto = new ProductDTO();

				dto.setId(rs.getInt("id"));
				dto.setProduct_id(rs.getInt("product_id"));
				dto.setProduct_name(rs.getString("product_name"));
				dto.setProduct_name_kana(rs.getString("product_name_kana"));
				dto.setProduct_description(rs.getString("product_description"));
				dto.setCategory_id(rs.getInt("category_id"));
				dto.setMsize_price(rs.getInt("msize_price"));
				dto.setLsize_price(rs.getInt("lsize_price"));
				dto.setPrice(rs.getInt("price"));
				dto.setImage_file_path(rs.getString("image_file_path"));
				dto.setImage_file_name(rs.getString("image_file_name"));
				dto.setRelease_date(rs.getString("release_date"));
				dto.setRelease_company(rs.getString("release_company"));
				dto.setRegist_date(rs.getDate("regist_date"));
				dto.setUpdate_date(rs.getDate("update_date"));
				dto.setStock(rs.getInt("stock"));

				suggestList.add(dto);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return suggestList;
	}


    /* トッピング情報の取得 */
    public ArrayList<ProductDTO> getToppingInfo() throws SQLException {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
        ArrayList<ProductDTO> toppingList = new ArrayList<ProductDTO>();

        String sql = "SELECT * FROM m_topping";

        try {
           PreparedStatement ps = con.prepareStatement(sql);

           ResultSet rs = ps.executeQuery();

           while(rs.next()) {
              ProductDTO dto = new ProductDTO();
              dto.setId(rs.getInt("id"));
              dto.setTopping_id(rs.getInt("topping_id"));
              dto.setTopping_name(rs.getString("topping_name"));
              dto.setMsize_price(rs.getInt("msize_price"));
              dto.setLsize_price(rs.getInt("lsize_price"));
              dto.setInsert_date(rs.getDate("insert_date"));
              dto.setUpdate_date(rs.getDate("update_date"));
              toppingList.add(dto);
           }
        } catch (Exception e) {
           e.printStackTrace();
        } finally {
           con.close();
        }
        return toppingList;
    }



}