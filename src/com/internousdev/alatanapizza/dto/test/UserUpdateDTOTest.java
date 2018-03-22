package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.UserUpdateDTO;

public class UserUpdateDTOTest {


	@Test
	public void testGetUserId1() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "0";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId2() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = " ";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId3() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "aaa";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId4() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "ああああ";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId5() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "AAAA";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId6() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "";

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}
	@Test
	public void testGetUserId7() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = null;

		dto.setUser_id(expected);

		assertEquals(expected, dto.getUser_id());
	}



	@Test
	public void testGetPassword1() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "0";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword2() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "aaa";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword3() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "AAA";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword4() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "あああ";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword5() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword6() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = " ";

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}
	@Test
	public void testGetPassword7() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = null;

		dto.setPassword(expected);

		assertEquals(expected, dto.getPassword());
	}


	@Test
	public void testGetNewPassword1() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "0";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword2() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "aaa";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword3() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "AAA";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword4() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "あああ";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword5() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword6() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = " ";

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}
	@Test
	public void testGetNewPassword7() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = null;

		dto.setNewPassword(expected);

		assertEquals(expected, dto.getNewPassword());
	}

	@Test
	public void testGetConPassword1() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "0";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword2() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "aaa";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword3() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "AAA";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword4() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "あああ";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword5() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword6() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = " ";

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetConPassword7() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = null;

		dto.setConPassword(expected);

		assertEquals(expected, dto.getConPassword());
	}
	@Test
	public void testGetNewEmail1() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "0";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail2() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "aaa";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail3() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "AAA";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail4() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "あああ";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail5() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = "";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail6() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = " ";

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	@Test
	public void testGetNewEmail7() {
		UserUpdateDTO dto = new UserUpdateDTO();
		String expected = null;

		dto.setNewEmail(expected);

		assertEquals(expected, dto.getNewEmail());
	}
	}
