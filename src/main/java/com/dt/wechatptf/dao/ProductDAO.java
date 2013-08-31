package com.dt.wechatptf.dao;

import java.sql.Connection;

public class ProductDAO {
	
	Connection conn;
	
	public ProductDAO(){
		conn = DBConnection.getChatDBConnection();
	}

}
