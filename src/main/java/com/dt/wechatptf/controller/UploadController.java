package com.dt.wechatptf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="upload/{companyId}/{wxid}")
public class UploadController extends BaseController{

	@RequestMapping(value="/img", method=RequestMethod.POST)
	public String uploadImage(@RequestParam("img") MultipartFile file){
		
		return null;
	}
	
}
