package com.dt.wechatptf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dt.wechatptf.entity.Member;

public class MemberCompanyDAO {
	
	Connection conn;
	
	public MemberCompanyDAO(){
		conn = DBConnection.getDBConnection();
	}
	
	public ArrayList<Member> queryMembers(int companyid){
		ArrayList<Member> members = new ArrayList<Member>();
		try {
			PreparedStatement ps1=conn.prepareStatement("select memberid from member_company where companyid=?");
			ps1.setInt(1, companyid);
			ResultSet rs1=ps1.executeQuery();
			while (rs1.next()){
				int memberid = rs1.getInt(1);
				PreparedStatement ps2=conn.prepareStatement("select * from member where id=?");
				ps2.setInt(1, memberid);
				ResultSet rs2=ps2.executeQuery();
				if(rs2.next()){
					Member member = new Member();
					member.setId(rs2.getInt(1));
					member.setWeiid(rs2.getString(2));
					member.setName(rs2.getString(3));
					member.setGender(rs2.getInt(4));
					member.setBirthday(rs2.getDate(5));
					member.setAddress(rs2.getString(6));
					member.setMail(rs2.getString(7));
					member.setPhone(rs2.getString(8));
					member.setPoints(rs2.getInt(9));
					members.add(member);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return members;
	}
	
	public static void main(String[] args){
		MemberCompanyDAO mcd = new MemberCompanyDAO();
		ArrayList<Member> ms = mcd.queryMembers(1);
		for(int i=0; i<ms.size(); i++){
			System.out.println(ms.get(i).getId());
			System.out.println(ms.get(i).getName());
		}
	}

}
