package com.dt.wechatptf.wechatintf;

import com.dt.wechatptf.util.WechatXMLUtil;
import com.dt.wechatptf.util.WechatXMLUtil.WechatMsg;

public class WechatMessageHandler {

	public static String handleMsg(String userId, WechatMsg msg){
		switch(msg.getType()){
		case WechatXMLUtil.MSG_TYPE_TEXT:{
			return new TextMessageHandler(userId, msg).handleMsg();
		}
		case WechatXMLUtil.MSG_TYPE_GEO:{
			return new TextMessageHandler(userId, msg).handleMsg();
		}
		case WechatXMLUtil.MSG_TYPE_EVENT:{
			return new EventMessageHandler(userId, msg).handleMsg();
		}
		}
		return null;
	}
	
	private static abstract class MessageHandler{
		protected WechatMsg wm;
		protected String fromUser;
		protected String toUser;
		protected long createTime;
		
		public MessageHandler(String userId, WechatMsg wm){
			this.wm = wm;
			this.fromUser = wm.valueOf(WechatXMLUtil.KEY_FROM_USER_LOWER);
			this.toUser   = wm.valueOf(WechatXMLUtil.KEY_TO_USER);
			this.createTime = Long.parseLong(WechatXMLUtil.KEY_CREATE_TIME);
			//TODO some other jobs
		}
		
		public abstract String handleMsg();
	}
	
	private static class TextMessageHandler extends MessageHandler{

		public TextMessageHandler(String userId, WechatMsg wm) {
			super(userId, wm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String handleMsg() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
	private static class EventMessageHandler extends MessageHandler{

		public EventMessageHandler(String userId, WechatMsg wm) {
			super(userId, wm);
			// TODO Auto-generated constructor stub
			
		}

		@Override
		public String handleMsg() {
			
			return null;
		}
	}
	
	private static class GeoMessageHandler extends MessageHandler{

		public GeoMessageHandler(String userId, WechatMsg wm) {
			super(userId, wm);
			// TODO Auto-generated constructor stub
		}

		@Override
		public String handleMsg() {
			// TODO Auto-generated method stub
			return null;
		}
	}
	
}
