package com.dt.wechatptf.controller;

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
		return null;
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
