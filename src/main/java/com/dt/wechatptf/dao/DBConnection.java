package com.dt.wechatptf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.dt.wechatptf.util.PropertiesUtil;

public class DBConnection {
	
	private static Connection singleCon;
	private static final PropertiesUtil pu = new PropertiesUtil("db.properties");
	
	public static Connection getDBConnection(){
		if (singleCon == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url = pu.getStringProperty("db.url");
				String user = pu.getStringProperty("db.username");
				String pass = pu.getStringProperty("db.password");
				singleCon = DriverManager.getConnection(url,user,pass);
			}catch(SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return singleCon;	
	}

}
