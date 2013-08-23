package com.dt.wechatptf.services;

import java.sql.Date;

import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

public interface MemberService {
	
	public ReturnMessage addMember(String weiid, String name, int gender, Date birthday, 
			String address, String mail, String phone, int companyid);
	public ReturnMessage deleteMember(String weiid, int companyid);
	public ReturnMessage updateMember(String weiid, String name, int gender, Date birthday, 
			String address, String mail, String phone, int companyid);
	public Member queryMember(String weiid, int companyid);

}
