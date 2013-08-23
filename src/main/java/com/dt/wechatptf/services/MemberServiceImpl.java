package com.dt.wechatptf.services;

import java.sql.Date;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dt.wechatptf.dao.MemberDAO;
import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

@Path("company/{companyid}")
public class MemberServiceImpl implements MemberService {
	
	MemberDAO md = new MemberDAO();

	@POST
	@Path("/addMember/{weiid}")
	public ReturnMessage addMember(@PathParam("weiid") String weiid, @FormParam("name") String name, 
			@FormParam("gender") int gender, @FormParam("birthday") Date birthday, 
			@FormParam("address") String address, @FormParam("mail") String mail, 
			@FormParam("phone") String phone, @PathParam("companyid") int companyid) {
		Member member = new Member(weiid, name, gender, birthday, address, mail, phone, 0);
		return md.addMember(member, companyid);
	}

	@DELETE
	@Path("/deleteMember/{weiid}")
	public ReturnMessage deleteMember(@PathParam("weiid") String weiid, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.deleteMember(weiid, companyid);
	}

	@POST
	@Path("/updateMember/{weiid}")
	public ReturnMessage updateMember(@PathParam("weiid") String weiid, @FormParam("name") String name, 
			@FormParam("gender") int gender, @FormParam("birthday") Date birthday, 
			@FormParam("address") String address, @FormParam("mail") String mail, 
			@FormParam("phone") String phone, @PathParam("companyid") int companyid) {
		Member member = new Member(weiid, name, gender, birthday, address, mail, phone, 0);
		return md.updateMember(member, companyid);
	}

	@GET
	@Path("/queryMember/{weiid}")
	public Member queryMember(@PathParam("weiid") String weiid, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.queryMember(weiid, companyid);
	}

}
