package com.dt.wechatptf.member.test;

import java.sql.Date;
import java.util.Calendar;

import org.junit.Test;

import com.dt.wechat.ptf.dao.member.MemberDAO;
import com.dt.wechatptf.entity.Member;

public class MemberDAOTest {

	@Test
	public void testAddMember(){
		Member m = new Member();
		m.setName("Cassie");
		m.setMemberid("091250112");
		m.setCompanyid(1);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, 1991);
		c.set(Calendar.MONTH, 2);	//month从0开始
		c.set(Calendar.DAY_OF_MONTH, 9);
		long birthday = c.getTimeInMillis();
		m.setBirthday(new Date(birthday));
		
		MemberDAO md = new MemberDAO();
		md.addMember(m);	
	}
	
	@Test
	public void testDeleteMember(){
		MemberDAO md = new MemberDAO();
		md.deleteMember("091250112", 1);
	}

}
