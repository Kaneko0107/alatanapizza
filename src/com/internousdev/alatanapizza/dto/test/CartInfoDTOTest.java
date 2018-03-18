package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.CartInfoDTO;

public class CartInfoDTOTest {
	//商品価格に関するテスト
	@Test
	public void testGetPrice1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}

	@Test
	public void testGetPrice2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -9999999;

		dto.setPrice(expected);

		assertEquals(expected, dto.getPrice());
	}
	@Test
	public void testGetPrice4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMax = 10000000;
		     dto.setPrice(postalMax);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
		}
	}
	@Test
	public void testGetPrice5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMin = -10000000;
	    	dto.setPrice(postalMin);

	    }catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
	    }
	}


	//カートIDに関するテスト
	@Test
	public void testGetCart_id1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetCart_id2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetCart_id3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetCart_id4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetCart_id5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//ユーザーIDに関するテスト
	@Test
	public void testGetUser_id1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setUserId(expected);

		assertEquals(expected, dto.getUserId());
	}
	@Test
	public void testGetUser_id4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetUser_id5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//一時ユーザーIDに関するテスト
	@Test
	public void testGetTempUserId1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "2147483647";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "-2147483647";

		dto.setTempUserId(expected);

		assertEquals(expected, dto.getTempUserId());
	}
	@Test
	public void testGetTempUserId4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setTempUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetTempUserId5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setTempUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品IDに関するテスト
	@Test
	public void testGetProductId1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try {
	    	String postalMax = "2147483648";
	    	dto.setTempUserId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductId5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     String postalMin = "-2147483649";
		     dto.setTempUserId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	@Test
	public void testGetProductName1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}

	@Test
	public void testGetProductName2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}

	@Test
	public void testGetProductName3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}

	@Test
	public void testGetProductName4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());

	}

	@Test
	public void testGetProductName5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}

	@Test
	public void testGetProductName6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}

	@Test
	public void testGetProductName7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setProductName(expected);

		assertEquals(expected, dto.getProductName());
	}


	@Test
	public void testGetProductNameKana1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductNameKana2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductNameKana3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductNameKana4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());

	}

	@Test
	public void testGetProductNameKana5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductNameKana6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductNameKana7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setProductNameKana(expected);

		assertEquals(expected, dto.getProductNameKana());
	}

	@Test
	public void testGetProductDescription1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetProductDescription2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetProductDescription3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetProductDescription4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());

	}

	@Test
	public void testGetProductDescription5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetProductDescription6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetProductDescription7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setProductDescription(expected);

		assertEquals(expected, dto.getProductDescription());
	}

	@Test
	public void testGetImageFilePath1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetImageFilePath2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetImageFilePath3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetImageFilePath4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());

	}

	@Test
	public void testGetImageFilePath5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetImageFilePath6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetImageFilePath7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setImageFilePath(expected);

		assertEquals(expected, dto.getImageFilePath());
	}

	@Test
	public void testGetReleaseCompany1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseCompany7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setReleaseCompany(expected);

		assertEquals(expected, dto.getReleaseCompany());
	}

	@Test
	public void testGetReleaseDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "0";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseDate2() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = null;

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseDate3() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseDate4() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = " 　";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());

	}

	@Test
	public void testGetReleaseDate5() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "aaaa";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseDate6() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "AAAA";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}

	@Test
	public void testGetReleaseDate7() {
		CartInfoDTO dto = new CartInfoDTO();
		String expected = "ああああ";

		dto.setReleaseDate(expected);

		assertEquals(expected, dto.getReleaseDate());
	}


	//商品在庫に関するテスト
	@Test
	public void testGetProductCount1() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 0;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount2() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = 2147483647;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount3() {
		CartInfoDTO dto = new CartInfoDTO();
		int expected = -2147483647;

		dto.setProductCount(expected);

		assertEquals(expected, dto.getProductCount());
	}
	@Test
	public void testGetProductCount4() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProductCount(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductCount5() throws Exception {
		CartInfoDTO dto = new CartInfoDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProductCount(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//カートINSERT日
	@Test
	public void testGetRegistDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual = dto.getRegistDate();

		assertEquals(expected,actual);
	}




	//カートUPDATE日
	@Test
	public void testGetUpdateDate1() {
		CartInfoDTO dto = new CartInfoDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual = dto.getUpdateDate();

		assertEquals(expected,actual);
	}

	// トッピング
	@Test
	public void testGetToppings() {
		CartInfoDTO dto = new CartInfoDTO();
		ArrayList<String> expected = new ArrayList<String>();

		dto.setToppings(expected);
		ArrayList<String> actual = dto.getToppings();

		assertEquals(expected,actual);
	}
}
