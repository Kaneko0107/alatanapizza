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
		int expected = 1;

		loginDTO.setId(expected);

		assertEquals(expected, loginDTO.getId());
	}

	@Test
	public void testGetId3() {
		LoginDTO loginDTO = new LoginDTO();
		int expected = 1000;

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
		String expected = "0";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "-1242";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あｇｗぽえい";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "0134513v";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetUserId5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "３１７０５９８あｄｇ";

		loginDTO.setUserId(expected);

		assertEquals(expected, loginDTO.getUserId());
	}

	@Test
	public void testGetPassword1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setPassword(expected);
		String actual = loginDTO.getPassword();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetPassword2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "obnaaijge";

		loginDTO.setPassword(expected);
		String actual = loginDTO.getPassword();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetPassword3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "あえのぱ";

		loginDTO.setPassword(expected);
		String actual = loginDTO.getPassword();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetPassword4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "500000000000000";

		loginDTO.setPassword(expected);
		String actual = loginDTO.getPassword();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetPassword5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "んｂそあ；えｒ";

		loginDTO.setPassword(expected);
		String actual = loginDTO.getPassword();

		assertEquals(expected,actual);
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
		String actual = loginDTO.getFamilyName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyName2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "jpagie";

		loginDTO.setFamilyName(expected);
		String actual = loginDTO.getFamilyName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyName3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "亜漢字";

		loginDTO.setFamilyName(expected);
		String actual = loginDTO.getFamilyName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyName4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "けおｗ";

		loginDTO.setFamilyName(expected);
		String actual = loginDTO.getFamilyName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyName5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "5億";

		loginDTO.setFamilyName(expected);
		String actual = loginDTO.getFamilyName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstName1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFirstName(expected);
		String actual = loginDTO.getFirstName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstName2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "570123496";

		loginDTO.setFirstName(expected);
		String actual = loginDTO.getFirstName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstName3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "けおｗ";

		loginDTO.setFirstName(expected);
		String actual = loginDTO.getFirstName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstName4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "5追うg区";

		loginDTO.setFirstName(expected);
		String actual = loginDTO.getFirstName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstName5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "おいあｈげいあ";

		loginDTO.setFirstName(expected);
		String actual = loginDTO.getFirstName();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyNameKana1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFamilyNameKana(expected);
		String actual = loginDTO.getFamilyNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyNameKana2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "6089732156";

		loginDTO.setFamilyNameKana(expected);
		String actual = loginDTO.getFamilyNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyNameKana3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "5億お";

		loginDTO.setFamilyNameKana(expected);
		String actual = loginDTO.getFamilyNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyNameKana4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "けおｗo";

		loginDTO.setFamilyNameKana(expected);
		String actual = loginDTO.getFamilyNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFamilyNameKana5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ごｑん；あおｂ";

		loginDTO.setFamilyNameKana(expected);
		String actual = loginDTO.getFamilyNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstNameKana1() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = null;

		loginDTO.setFirstNameKana(expected);
		String actual = loginDTO.getFirstNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstNameKana2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "n@abwnob";

		loginDTO.setFirstNameKana(expected);
		String actual = loginDTO.getFirstNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstNameKana3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "けおｗ億";

		loginDTO.setFirstNameKana(expected);
		String actual = loginDTO.getFirstNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstNameKana4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "ーｇぱｇn;oiawg";

		loginDTO.setFirstNameKana(expected);
		String actual = loginDTO.getFirstNameKana();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetFirstNameKana5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "oagago７５０３８２１６";

		loginDTO.setFirstNameKana(expected);
		String actual = loginDTO.getFirstNameKana();

		assertEquals(expected,actual);
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
		String actual = loginDTO.getEmail();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail2() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "5億けえ";

		loginDTO.setEmail(expected);
		String actual = loginDTO.getEmail();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail3() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "0652945pu@p65023";

		loginDTO.setEmail(expected);
		String actual = loginDTO.getEmail();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail4() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "んぱげいｈな：ｐ";

		loginDTO.setEmail(expected);
		String actual = loginDTO.getEmail();

		assertEquals(expected,actual);
	}

	@Test
	public void testGetEmail5() {
		LoginDTO loginDTO = new LoginDTO();
		String expected = "352125351ｊぽいは";

		loginDTO.setEmail(expected);
		String actual = loginDTO.getEmail();

		assertEquals(expected,actual);
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
