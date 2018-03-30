package com.internousdev.alatanapizza.action;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DestCompleteAction extends ActionSupport implements SessionAware {
	/**
	 * 値
	 */
	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String zip11;
	private String addr11;
	private String telNumber;
	private String email;

	public Map<String,Object> session;

	public String execute() throws SQLException{

		String result =ERROR;


		DestinationDTO destinationDTO=new DestinationDTO();
		destinationDTO.setUserId(session.get("userId").toString());
		destinationDTO.setFamilyName(familyName);
		destinationDTO.setFirstName(firstName);
		destinationDTO.setFamilyNameKana(familyNameKana);
		destinationDTO.setFirstNameKana(firstNameKana);
		destinationDTO.setZip11(zip11);
		destinationDTO.setAddr11(addr11);
		destinationDTO.setTelNumber(telNumber);
		destinationDTO.setEmail(email);

		DestinationDAO destinationDAO=new DestinationDAO();
		if(destinationDAO.registerDestination(destinationDTO)){ //update成功時にtrueが返される
			result =SUCCESS;
		}else{ //falseの時

		}
		return result;

	}


	public String getFamilyName(){
		return familyName;
	}
	public void setFamilyName(String familyName){
		this.familyName=familyName;
	}

	public String getFirstName(){
		return firstName;
	}
	public void setFirstName(String firstName){
		this.firstName=firstName;
	}

	public String getFamilyNameKana(){
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana){
		this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana(){
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana){
		this.firstNameKana=firstNameKana;
	}

	public String getZip11(){
	return zip11;
	}
	public void setZip11(String zip11){
	this.zip11=zip11;
	}

	public String getAddr11(){
	return addr11;
	}
	public void setAddr11(String addr11){
	this.addr11=addr11;
	}

	public String getTelNumber(){
		return telNumber;
	}
	public void setTelNumber(String telNumber){
		this.telNumber=telNumber;
	}

	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}

	//@Override
	public void setSession(Map<String,Object> session){
		this.session=session;
	}

}
