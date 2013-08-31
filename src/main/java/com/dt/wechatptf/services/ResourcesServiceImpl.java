package com.dt.wechatptf.services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/upload")
public class ResourcesServiceImpl extends BaseService implements ResourcesService{

	@Path("/img/{img_name}")
	public byte[] serveImage(@PathParam("img_name") String path) {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			File f = new File("/home/lvxiang/123.jpg");
			if(f.exists()){
				FileInputStream fis = new FileInputStream(f);
				byte[] buf = new byte[1024];
				int len    = 0;
				while((len = fis.read(buf)) != 0){
					bos.write(buf, 0, len);
				}
				return bos.toByteArray();
			}
			throw new NullPointerException();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
