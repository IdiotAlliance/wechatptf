package com.dt.wechat.ptf.dao.member;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import com.dt.wechatptf.dao.DBConnection;
import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

public class MemberDAO {
	
	Connection conn;
	
	public MemberDAO(){
		conn = DBConnection.getDBConnection();
	}
	
	/**
	 * 添加会员
	 * @param member
	 */
	public ReturnMessage addMember(Member member){
		ReturnMessage message = new ReturnMessage();
		try {
			PreparedStatement ps1 = conn.prepareStatement("insert into member (name,gender,birthday,address,mail,weiid,phone,points) values(?,?,?,?,?,?,?,?)");
			ps1.setString(1, member.getName());
			ps1.setInt(2, member.getGender());
			ps1.setDate(3, member.getBirthday());
			ps1.setString(4, member.getAddress());
			ps1.setString(5, member.getMail());
			ps1.setString(6, member.getWeiid());
			ps1.setString(7, member.getPhone());
			ps1.setInt(8, member.getPoints());
			ps1.executeUpdate();
			
			Serializable ret = null;
			ResultSet rs=ps1.getGeneratedKeys();
			if (rs.next()) {
                ret = (Serializable) rs.getObject(1);
            }
			int id = (Integer)ret;
			String memberid = id+"";
			System.out.println(memberid);
			while(memberid.length() < 4){
				memberid = "0" + memberid;
			}
			PreparedStatement ps2=conn.prepareStatement("update member set memberid=? where id=?");
			ps2.setString(1, memberid);
			ps2.setInt(2, id);
			ps2.executeUpdate();
			
			message.setFail(0);
			message.setMessage("添加会员成功！会员号为" + memberid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setFail(1);
			message.setMessage("添加会员失败，未知错误！");
		}
		return message;
	}
	
	/**
	 * 删除会员
	 * @param memberid
	 * @param companyid
	 * @return
	 */
	public ReturnMessage deleteMember(String memberid){
		ReturnMessage message = new ReturnMessage();
		try {
			PreparedStatement ps1=conn.prepareStatement("delete from member where memberid=?");
			ps1.setString(1,memberid);
			ps1.executeUpdate();
			
			PreparedStatement ps2=conn.prepareStatement("delete from member_company where memberid=?");
			ps2.setString(1,memberid);
			ps2.executeUpdate();
			
			message.setFail(0);
			message.setMessage("删除会员成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setFail(1);
			message.setMessage("删除会员失败，未知错误！");

		}
		return message;
	}
	
	public ReturnMessage updateMember(Member member){
		ReturnMessage message = new ReturnMessage();
		try {
			PreparedStatement ps=conn.prepareStatement("update member set name=?,gender=?,birthday=?,address=?,mail=?,weiid=?,phone=?,points=? where memberid=?");
			ps.setString(1, member.getName());
			ps.setInt(2, member.getGender());
			ps.setDate(3, member.getBirthday());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getMail());
			ps.setString(6, member.getWeiid());
			ps.setString(7, member.getPhone());
			ps.setInt(8, member.getPoints());
			ps.setString(9, member.getMemberid());
			ps.executeUpdate();
			message.setFail(0);
			message.setMessage("修改会员信息成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setFail(1);
			message.setMessage("修改会员信息失败，未知错误！");
		}
		return message;
	}
	
	public Member queryMember(String memberid){
		Member member = new Member();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from member where memberid=");
			ps.setString(1, memberid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()){
				member.setId(rs.getInt(1));
				member.setMemberid(rs.getString(2));
				member.setName(rs.getString(3));
				member.setGender(rs.getInt(4));
				member.setBirthday(rs.getDate(5));
				member.setAddress(rs.getString(6));
				member.setMail(rs.getString(7));
				member.setWeiid(rs.getString(8));
				member.setPhone(rs.getString(9));
				member.setPoints(rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	public static void main(String[] args){
		MemberDAO md = new MemberDAO();
		
		Member m = new Member();
		m.setName("Cassie");
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1991);
		c.set(Calendar.MONTH, 2);	//month从0开始
		c.set(Calendar.DAY_OF_MONTH, 9);
		long birthday = c.getTimeInMillis();
		m.setBirthday(new Date(birthday));
		ReturnMessage rm = md.addMember(m);
		System.out.println(rm.getMessage());
		
//		ReturnMessage rm = md.deleteMember("091250112", 1);
//		System.out.println(rm.getMessage());
		
//		Member m = new Member();
//		m.setMemberid("091250112");
//		m.setCompanyid(2);
//		m.setName("Cassie");
//		m.setMail("909103970@qq.com");
//		ReturnMessage rm = md.updateMember(m);
//		System.out.println(rm.getMessage());
	}

}
