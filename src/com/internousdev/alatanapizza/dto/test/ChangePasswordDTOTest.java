package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.ChangePasswordDTO;


public class ChangePasswordDTOTest {

	@Test
	public void testGetUserid1(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "0";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid2(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "aaa";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid3(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "AAA";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid4(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "あああ";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid5(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid6(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = " ";

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}
	@Test
	public void testGetUserid7(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = null;

		dto.setUserid(expected);

		assertEquals(expected, dto.getUserid());
	}

	@Test
	public void testGetPassword1(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "0";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword2(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "aaa";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword3(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "AAA";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword4(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "あああ";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword5(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword6(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = " ";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword7(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = null;

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}

	@Test
	public void testGetAnswer1(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "0";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer2(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "aaa";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer3(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "AAA";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer4(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "あああ";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer5(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = "";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer6(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = " ";

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}
	@Test
	public void testGetAnswer7(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		String expected = null;

		dto.setAnswer(expected);

		assertEquals(expected, dto.getAnswer());
	}

	@Test
	public void testGetQuestion1(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		int expected = 0;

		dto.setQuestion(expected);

		assertEquals(expected, dto.getQuestion());
	}
	@Test
	public void testGetQuestion2(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		int expected = 1+1;

		dto.setQuestion(expected);

		assertEquals(expected, dto.getQuestion());
	}
	@Test
	public void testGetQuestion3(){
		ChangePasswordDTO dto = new ChangePasswordDTO();
		int expected = -22222;

		dto.setQuestion(expected);

		assertEquals(expected, dto.getQuestion());
	}
	@Test
	public void testGetQuestion4() throws Exception {
		ChangePasswordDTO  dto = new ChangePasswordDTO ();
	    try{
	    	int postalMax = Integer.parseInt("2147483648");
	    	dto.setQuestion(postalMax);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"2147483648\"");
	    }
	}
	@Test
	public void testGetQuestion5() throws Exception {
		ChangePasswordDTO  dto = new ChangePasswordDTO ();
	    try{
	    	int postalMin = Integer.parseInt("-2147483648");
	    	dto.setQuestion(postalMin);

	    } catch (RuntimeException e) {
	    	assertEquals(e.getMessage(), "For input string: \"-2147483648\"");
	    }
	}



}
