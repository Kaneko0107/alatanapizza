package com.internousdev.alatanapizza.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.internousdev.alatanapizza.dto.ProductSearchDTO;
import com.internousdev.alatanapizza.util.DBConnector;


/**
 * @author internousdev
 * @author kei-kenmochi
 *
 */
public class ProductSearchDAO {
	private DBConnector db = new DBConnector();
	private Connection con = db.getConnection();


	/**
	 * 全ての商品を検索
	 *
	 * @return ProductsearchDTOList
	 */
	public ArrayList<ProductSearchDTO> allProductInfo() {
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		String sql = "SELECT * FROM product_info";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}



	/**
	 *商品を検索(カテゴリー「全ての商品」を選んだ場合)
	 *
	 * @param serchWord
	 * @return searchDTOList
	 */
	public ArrayList<ProductSearchDTO> bySearchWordAllCategory(String searchWordHiragana, String searchWord) {
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		  String sql = "SELECT * FROM product_info WHERE product_name LIKE \'%" + searchWord + "%\'"
		  		+ " OR product_name_kana LIKE \'%" + searchWordHiragana + "%\'"
		  				+ " OR product_description LIKE \'%" + searchWord + "%\'";

//	       String sql = "SELECT * FROM product_info WHERE product_name LIKE \'%" + searchWord + "%\'"
//					+ " OR product_name_kana LIKE \'%" + searchWordHiragana + "%\'"
//						+ " OR product_description LIKE \'%" + searchWord + "%\'"
//						+ " AND category_id=\'" + categoryId + "\'";


		try {
//			String sql = "SELECT * FROM product_info WHERE product_name LIKE \'%" + searchWord + "%\' OR product_name_kana LIKE \'%"
//					+ searchWordHiragana + "%\' OR product_description LIKE \'%" + searchWord + "%\'";

			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, searchWord);
//			ps.setString(2, searchWordHiragana);
//			ps.setString(3, searchWord);
//			if (categoryId != 1) {
//				ps.setInt(4, categoryId);
//			}
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}


	/*
	 * 商品を検索（「全ての商品」以外を指定した場合)
	 */
	public ArrayList<ProductSearchDTO> bySearchWord(String searchWordHiragana, String searchWord, int categoryId) {
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		  String sql = "SELECT * FROM product_info WHERE (product_name LIKE \'%" + searchWord + "%\'"
		  		+ " OR product_name_kana LIKE \'%" + searchWordHiragana + "%\'"
		  				+ " OR product_description LIKE \'%" + searchWord + "%\')"
		  				+ " AND category_id=?";

		try {
			System.out.println(sql);
			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, searchWord);
//			ps.setString(2, searchWordHiragana);
//			ps.setString(3, searchWord);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}

	/**
	 * カテゴリのみで検索
	 *
	 * @param categoryId
	 * @return searchDTOList
	 */
	public ArrayList<ProductSearchDTO> byProductCategory(int categoryId) {
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		String sql = "SELECT*FROM product_info WHERE category_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}



	/*
	 * 複数検索
	 */
	public ArrayList<ProductSearchDTO> byWords(String[] serchWords, String[] keywords, int categoryId) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		String sql = "SELECT * FROM product_info WHERE ";

		for (int s = 0; s < serchWords.length; s++) {
			if (s != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
						+ serchWords[s] + "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			} else {
				sql = sql + " (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
			                  + serchWords[s]+ "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			}
		}

		if (categoryId > 1) {
			sql = sql + "AND category_id=?";
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			if (categoryId > 1) {
				ps.setInt(1, categoryId);
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}

	/*
	 * 複数検索(「全ての商品」を選んだ場合)
	 */
	public ArrayList<ProductSearchDTO> byWordsAllCategory(String[] serchWords, String[] keywords) {
		DBConnector db = new DBConnector();
		Connection con = db.getConnection();
		ArrayList<ProductSearchDTO> searchDTOList = new ArrayList<ProductSearchDTO>();
		String sql = "SELECT * FROM product_info WHERE ";

		for (int s = 0; s < serchWords.length; s++) {
			if (s != 0) {
				sql = sql + " AND (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
						+ serchWords[s] + "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			} else {
				sql = sql + " (product_name LIKE '%" + keywords[s] + "%' OR product_name_kana LIKE '%"
			                  + serchWords[s]+ "%' OR product_description LIKE '%" + keywords[s] + "%') ";

			}
		}

		try {
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductSearchDTO searchDTO = new ProductSearchDTO();
				searchDTO.setId(rs.getInt("id"));
				searchDTO.setProductId(rs.getInt("product_id"));
				searchDTO.setProductName(rs.getString("product_name"));
				searchDTO.setProductNameKana(rs.getString("product_name_kana"));
				searchDTO.setProductDescription(rs.getString("product_description"));
				searchDTO.setCategoryId(rs.getInt("category_id"));
				searchDTO.setMSizePrice(rs.getInt("msize_price"));
				searchDTO.setLSizePrice(rs.getInt("lsize_price"));
				searchDTO.setPrice(rs.getInt("price"));
				searchDTO.setStock(rs.getInt("stock"));
				searchDTO.setImageFileName(rs.getString("image_file_name"));
				searchDTO.setReleaseDate(rs.getDate("release_date"));
				searchDTO.setReleaseCompany(rs.getString("release_company"));
				searchDTO.setStatus(rs.getShort("status"));
				searchDTO.setRegistDate(rs.getDate("regist_date"));
				searchDTO.setUpdateDate(rs.getDate("update_date"));
				searchDTOList.add(searchDTO);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return searchDTOList;

	}
}