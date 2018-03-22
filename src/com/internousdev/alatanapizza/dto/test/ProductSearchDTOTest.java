package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.ProductSearchDTO;

public class ProductSearchDTOTest {


	//自動生成IDに関するテスト
	@Test
	public void testGetId1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 0;

		dto.setId(expected);

		assertEquals(expected, dto.getId());

	}
	@Test
	public void testGetId2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId3() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = -2147483647;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}
	@Test
	public void testGetId4() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetId5() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}




	//商品IDに関するテスト
	@Test
	public void testGetProductId1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 0;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());

	}
	@Test
	public void testGetProductId2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId3() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = -2147483647;

		dto.setProductId(expected);

		assertEquals(expected, dto.getProductId());
	}
	@Test
	public void testGetProductId4() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setProductId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetProductId5() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setProductId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}



	//商品名に関するテスト
	@Test
	public void testGetProductName1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected=null;

		dto.setProductName(expected);
		String actual=dto.getProductName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductName2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected="";

		dto.setProductName(expected);
		String actual= dto.getProductName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductName3() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected=" ";

    	dto.setProductName(expected);
    	String actual=dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName4() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="　";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName5() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName6() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName7() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductName8() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductName(expected);
    	String actual= dto.getProductName();

    	assertEquals(expected, actual);
    }




	//商品名に関するテスト
	@Test
	public void testGetProductNameKana1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected=null;

		dto.setProductNameKana(expected);
		String actual=dto.getProductNameKana();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductNameKana2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected="";

		dto.setProductNameKana(expected);
		String actual= dto.getProductNameKana();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductNameKana3() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected=" ";

    	dto.setProductNameKana(expected);
    	String actual=dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana4() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="　";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana5() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana6() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana7() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductNameKana8() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductNameKana(expected);
    	String actual= dto.getProductNameKana();

    	assertEquals(expected, actual);
    }



	//商品名に関するテスト
	@Test
	public void testGetProductDescription1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected=null;

		dto.setProductDescription(expected);
		String actual=dto.getProductDescription();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetProductDescription2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected="";

		dto.setProductDescription(expected);
		String actual= dto.getProductDescription();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetProductDescription3() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected=" ";

    	dto.setProductDescription(expected);
    	String actual=dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription4() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="　";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription5() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription6() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="あいう１２３";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription7() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetProductDescription8() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setProductDescription(expected);
    	String actual= dto.getProductDescription();

    	assertEquals(expected, actual);
    }

	//カテゴリーIDに関するテスト
	@Test
	public void testGetCategoryId1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 0;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());

	}
	@Test
	public void testGetCategoryId2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = 2147483647;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());
	}
	@Test
	public void testGetCategoryId3() {
		ProductSearchDTO dto = new ProductSearchDTO();
		int expected = -2147483647;

		dto.setCategoryId(expected);

		assertEquals(expected, dto.getCategoryId());
	}
	@Test
	public void testGetCategoryId4() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setCategoryId(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetCategoryId5() throws Exception {
		ProductSearchDTO dto = new ProductSearchDTO();
		try {
		     int postalMin = Integer.parseInt("-2147483649");
		     dto.setCategoryId(postalMin);

		} catch (RuntimeException e) {
			assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
		}
	}

	//Mサイズ価格(mSizePrice）に関するテスト
		@Test
		public void testGetMSizePrice1() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 0;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());

		}
		@Test
		public void testGetMSizePrice2() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 2147483647;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());
		}
		@Test
		public void testGetMSizePrice3() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = -2147483647;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());
		}
		@Test
		public void testGetMSizePrice4() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
		    try{
		    	int postalMax = Integer.parseInt("2147483648");
		    	dto.setCategoryId(postalMax);

		    } catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		    }
		}
		@Test
		public void testGetMSizePrice5() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
			try {
			     int postalMin = Integer.parseInt("-2147483649");
			     dto.setCategoryId(postalMin);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
			}
		}

	//Lサイズ価格(lSizePrice）に関するテスト
		@Test
		public void testGetLSizePrice1() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 0;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());

		}
		@Test
		public void testGetLSizePrice2() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 2147483647;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());
		}
		@Test
		public void testGetLSizePrice3() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = -2147483647;

			dto.setCategoryId(expected);

			assertEquals(expected, dto.getCategoryId());
		}
		@Test
		public void testGetLSizePrice4() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
		    try{
		    	int postalMax = Integer.parseInt("2147483648");
		    	dto.setCategoryId(postalMax);

		    } catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
		    }
		}
		@Test
		public void testGetLSizePrice5() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
			try {
			     int postalMin = Integer.parseInt("-2147483649");
			     dto.setCategoryId(postalMin);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"-2147483649\"");
			}
		}
	//商品在庫に関するテスト
		@Test
		public void testGetStock1() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 0;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}

		@Test
		public void testGetStock2() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 9999999;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}
		@Test
		public void testGetStock3() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = -9999999;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}
		@Test
		public void testGeStock4() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
			try {
			     int postalMax = 10000000;
			     dto.setPrice(postalMax);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
			}
		}
		@Test
		public void testGetStock5() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
		    try{
		    	int postalMin = -10000000;
		    	dto.setPrice(postalMin);

		    }catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		    }
		}

	//商品価格に関するテスト
		@Test
		public void testGetPrice1() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 0;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}

		@Test
		public void testGetPrice2() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = 9999999;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}
		@Test
		public void testGetPrice3() {
			ProductSearchDTO dto = new ProductSearchDTO();
			int expected = -9999999;

			dto.setPrice(expected);

			assertEquals(expected, dto.getPrice());
		}
		@Test
		public void testGetPrice4() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
			try {
			     int postalMax = 10000000;
			     dto.setPrice(postalMax);

			} catch (RuntimeException e) {
				assertEquals(e.getMessage(), "For input string: \"10000000.00\"");
			}
		}
		@Test
		public void testGetPrice5() throws Exception {
			ProductSearchDTO dto = new ProductSearchDTO();
		    try{
		    	int postalMin = -10000000;
		    	dto.setPrice(postalMin);

		    }catch (RuntimeException e) {
		    	assertEquals(e.getMessage(), "For input string: \"-10000000.00\"");
		    }
		}

	//画像ファイルパスに関するテスト
		@Test
		public void testGetImageFilePath1() {
			ProductSearchDTO dto = new ProductSearchDTO();
			String expected=null;

			dto.setProductDescription(expected);
			String actual=dto.getProductDescription();

			assertEquals(expected,actual);
		}
		@Test
		public void testGetImageFilePath2() {
			ProductSearchDTO dto = new ProductSearchDTO();
			String expected="";

			dto.setProductDescription(expected);
			String actual= dto.getProductDescription();

			assertEquals(expected, actual);
		}
		@Test
	    public void testGetImageFilePath3() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected=" ";

	    	dto.setProductDescription(expected);
	    	String actual=dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetImageFilePath4() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected ="　";

	    	dto.setProductDescription(expected);
	    	String actual= dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetImageFilePath5() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected ="abc123";

	    	dto.setProductDescription(expected);
	    	String actual= dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetImageFilePath6() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected ="あいう１２３";

	    	dto.setProductDescription(expected);
	    	String actual= dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGeImageFilePath7() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected ="abc123あいう１２３";

	    	dto.setProductDescription(expected);
	    	String actual= dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }
		@Test
	    public void testGetImageFilePath8() {
			ProductSearchDTO dto = new ProductSearchDTO();
	    	String expected ="abc123あいう１２３漢字";

	    	dto.setProductDescription(expected);
	    	String actual= dto.getProductDescription();

	    	assertEquals(expected, actual);
	    }

	//商品画像パスに関するテスト
	@Test
	public void testGetImageFileName1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected=null;

		dto.setImageFileName(expected);
		String actual=dto.getImageFileName();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetImageFileName2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected="";

		dto.setImageFileName(expected);
		String actual= dto.getImageFileName();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetImageFileName3() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected=" ";

    	dto.setImageFileName(expected);
    	String actual=dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName4() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="　";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName5() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName6() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="あいう１２３";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName7() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetImageFileName8() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setImageFileName(expected);
    	String actual= dto.getImageFileName();

    	assertEquals(expected, actual);
    }




	//発売日
	@Test
	public void testGetReleaseDate1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		Date expected = null;

		dto.setReleaseDate(expected);
		Date actual=dto.getReleaseDate();

		assertEquals(expected,actual);
	}



	//商品画像パスに関するテスト
	@Test
	public void testGetReleaseCompany1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected=null;

		dto.setReleaseCompany(expected);
		String actual=dto.getReleaseCompany();

		assertEquals(expected,actual);
	}
	@Test
	public void testGetReleaseCompany2() {
		ProductSearchDTO dto = new ProductSearchDTO();
		String expected="";

		dto.setReleaseCompany(expected);
		String actual= dto.getReleaseCompany();

		assertEquals(expected, actual);
	}
	@Test
    public void testGetReleaseCompany3() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected=" ";

    	dto.setReleaseCompany(expected);
    	String actual=dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany4() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="　";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany5() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany6() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany7() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }
	@Test
    public void testGetReleaseCompany8() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	String expected ="abc123あいう１２３漢字";

    	dto.setReleaseCompany(expected);
    	String actual= dto.getReleaseCompany();

    	assertEquals(expected, actual);
    }

	//ステータス
	@Test
    public void testGetStatus1() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	short expected =1;

    	dto.setStatus(expected);
    	short actual = dto.getStatus();
    	assertEquals(expected, actual);
    }
	@Test
    public void testGetStatus2() {
		ProductSearchDTO dto = new ProductSearchDTO();
    	short expected =0;

    	dto.setStatus(expected);
    	short actual= dto.getStatus();

    	assertEquals(expected, actual);
    }

	//登録日
	@Test
	public void testGetRegistDate1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		Date expected = null;

		dto.setRegistDate(expected);
		Date actual=dto.getRegistDate();

		assertEquals(expected,actual);
	}

	//更新日
	@Test
	public void testGetUpdateDate1() {
		ProductSearchDTO dto = new ProductSearchDTO();
		Date expected = null;

		dto.setUpdateDate(expected);
		Date actual=dto.getUpdateDate();

		assertEquals(expected,actual);
	}


}