package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.LoginDTO;

public class LoginDTOTest {

	@Test
	public void testGetId1() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = 0;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetId2() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = Integer.MAX_VALUE;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetId3() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = Integer.MIN_VALUE;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetId4() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = 500000000;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetId5() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = 570196351;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetUserId1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetPassword1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testGetPassword9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setPassword(expected);

		assertEquals(expected, loginDTO.getPassword());
	}

	@Test
	public void testIsMaster1() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = false;

		loginDTO.setMaster(expected);
		boolean actual = loginDTO.isMaster();

		assertEquals(expected,actual);
	}

	@Test
	public void testIsMaster2() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = true;

		loginDTO.setMaster(expected);
		boolean actual = loginDTO.isMaster();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyName1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFamilyName9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setFamilyName(expected);

		assertEquals(expected, loginDTO.getFamilyName());
	}

	@Test
	public void testGetFirstName1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFirstName9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setFirstName(expected);

		assertEquals(expected, loginDTO.getFirstName());
	}

	@Test
	public void testGetFamilyNameKana1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setFamilyNameKana(expected);

		assertEquals(expected, loginDTO.getFamilyNameKana());
	}


	@Test
	public void testGetFirstNameKana1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}

	@Test
	public void testGetFirstNameKana9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setFirstNameKana(expected);

		assertEquals(expected, loginDTO.getFirstNameKana());
	}


	@Test
	public void testIsSex1() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = false;

		loginDTO.setSex(expected);
		boolean actual = loginDTO.isSex();

		assertEquals(expected,actual);
	}

	@Test
	public void testIsSex2() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = true;

		loginDTO.setSex(expected);
		boolean actual = loginDTO.isSex();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = " ";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "　";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail6() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail7() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あいう１２３";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail8() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "abc123あいう１２３";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}

	@Test
	public void testGetEmail9() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ａｂｃ１２３あいう漢字";

		loginDTO.setEmail(expected);

		assertEquals(expected, loginDTO.getEmail());
	}


	@Test
	public void testIsLogined1() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = false;

		loginDTO.setLogined(expected);
		boolean actual = loginDTO.isLogined();

		assertEquals(expected,actual);
	}

	@Test
	public void testIsLogined2() {
		LoginDTO loginDTO = new LoginDTO();
		boolean expected = true;

		loginDTO.setLogined(expected);
		boolean actual = loginDTO.isLogined();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetRegister_date() {
		LoginDTO loginDTO = new LoginDTO();
		Date expected = null;

		loginDTO.setRegister_date(expected);
		Date actual = loginDTO.getRegister_date();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetUpdate_date() {
		LoginDTO loginDTO = new LoginDTO();
		Date expected = null;

		loginDTO.setUpdate_date(expected);
		Date actual = loginDTO.getUpdate_date();

		assertEquals(expected,actual);
	}

}
