package com.dt.wechatptf.members.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.dt.wechatptf.entity.Member;

public class MemberDAO {
	
	public Connection conn;
	
	public MemberDAO(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://127.0.0.1:3306/desserthouse";
			String user = "root";
			String pass = "199139";
			conn = DriverManager.getConnection(url,user,pass);
		}catch(SQLException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addMember(Member member){
		try {
			PreparedStatement ps = conn.prepareStatement("insert into member (name,gender,birthday,address,mail,weiid,phone,companyid) values(?,?,?,?,?,?,?,?)");
			ps.setString(1,member.getName());
			ps.setString(2,member.getGender()+"");
			ps.setString(3,member.getBirthday()+"");
			ps.setString(4,member.getAddress());
			ps.setString(5,member.getMail());
			ps.setString(6,member.getWeiid());
			ps.setString(7,member.getPhone());
			ps.setString(8,member.getCompanyid()+"");
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		Member m = new Member();
		m.setName("Cassie");
		m.setBirthday(new Date());
		m.setCompanyid(1);
		
		MemberDAO md = new MemberDAO();
		md.addMember(m);
	}

}
