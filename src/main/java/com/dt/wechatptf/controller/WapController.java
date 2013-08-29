package com.dt.wechatptf.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
