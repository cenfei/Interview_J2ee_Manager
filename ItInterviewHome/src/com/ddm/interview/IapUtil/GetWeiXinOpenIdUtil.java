package com.ddm.interview.IapUtil;


import org.apache.log4j.Logger;
import org.json.JSONObject;




/**
 * 

 * @类名：GetWeiXinOpenId.java

 * @功能说明：获取微信的openid

 * @创建人： foxcen

 * @创建日期：  #build 2013-12-31  -0

 * @修改人： foxcen

 * @修改日期：  #change 2013-12-31  -0

 * @版本号：1.00
 */
public class GetWeiXinOpenIdUtil {
	private static Logger log = Logger.getLogger(GetWeiXinOpenIdUtil.class);

	/**
	 * 
	
	 * @功能说明：通过https协议获取微信  的json数据   获取openid
	
	 * @返回类型：String
	 */
	public static  String  getWeiXinId(String url){
	
		String openId=null;
		try{
	String result=	HttpsUtil.sendByGet(url);
		if(MyStringUtils.isNotNullAndEmpty(result)){
	
			JSONObject  dataJson=new JSONObject(result);
					openId=dataJson.getString("openid");
	
		}
	
		}
		catch (Exception e) {
			// TODO: handle exception
			log.error("aa",e);
		}
		return openId;
	}
		
	
}
