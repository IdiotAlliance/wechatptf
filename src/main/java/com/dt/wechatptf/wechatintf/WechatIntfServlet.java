package com.dt.wechatptf.wechatintf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dt.wechatptf.util.Encoder;
import com.dt.wechatptf.util.WechatXMLUtil;
import com.dt.wechatptf.util.WechatXMLUtil.WechatMsg;

/**
 * Servlet implementation class WechatIntfServlet
 */
@WebServlet("/WechatIntfServlet")
public class WechatIntfServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WechatIntfServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * this function handles callbacks from wechat
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String token = "wechatptf";
		
		String userId    = request.getContextPath();
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce     = request.getParameter("nonce");
		String echostr   = request.getParameter("echostr");
		
		String local_sig = "";
		if(token != null && timestamp != null && nonce != null){
			if(token.compareTo(timestamp) > 0){
				if(token.compareTo(nonce) > 0){
					if(nonce.compareTo(timestamp) > 0) local_sig = timestamp + nonce + token;
					else local_sig = nonce + timestamp + token;
				}
				else local_sig = timestamp + token + nonce;
			}
			else{
				if(timestamp.compareTo(nonce) > 0){
					if(nonce.compareTo(token) > 0) local_sig = token + nonce + timestamp;
					else local_sig = nonce + token + timestamp;
				}
				else local_sig = token + timestamp + nonce;
			}
			
			// compare sha1 codes
			if(signature != null && signature.equals(Encoder.encodeSHA1(local_sig))){
				response.getWriter().write(echostr);
				response.flushBuffer();
				return;
			}
		}
		response.getWriter().write(echostr + "1");
		response.getWriter().flush();
		return;
		
	}

	/**
	 * This interface is for messages post from wechat
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get input from wechat
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream()));
		String input = "";
		String temp  = null;
		while((temp = reader.readLine()) != null)
			input += temp;
		
		// parse xml string
		WechatMsg msg     = WechatXMLUtil.parseMsg(input);
		String fromUser   = msg.valueOf(WechatXMLUtil.KEY_FROM_USER_LOWER);
		String toUser     = msg.valueOf(WechatXMLUtil.KEY_TO_USER_LOWER);
		String createTime = msg.valueOf(WechatXMLUtil.KEY_CREATE_TIME_LOWER);
		switch(msg.getType()){
		case WechatXMLUtil.MSG_TYPE_TEXT:{
			break;
		}
		case WechatXMLUtil.MSG_TYPE_GEO:{
			break;
		}
		case WechatXMLUtil.MSG_TYPE_EVENT:{
			break;
		}
		}
	}
	
}
