package com.dt.wechatptf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection singleCon;
	
	public static Connection getDBConnection(){
		if (singleCon == null){
			try{
				Class.forName("com.mysql.jdbc.Driver");
				String url = "jdbc:mysql://127.0.0.1:3306/wechatptf_dev";
				String user = "root";
				String pass = "199139";
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
