package com.dt.wechatptf.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dt.wechatptf.dao.MemberDAO;
import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

@Path("company")
public class MemberServiceImpl implements MemberService {
	
	MemberDAO md = new MemberDAO();

	@POST
	@Path("/{companyid}/addMember")
	public ReturnMessage addMember(Member member, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.addMember(member, companyid);
	}

	@DELETE
	@Path("/{companyid}/deleteMember/{weiid}")
	public ReturnMessage deleteMember(@PathParam("weiid") String weiid, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.deleteMember(weiid, companyid);
	}

	@POST
	@Path("/{companyid}/updateMember")
	public ReturnMessage updateMember(Member member, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.updateMember(member, companyid);
	}

	@GET
	@Path("/{companyid}/queryMember/{weiid}")
	public Member queryMember(@PathParam("weiid") String weiid, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return md.queryMember(weiid, companyid);
	}

}
