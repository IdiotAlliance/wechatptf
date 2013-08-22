package com.dt.wechatptf.dao;

import java.sql.Connection;

public class MemberCompanyDAO {
	
	Connection conn;
	
	public MemberCompanyDAO(){
		conn = DBConnection.getDBConnection();
	}

}
