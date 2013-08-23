package com.dt.wechatptf.services;

import com.dt.wechatptf.entity.Company;
import com.dt.wechatptf.util.ReturnMessage;

public interface CompanyService {
	
	public ReturnMessage addCompany(String account, String password, String name, String address, 
			String weiid, String director, String phone, String description);
	public ReturnMessage deleteCompany(String account);
	public ReturnMessage updateCompany(String account, String password, String name, String address, 
			String weiid, String director, String phone, String description);
	public Company queryCompany(String account);

}
