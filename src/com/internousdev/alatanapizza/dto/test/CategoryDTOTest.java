package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.CategoryDTO;


public class CategoryDTOTest {

	@Test
	public void testGetId1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}


	@Test
	public void testGetId2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetId3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetId4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetId5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetId6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}

	@Test
	public void testGetId7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setId(expected);

		assertEquals(expected, dto.getId());
	}



	@Test
	public void testGetCategory_id1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}
	@Test
	public void testGetCategory_id2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
		}

	@Test
	public void testGetCategory_id3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}

	@Test
	public void testGetCategory_id4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}

	@Test
	public void testGetCategory_id5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}

	@Test
	public void testGetCategory_id6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}

	@Test
	public void testGetCategory_id7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setCategory_id(expected);

		assertEquals(expected, dto.getCategory_id());
	}





	@Test
	public void testGetCategory_name1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}
	@Test
	public void testGetCategory_name2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}

	@Test
	public void testGetCategoryName3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}

	@Test
	public void testGetCategory_name4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}

	@Test
	public void testGetCategory_name5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}

	@Test
	public void testGetCategory_name6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}

	@Test
	public void testGetCategory_name7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setCategory_name(expected);

		assertEquals(expected, dto.getCategory_name());
	}




	@Test
	public void testGetCategory_description1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}
	@Test
	public void testGetCategory_description2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}

	@Test
	public void testGetCategory_description3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}

	@Test
	public void testGetCategory_description4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}

	@Test
	public void testGetCategory_description5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}

	@Test
	public void testGetCategory_description6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}

	@Test
	public void testGetCategory_description7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setCategory_description(expected);

		assertEquals(expected, dto.getCategory_description());
	}






	@Test
	public void testGetInsert_date1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}
	@Test
	public void testGetInsert_date2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}

	@Test
	public void testGetInsert_date3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}

	@Test
	public void testGetInsert_date4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}

	@Test
	public void testGetInsert_date5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}

	@Test
	public void testGetInsert_date6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}

	@Test
	public void testGetInsert_date7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setInsert_date(expected);

		assertEquals(expected, dto.getInsert_date());
	}





	@Test
	public void testGetUpdate_date1() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "0";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}
	@Test
	public void testGetUpdate_date2() {
		CategoryDTO dto = new CategoryDTO();
		String expected = null;

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

	@Test
	public void testGetUpdate_date3() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

	@Test
	public void testGetUpdate_date4() {
		CategoryDTO dto = new CategoryDTO();
		String expected = " ";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

	@Test
	public void testGetUpdate_date5() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "aaa";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

	@Test
	public void testGetUpdate_date6() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "AAA";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

	@Test
	public void testGetUpdate_date7() {
		CategoryDTO dto = new CategoryDTO();
		String expected = "あああ";

		dto.setUpdate_date(expected);

		assertEquals(expected, dto.getUpdate_date());
	}

}