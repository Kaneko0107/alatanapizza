package com.internousdev.alatanapizza.dto.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.internousdev.alatanapizza.dto.DestinationDTO;

public class DestinationDTOTest {

	//----------------------------------------------
	@Test
	public void testGetId() {
		DestinationDTO dto=new DestinationDTO();
		int expected=0;
		dto.setId(expected);

		assertEquals(expected,dto.getId());
	}

	@Test
	public void testGetId2() {
		DestinationDTO dto=new DestinationDTO();
		int expected=-2147483647;
		dto.setId(expected);

		assertEquals(expected,dto.getId());
	}

	@Test
	public void testGetId3() {
		DestinationDTO dto=new DestinationDTO();
		int expected=61839402;
		dto.setId(expected);

		assertEquals(expected,dto.getId());
	}

	@Test
	public void testGetId4() {
		DestinationDTO dto=new DestinationDTO();
		int expected=1000000000;
		dto.setId(expected);

		assertEquals(expected,dto.getId());
	}
	//----------------------------------------------

	@Test
	public void testGetUserId() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setUserId(expected);

		assertEquals(expected,dto.getUserId());
	}

	@Test
	public void testGetUserId2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setUserId(expected);

		assertEquals(expected,dto.getUserId());
	}

	@Test
	public void testGetUserId3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="737389292";
		dto.setUserId(expected);

		assertEquals(expected,dto.getUserId());
	}

	@Test
	public void testGetUserId4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-737389292";
		dto.setUserId(expected);

		assertEquals(expected,dto.getUserId());
	}
	//----------------------------------------------

	@Test
	public void testGetFamilyName() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setFamilyName(expected);

		assertEquals(expected,dto.getFamilyName());
	}


	@Test
	public void testGetFamilyName2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setFamilyName(expected);

		assertEquals(expected,dto.getFamilyName());
	}

	@Test
	public void testGetFamilyName3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="737389292";
		dto.setFamilyName(expected);

		assertEquals(expected,dto.getFamilyName());
	}

	@Test
	public void testGetFamilyName4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-737389292";
		dto.setFamilyName(expected);

		assertEquals(expected,dto.getFamilyName());
	}
	//----------------------------------------------

	@Test
	public void testGetFirstName() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setUserId(expected);

		assertEquals(expected,dto.getFirstName());
	}


	@Test
	public void testGetFirstName2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setFirstName(expected);

		assertEquals(expected,dto.getFirstName());
	}

	@Test
	public void testGetFirstName3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="737389292";
		dto.setFirstName(expected);

		assertEquals(expected,dto.getFirstName());
	}

	@Test
	public void testGetFirstName4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-737389292";
		dto.setFirstName(expected);

		assertEquals(expected,dto.getFirstName());
	}
	//----------------------------------------------

	@Test
	public void testGetFamilyNameKana() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setFamilyNameKana(expected);

		assertEquals(expected,dto.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setFamilyNameKana(expected);

		assertEquals(expected,dto.getFamilyNameKana());
	}

	@Test
	public void testGetFamilyNameKana3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="4567890";
		dto.setFamilyNameKana(expected);

		assertEquals(expected,dto.getFamilyNameKana());
	}


	@Test
	public void testGetFamilyNameKana4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-4567890";
		dto.setFamilyNameKana(expected);

		assertEquals(expected,dto.getFamilyNameKana());
	}
	//----------------------------------------------

	@Test
	public void testGetFirstNameKana() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setFirstNameKana(expected);

		assertEquals(expected,dto.getFirstNameKana());
	}


	@Test
	public void testGetFirstNameKana2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setFirstNameKana(expected);

		assertEquals(expected,dto.getFirstNameKana());
	}


	@Test
	public void testGetFirstNameKana3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="34567890";
		dto.setFirstNameKana(expected);

		assertEquals(expected,dto.getFirstNameKana());
	}


	@Test
	public void testGetFirstNameKana4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-34567890";
		dto.setFirstNameKana(expected);

		assertEquals(expected,dto.getFirstNameKana());
	}
	//----------------------------------------------

	@Test
	public void testGetAddr111() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setAddr11(expected);

		assertEquals(expected,dto.getAddr11());
	}

	@Test
	public void testGetAddr112() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setAddr11(expected);

		assertEquals(expected,dto.getAddr11());
	}


	@Test
	public void testGetAddr113() {
		DestinationDTO dto=new DestinationDTO();
		String expected="5609876";
		dto.setAddr11(expected);

		assertEquals(expected,dto.getAddr11());
	}

	@Test
	public void testGetAddr114() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-5609876";
		dto.setAddr11(expected);

		assertEquals(expected,dto.getAddr11());
	}
	//----------------------------------------------

	@Test
	public void testGetZip111() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setZip11(expected);

		assertEquals(expected,dto.getZip11());
	}

	@Test
	public void testGetZip112() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setZip11(expected);

		assertEquals(expected,dto.getZip11());
	}


	@Test
	public void testGetZip113() {
		DestinationDTO dto=new DestinationDTO();
		String expected="5609876";
		dto.setZip11(expected);

		assertEquals(expected,dto.getZip11());
	}

	@Test
	public void testGetZip114() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-5609876";
		dto.setZip11(expected);

		assertEquals(expected,dto.getZip11());
	}
	//----------------------------------------------

	@Test
	public void testGeTellNumber() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setTelNumber(expected);

		assertEquals(expected,dto.getTelNumber());
	}


	@Test
	public void testGeTellNumber2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setTelNumber(expected);

		assertEquals(expected,dto.getTelNumber());
	}


	@Test
	public void testGeTellNumber3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="2345674";
		dto.setTelNumber(expected);

		assertEquals(expected,dto.getTelNumber());
	}


	@Test
	public void testGeTellNumber4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-2345674";
		dto.setTelNumber(expected);

		assertEquals(expected,dto.getTelNumber());
	}
	//----------------------------------------------

	@Test
	public void testEmail() {
		DestinationDTO dto=new DestinationDTO();
		String expected=null;
		dto.setEmail(expected);

		assertEquals(expected,dto.getEmail());
	}

	@Test
	public void testEmail2() {
		DestinationDTO dto=new DestinationDTO();
		String expected="0";
		dto.setEmail(expected);

		assertEquals(expected,dto.getEmail());
	}


	@Test
	public void testEmail3() {
		DestinationDTO dto=new DestinationDTO();
		String expected="986589";
		dto.setEmail(expected);

		assertEquals(expected,dto.getEmail());
	}

	@Test
	public void testEmail4() {
		DestinationDTO dto=new DestinationDTO();
		String expected="-986589";
		dto.setEmail(expected);

		assertEquals(expected,dto.getEmail());
	}
	//----------------------------------------------

	@Test
	public void testRegistDate() {
		DestinationDTO dto=new DestinationDTO();
		Date expected=null;
		dto.setRegistDate(expected);

		assertEquals(expected,dto.getRegistDate());
	}

	//----------------------------------------------

	@Test
	public void testUpdateDate() {
		DestinationDTO dto=new DestinationDTO();
		Date expected=null;
		dto.setUpdateDate(expected);

		assertEquals(expected,dto.getUpdateDate());
	}
	//----------------------------------------------

}
