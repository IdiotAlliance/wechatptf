package com.dt.wechatptf.services;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dt.wechatptf.dao.MemberCompanyDAO;
import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

@Path("company")
public class MemberCompanyServiceImpl implements MemberCompanyService {
	
	MemberCompanyDAO mcd = new MemberCompanyDAO();

	@GET
	@Path("/queryMembers/{account}")
	public ArrayList<Member> queryMembers(@PathParam("account") String account) {
		// TODO Auto-generated method stub
		return mcd.queryMembers(account);
	}

	@GET
	@Path("/{companyid}/queryPoints/{weiid}")
	public int queryPoints(@PathParam("weiid") String weiid, @PathParam("companyid") int companyid) {
		// TODO Auto-generated method stub
		return mcd.queryPoints(weiid, companyid);
	}
	
	@POST
	@Path("/{companyid}/updatePoints/{weiid}/{addPoints}")
	public ReturnMessage updatePoints(@PathParam("weiid") String weiid, 
			@PathParam("companyid") int companyid, @PathParam("addPoints") int addPoints) {
		// TODO Auto-generated method stub
		return mcd.updatePoints(weiid, companyid, addPoints);
	}

}
