package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.CartInfoDTO;
import com.internousdev.alatanapizza.dto.ProductDTO;

public class ProductDTOTest {

	//IDに関するテスト
	@Test
	public void testGetId1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetDef_id5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品IDに関するテスト
	@Test
	public void testGetProduct_id1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());

	}
	@Test
	public void testGetProduct_id2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());
	}
	@Test
	public void testGetProduct_id3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setProduct_id(expected);

		assertEquals(expected, dto.getProduct_id());
	}
	@Test
	public void testGetProduct_id4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProduct_id(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProduct_id5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProduct_id(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}


	//カテゴリーIDに関するテスト
		@Test
		public void testGetCategory_id1() {
			ProductDTO dto = new ProductDTO();
			int expected = 0;

			dto.setCategory_id(expected);

			assertEquals(expected, dto.getCategory_id());

		}
		@Test
		public void testGetCategory_id2() {
			ProductDTO dto = new ProductDTO();
			int expected = 2147483647;

			dto.setCategory_id(expected);

			assertEquals(expected, dto.getCategory_id());
		}
		@Test
		public void testGetCategory_id3() {
			ProductDTO dto = new ProductDTO();
			int expected = -2147483647;

			dto.setCategory_id(expected);

			assertEquals(expected, dto.getCategory_id());
		}
		@Test
		public void testGetCategory_id4() throws Exception {
			ProductDTO dto = new ProductDTO();
		    try{
		    	int postalMax = Integer.parseInt("2147483648");
		    	dto.setCategory_id(postalMax);

		    } catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		    }
		}
		@Test
		public void testGetCategory_id5() throws Exception {
			ProductDTO dto = new ProductDTO();
			try {
			     int postalMin = Integer.parseInt("-2147483649");
			     dto.setCategory_id(postalMin);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
			}
		}


		//トッピングIDに関するテスト
		@Test
		public void testGetTopping_id1() {
			ProductDTO dto = new ProductDTO();
			int expected = 0;

			dto.setTopping_id(expected);

			assertEquals(expected, dto.getTopping_id());

		}
		@Test
		public void testGetTopping_id2() {
			ProductDTO dto = new ProductDTO();
			int expected = 2147483647;

			dto.setTopping_id(expected);

			assertEquals(expected, dto.getTopping_id());
		}
		@Test
		public void testGetTopping_id3() {
			ProductDTO dto = new ProductDTO();
			int expected = -2147483647;

			dto.setTopping_id(expected);

			assertEquals(expected, dto.getTopping_id());
		}
		@Test
		public void testGetTopping_id4() throws Exception {
			ProductDTO dto = new ProductDTO();
		    try{
		    	int postalMax = Integer.parseInt("2147483648");
		    	dto.setTopping_id(postalMax);

		    } catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		    }
		}
		@Test
		public void testGetTopping_id5() throws Exception {
			ProductDTO dto = new ProductDTO();
			try {
			     int postalMin = Integer.parseInt("-2147483649");
			     dto.setTopping_id(postalMin);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
			}
		}


		//Mサイズ価格に関するテスト
		@Test
		public void testGetMsize_price1() {
			ProductDTO dto = new ProductDTO();
			int expected = 0;

			dto.setMsize_price(expected);

			assertEquals(expected, dto.getMsize_price());

		}
		@Test
		public void testGetMsize_price2() {
			ProductDTO dto = new ProductDTO();
			int expected = 2147483647;

			dto.setMsize_price(expected);

			assertEquals(expected, dto.getMsize_price());
		}
		@Test
		public void testGetMsize_price3() {
			ProductDTO dto = new ProductDTO();
			int expected = -2147483647;

			dto.setMsize_price(expected);

			assertEquals(expected, dto.getMsize_price());
		}
		@Test
		public void testGetMsize_price4() throws Exception {
			ProductDTO dto = new ProductDTO();
		    try{
		    	int postalMax = Integer.parseInt("2147483648");
		    	dto.setMsize_price(postalMax);

		    } catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		    }
		}
		@Test
		public void testGetMsize_priced5() throws Exception {
			ProductDTO dto = new ProductDTO();
			try {
			     int postalMin = Integer.parseInt("-2147483649");
			     dto.setMsize_price(postalMin);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
			}
		}


//Lサイズ価格に関するテスト
	@Test
	public void testGetLsize_price1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setLsize_price(expected);

		assertEquals(expected, dto.getLsize_price());

	}
	@Test
	public void testGetLsize_price2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setLsize_price(expected);

		assertEquals(expected, dto.getLsize_price());
	}
	@Test
	public void testGetLsize_price3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setLsize_price(expected);

		assertEquals(expected, dto.getLsize_price());
	}
	@Test
	public void testGetLsize_price4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setLsize_price(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetLsize_price5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setLsize_price(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}


	//サイド、ドリンク価格に関するテスト
	@Test
	public void testGetPrice1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		ProductDTO dto = new ProductDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		ProductDTO dto = new ProductDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}



	//商品在庫
	@Test
	public void testGetStock1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}

	@Test
	public void testGetStock2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}
	@Test
	public void testGetStock3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setStock(expected);

		assertEquals(expected, dto.getStock());
	}
	@Test
	public void testGetStock4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMax = 10000000;
		     dto.setStock(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetStock5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setStock(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}



	//ステータス
	@Test
	public void testGetStatus1() {
		ProductDTO dto = new ProductDTO();
		int expected = 0;

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());

	}
	@Test
	public void testGetStatus2() {
		ProductDTO dto = new ProductDTO();
		int expected = 2147483647;

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());
	}
	@Test
	public void testGetStatus3() {
		ProductDTO dto = new ProductDTO();
		int expected = -2147483647;

		dto.setStatus(expected);

		assertEquals(expected, dto.getStatus());
	}
	@Test
	public void testGetStatus4() throws Exception {
		ProductDTO dto = new ProductDTO();
	    try{
	    	int postalMax = 21474836;
	    	dto.setStatus(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input int: \"21474836\"");
	    }
	}
	@Test
	public void testGetStatus5() throws Exception {
		ProductDTO dto = new ProductDTO();
		try {
		     int postalMin = -21474836;
		     dto.setStatus(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input int: \"-21474836\"");
		}
	}



	//商品名に関するテスト
	@Test
	public void testGetProduct_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_name(expected);
		String actual=dto.getProduct_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_name(expected);
		String actual= dto.getProduct_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_name(expected);
    	String actual=dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_name(expected);
    	String actual= dto.getProduct_name();

    	assertEquals(expected, actual);
    }




	//商品名（かな）に関するテスト
	@Test
	public void testGetProduct_name_kana1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_name_kana(expected);
		String actual=dto.getProduct_name_kana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_name_kana2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_name_kana(expected);
		String actual= dto.getProduct_name_kana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_name_kana3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_name_kana(expected);
    	String actual=dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_name_kana8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_name_kana(expected);
    	String actual= dto.getProduct_name_kana();

    	assertEquals(expected, actual);
    }




	//商品詳細に関するテスト
	@Test
	public void testGetProduct_description1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setProduct_description(expected);
		String actual=dto.getProduct_description();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProduct_description2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setProduct_description(expected);
		String actual= dto.getProduct_description();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProduct_description3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setProduct_description(expected);
    	String actual=dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProduct_description8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProduct_description(expected);
    	String actual= dto.getProduct_description();

    	assertEquals(expected, actual);
    }


	//画像ファイルパスに関するテスト
	@Test
	public void testGetImage_file_path1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setImage_file_path(expected);
		String actual=dto.getImage_file_path();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetImage_file_path2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setImage_file_path(expected);
		String actual= dto.getImage_file_path();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetImage_file_path3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setImage_file_path(expected);
    	String actual=dto.getImage_file_path();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_path4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setImage_file_path(expected);
    	String actual= dto.getImage_file_path();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_path5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setImage_file_path(expected);
    	String actual= dto.getImage_file_path();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_path6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setImage_file_path(expected);
    	String actual= dto.getImage_file_path();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_path7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setImage_file_path(expected);
    	String actual= dto.getImage_file_path();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_path8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setImage_file_path(expected);
    	String actual= dto.getImage_file_path();

    	assertEquals(expected, actual);
    }



	//画像ファイル名に関するテスト
	@Test
	public void testGetImage_file_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setImage_file_name(expected);
		String actual=dto.getImage_file_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetImage_file_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setImage_file_name(expected);
		String actual= dto.getImage_file_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetImage_file_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setImage_file_name(expected);
    	String actual=dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImage_file_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setImage_file_name(expected);
    	String actual= dto.getImage_file_name();

    	assertEquals(expected, actual);
    }




	//発売日（!=登録日）
	@Test
	public void testGetRelease_date1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setRelease_date(expected);
		String actual=dto.getRelease_date();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRelease_date2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setRelease_date(expected);
		String actual= dto.getRelease_date();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRelease_date3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setRelease_date(expected);
    	String actual=dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_date8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRelease_date(expected);
    	String actual= dto.getRelease_date();

    	assertEquals(expected, actual);
    }




	//発売会社
	@Test
	public void testGetRelease_company1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setRelease_company(expected);
		String actual=dto.getRelease_company();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetRelease_company2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setRelease_company(expected);
		String actual= dto.getRelease_company();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetRelease_company3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setRelease_company(expected);
    	String actual=dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetRelease_company8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setRelease_company(expected);
    	String actual= dto.getRelease_company();

    	assertEquals(expected, actual);
    }


	//カテゴリー名に関するテスト
	@Test
	public void testGetCategory_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setCategory_name(expected);
		String actual=dto.getCategory_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetCategory_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setCategory_name(expected);
		String actual= dto.getCategory_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetCategory_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setCategory_name(expected);
    	String actual=dto.getCategory_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetCategory_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setCategory_name(expected);
    	String actual= dto.getCategory_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetCategory_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setCategory_name(expected);
    	String actual= dto.getCategory_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetCategory_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setCategory_name(expected);
    	String actual= dto.getCategory_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetCategory_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setCategory_name(expected);
    	String actual= dto.getCategory_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetCategory_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setCategory_name(expected);
    	String actual= dto.getCategory_name();

    	assertEquals(expected, actual);
    }

	//トッピング名に関するテスト
	@Test
	public void testGetTopping_name1() {
		ProductDTO dto = new ProductDTO();
		String expected=null;

		dto.setTopping_name(expected);
		String actual=dto.getTopping_name();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetTopping_name2() {
		ProductDTO dto = new ProductDTO();
		String expected="";

		dto.setTopping_name(expected);
		String actual= dto.getTopping_name();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetTopping_name3() {
		ProductDTO dto = new ProductDTO();
    	String expected=" ";

    	dto.setTopping_name(expected);
    	String actual=dto.getTopping_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetTopping_name4() {
		ProductDTO dto = new ProductDTO();
    	String expected ="　";

    	dto.setTopping_name(expected);
    	String actual= dto.getTopping_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetTopping_name5() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123";

    	dto.setTopping_name(expected);
    	String actual= dto.getTopping_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetTopping_name6() {
		ProductDTO dto = new ProductDTO();
    	String expected ="あいう１２３";

    	dto.setTopping_name(expected);
    	String actual= dto.getTopping_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetTopping_name7() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３";

    	dto.setTopping_name(expected);
    	String actual= dto.getTopping_name();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetTopping_name8() {
		ProductDTO dto = new ProductDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setTopping_name(expected);
    	String actual= dto.getTopping_name();

    	assertEquals(expected, actual);
    }

	//登録日（!=発売日）
	@Test
	public void testGetRegist_date1() {
		ProductDTO dto = new ProductDTO();
		Date expected=null;

		dto.setRegist_date(expected);
		Date actual=dto.getRegist_date();

		assertEquals(expected,actual);
	}



	//更新日（!=発売日）
	@Test
	public void testGetUpdate_date1() {
		ProductDTO dto = new ProductDTO();
		Date expected=null;

		dto.setUpdate_date(expected);
		Date actual=dto.getUpdate_date();

		assertEquals(expected,actual);
	}

	//更新日（!=発売日）
	@Test
	public void testGetInsert_date1() {
		ProductDTO dto = new ProductDTO();
		Date expected=null;

		dto.setUpdate_date(expected);
		Date actual=dto.getInsert_date();

		assertEquals(expected,actual);
	}

	 //下記管理者ページで使用

	//商品名に関するテスト
		@Test
		public void testGetItemName1() {
			ProductDTO dto = new ProductDTO();
			String expected=null;

			dto.setItemName(expected);
			String actual=dto.getItemName();

			assertEquals(expected,actual);
		}
		@Test
		public void testGetItemName2() {
			ProductDTO dto = new ProductDTO();
			String expected="";

			dto.setItemName(expected);
			String actual= dto.getItemName();

			assertEquals(expected, actual);
		}
		@Test
	    public void testGetItemName3() {
			ProductDTO dto = new ProductDTO();
	    	String expected=" ";

	    	dto.setItemName(expected);
	    	String actual=dto.getItemName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemName4() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="　";

	    	dto.setItemName(expected);
	    	String actual= dto.getItemName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemName5() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123";

	    	dto.setItemName(expected);
	    	String actual= dto.getItemName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemName6() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="あいう１２３";

	    	dto.setItemName(expected);
	    	String actual= dto.getItemName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemName7() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123あいう１２３";

	    	dto.setItemName(expected);
	    	String actual= dto.getItemName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemName8() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123あいう１２３漢字";

	    	dto.setItemName(expected);
	    	String actual= dto.getItemName();

	    	assertEquals(expected, actual);
	    }




		//商品名（かな）に関するテスト
		@Test
		public void testGetItemKanaName1() {
			ProductDTO dto = new ProductDTO();
			String expected=null;

			dto.setItemKanaName(expected);
			String actual=dto.getItemKanaName();

			assertEquals(expected,actual);
		}
		@Test
		public void testGetItemKanaName2() {
			ProductDTO dto = new ProductDTO();
			String expected="";

			dto.setItemKanaName(expected);
			String actual= dto.getItemKanaName();

			assertEquals(expected, actual);
		}
		@Test
	    public void testGetItemKanaName3() {
			ProductDTO dto = new ProductDTO();
	    	String expected=" ";

	    	dto.setItemKanaName(expected);
	    	String actual=dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemKanaName4() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="　";

	    	dto.setItemKanaName(expected);
	    	String actual= dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemKanaName5() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123";

	    	dto.setItemKanaName(expected);
	    	String actual= dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemKanaName6() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="あいう１２３";

	    	dto.setItemKanaName(expected);
	    	String actual= dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemKanaName7() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123あいう１２３";

	    	dto.setItemKanaName(expected);
	    	String actual= dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetItemKanaName8() {
			ProductDTO dto = new ProductDTO();
	    	String expected ="abc123あいう１２３漢字";

	    	dto.setItemKanaName(expected);
	    	String actual= dto.getItemKanaName();

	    	assertEquals(expected, actual);
	    }


		//商品価格に関するテスト
		@Test
		public void testGetItemPrice1() {
			ProductDTO dto = new ProductDTO();
			String expected = "0";

			dto.setItemPrice(expected);

			assertEquals(expected, dto.getItemPrice());
		}

		@Test
		public void testGetItemPrice2() {
			ProductDTO dto = new ProductDTO();
			String expected = "9999999";

			dto.setItemPrice(expected);

			assertEquals(expected, dto.getItemPrice());
		}
		@Test
		public void testGetItemPrice3() {
			ProductDTO dto = new ProductDTO();
			String expected = "-9999999";

			dto.setItemPrice(expected);

			assertEquals(expected, dto.getItemPrice());
		}
		@Test
		public void testGetItemPrice4() throws Exception {
			ProductDTO dto = new ProductDTO();
			try {
			     String postalMax = "10000000";
			     dto.setItemPrice(postalMax);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
			}
		}
		@Test
		public void testGetItemPrice5() throws Exception {
			ProductDTO dto = new ProductDTO();
		    try{
		    	String postalMin = "-10000000";
		    	dto.setItemPrice(postalMin);

		    }catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		    }
		}



		//商品在庫
		@Test
		public void testGetItemStock1() {
			ProductDTO dto = new ProductDTO();
			String expected = "0";

			dto.setItemStock(expected);

			assertEquals(expected, dto.getItemStock());
		}

		@Test
		public void testGetItemStock2() {
			ProductDTO dto = new ProductDTO();
			String expected = "9999999";

			dto.setItemStock(expected);

			assertEquals(expected, dto.getItemStock());
		}
		@Test
		public void testGetItemStock3() {
			ProductDTO dto = new ProductDTO();
			String expected = "-9999999";

			dto.setItemStock(expected);

			assertEquals(expected, dto.getItemStock());
		}
		@Test
		public void testGetItemStock4() throws Exception {
			ProductDTO dto = new ProductDTO();
			try {
			     String postalMax = "10000000";
			     dto.setItemStock(postalMax);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
			}
		}
		@Test
		public void testGetItemStock5() throws Exception {
			ProductDTO dto = new ProductDTO();
		    try{
		    	String postalMin = "-10000000";
		    	dto.setItemStock(postalMin);

		    }catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		    }
		}



}