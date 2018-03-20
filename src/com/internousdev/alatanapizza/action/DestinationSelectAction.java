package com.internousdev.alatanapizza.action;
//DAOであて先情報を持ってくるためのアクション
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.alatanapizza.dao.DestinationDAO;
import com.internousdev.alatanapizza.dto.DestinationDTO;
import com.opensymphony.xwork2.ActionSupport;


public class DestinationSelectAction extends ActionSupport implements SessionAware{
	DestinationDAO destinationDAO=new DestinationDAO();
	DestinationDTO destinationDTO=new DestinationDTO();
	private ArrayList<DestinationDTO> destinationInfoListDTO= new ArrayList<DestinationDTO>();
	public Map<String,Object>session;
	String result;

	public String execute() throws SQLException{
		result=SUCCESS;

	destinationInfoListDTO.addAll(destinationDAO
			.obtainingDestinationInfo(session.get("userId").toString()));
	if(destinationInfoListDTO.get(0)==null){
		result=ERROR;
	}
	return result;

}

	public ArrayList<DestinationDTO> getDestinationInfoListDTO() {
		return destinationInfoListDTO;
	}

	public void setDestinationInfoListDTO(ArrayList<DestinationDTO> destinationInfoListDTO) {
		this.destinationInfoListDTO = destinationInfoListDTO;
	}

	@Override
	public void setSession(Map<String, Object>session) {
		this.session=session;

	}
}
