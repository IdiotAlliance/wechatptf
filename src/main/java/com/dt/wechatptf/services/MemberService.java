package com.dt.wechatptf.services;

import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

public interface MemberService {
	
	public ReturnMessage addMember(Member member, int companyid);
	public ReturnMessage deleteMember(String weiid, int companyid);
	public ReturnMessage updateMember(Member member, int companyid);
	public Member queryMember(String weiid, int companyid);

}
