package com.dt.wechatptf.services;

import java.util.ArrayList;

import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

public interface MemberCompanyService {
	
	public ArrayList<Member> queryMembers(String account);
	public int queryPoints(String weiid, int companyid);
	public ReturnMessage updatePoints(String weiid, int companyid, int addPoints);

}
