package com.dt.wechat.ptf.dao.member;

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
			PreparedStatement ps = conn.prepareStatement("insert into member (name,memberid,companyid,gender,birthday,address,mail,weiid,phone) values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, member.getName());
			ps.setString(2, member.getMemberid());
			ps.setInt(3, member.getCompanyid());
			ps.setInt(4, member.getGender());
			ps.setDate(5, member.getBirthday());
			ps.setString(6, member.getAddress());
			ps.setString(7, member.getMail());
			ps.setString(8, member.getWeiid());
			ps.setString(9, member.getPhone());
			ps.executeUpdate();
			message.setFail(0);
			message.setMessage("添加会员成功！");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			message.setFail(1);
			
			try {
				PreparedStatement ps1=conn.prepareStatement("select id from member where memberid=? and companyid=?");
				ps1.setString(1, member.getMemberid());
				ps1.setInt(2, member.getCompanyid());
				ResultSet rs=ps1.executeQuery();
				if (rs !=null){
					message.setMessage("添加会员失败，该会员已存在！");
				}
				else{
					message.setMessage("添加会员失败，未知错误！");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return message;
	}
	
	/**
	 * 删除会员
	 * @param memberid
	 * @param companyid
	 * @return
	 */
	public ReturnMessage deleteMember(String memberid, int companyid){
		ReturnMessage message = new ReturnMessage();
		try {
			PreparedStatement ps=conn.prepareStatement("delete from member where memberid=? and companyid=?");
			ps.setString(1,memberid);
			ps.setInt(2, companyid);
			ps.executeUpdate();
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
			PreparedStatement ps=conn.prepareStatement("update member set name=?,gender=?,birthday=?,address=?,mail=?,weiid=?,phone=? where memberid=? and companyid=?");
			ps.setString(1, member.getName());
			ps.setInt(2, member.getGender());
			ps.setDate(3, member.getBirthday());
			ps.setString(4, member.getAddress());
			ps.setString(5, member.getMail());
			ps.setString(6, member.getWeiid());
			ps.setString(7, member.getPhone());
			ps.setString(8, member.getMemberid());
			ps.setInt(9, member.getCompanyid());
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
	
	public Member queryMember(String memberid, int companyid){
		Member member = new Member();
		try {
			PreparedStatement ps=conn.prepareStatement("select * from member where memberid=? and companyid=?");
			ps.setString(1, memberid);
			ps.setInt(2, companyid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()){
				member.setId(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setMemberid(rs.getString(3));
				member.setCompanyid(rs.getInt(4));
				member.setGender(rs.getInt(5));
				member.setBirthday(rs.getDate(6));
				member.setAddress(rs.getString(7));
				member.setMail(rs.getString(8));
				member.setPhone(rs.getString(9));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
	}
	
	public static void main(String[] args){
		MemberDAO md = new MemberDAO();
		
//		Member m = new Member();
//		m.setName("Cassie");
//		m.setMemberid("091250112");
//		m.setCompanyid(1);
//		Calendar c = Calendar.getInstance();
//		c.set(Calendar.YEAR, 1991);
//		c.set(Calendar.MONTH, 2);	//month从0开始
//		c.set(Calendar.DAY_OF_MONTH, 9);
//		long birthday = c.getTimeInMillis();
//		m.setBirthday(new Date(birthday));
//		ReturnMessage rm = md.addMember(m);
//		System.out.println(rm.getMessage());
		
//		ReturnMessage rm = md.deleteMember("091250112", 1);
//		System.out.println(rm.getMessage());
		
		Member m = new Member();
		m.setMemberid("091250112");
		m.setCompanyid(2);
		m.setName("Cassie");
		m.setMail("909103970@qq.com");
		ReturnMessage rm = md.updateMember(m);
		System.out.println(rm.getMessage());
	}

}
