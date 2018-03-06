package com.internousdev.alatanapizza.dao;

import com.internousdev.alatanapizza.util.DBConnector;

public class DestinationDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection=dbConnector.getConnection();

	private DateUtil dateUtil=new DateUtil();

	private String sql="INSERT INTO login_user_transaction("

}
