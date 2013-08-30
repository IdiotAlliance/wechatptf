package com.dt.wechatptf.controller;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.dt.wechatptf.dao.MemberDAO;
import com.dt.wechatptf.entity.Member;
import com.dt.wechatptf.util.ReturnMessage;

@Controller
@RequestMapping(value="wap/{companyid}/{wxid}")
public class WapController {
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView index(@PathVariable("companyid") String cid, 
			@PathVariable("wxid") String wid){
		return new ModelAndView("wap_index");
	}
	
	@RequestMapping(value="/userindex", method=RequestMethod.GET)
	public ModelAndView userIndex(){
		return null;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public ModelAndView profile(){
		Map<String, String> ds = new HashMap<String, String>();
		ds.put("cid", "123");
		ds.put("wxid", "2345");
		ModelAndView mv = new ModelAndView("wap_profile");
		mv.addAllObjects(ds);
		return mv;
	}
	
	@RequestMapping(value="/bind", method=RequestMethod.POST)
	public ModelAndView bind(@PathVariable("companyid") int cid, @PathVariable("wxid") String wid, 
			String name, int gender, int birth_year, int birth_month, int birth_day, 
			String address, String mail, String phone){
		Member mem = new Member();
		mem.setWeiid(wid);
		mem.setName(name);
		mem.setGender(gender);
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, birth_year);
		c.set(Calendar.MONTH, birth_month-1);	//month从0开始
		c.set(Calendar.DAY_OF_MONTH, birth_day);
		long birthday = c.getTimeInMillis();
		mem.setBirthday(new Date(birthday));
		mem.setAddress(address);
		mem.setMail(mail);
		mem.setPhone(phone);
		
		MemberDAO md = new MemberDAO();
		ReturnMessage rm = md.addMember(mem, cid);
		
		Map<String, String> ds = new HashMap<String, String>();
		ds.put("fail", rm.getFail()+"");
		ds.put("msg", rm.getMessage());
		ModelAndView mv = new ModelAndView("wap_bind_success");
		mv.addAllObjects(ds);
		return mv;
	}
	
	@RequestMapping(value="/bindSuccess", method=RequestMethod.GET)
	public ModelAndView bindSuccess(){
		return new ModelAndView("wap_bind_success");
	}

	@RequestMapping(value="/product", method=RequestMethod.GET)
	public ModelAndView product(){
		return null;
	}
	
	@RequestMapping(value="order", method=RequestMethod.GET)
	public ModelAndView order(){
		return null;
	}
	
	@RequestMapping(value="pay", method=RequestMethod.GET)
	public ModelAndView pay(){
		return null;
	}
}
