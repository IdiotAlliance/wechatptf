package com.dt.wechatptf.services;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.dt.wechatptf.dao.CompanyDAO;
import com.dt.wechatptf.entity.Company;
import com.dt.wechatptf.util.ReturnMessage;

@Path("company")
public class CompanyServiceImpl implements CompanyService {
	
	CompanyDAO cd = new CompanyDAO();

	@POST
	@Path("/addCompany")
	public ReturnMessage addCompany(@FormParam("account") String account, @FormParam("password") String password,
			@FormParam("name") String name, @FormParam("address") String address, 
			@FormParam("weiid") String weiid, @FormParam("director") String director,
			@FormParam("phone") String phone, @FormParam("description") String description) {
		Company company = new Company(account,password,name,address,weiid,director,phone,description);
		return cd.addCompany(company);
	}

	@DELETE
	@Path("/deleteCompany/{account}")
	public ReturnMessage deleteCompany(@PathParam("account") String account) {
		// TODO Auto-generated method stub
		return cd.deleteCompany(account);
	}

	@POST
	@Path("/updateCompany/{account}")
	public ReturnMessage updateCompany(@PathParam("account") String account, @FormParam("password") String password,
			@FormParam("name") String name, @FormParam("address") String address, 
			@FormParam("weiid") String weiid, @FormParam("director") String director,
			@FormParam("phone") String phone, @FormParam("description") String description) {
		Company company = new Company(account,password,name,address,weiid,director,phone,description);
		return cd.updateCompany(company);
	}

	@GET
	@Path("/queryCompany/{account}")
	public Company queryCompany(@PathParam("account") String account) {
		// TODO Auto-generated method stub
		return cd.queryCompany(account);
	}

}
