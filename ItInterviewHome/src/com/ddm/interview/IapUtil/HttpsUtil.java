package com.ddm.interview.IapUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.log4j.Logger;

 

public class HttpsUtil {
 
 private static Logger log = Logger.getLogger(HttpsUtil.class); 
 private static Protocol https = null;
 
 static {
  https = new Protocol("https", new MySecureProtocolSocketFactory(), 443);
  Protocol.registerProtocol("https", https);
 }
 
 public static String sendByGet(String url){ 
  HttpClient httpclient = null;
  GetMethod method = null;
  String result = "";
  
  try {

 

   httpclient = new HttpClient();
   method = new GetMethod(url);
   
   httpclient.executeMethod(method);
   //result = method.getResponseBodyAsString();
   BufferedReader bs = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "utf-8"));
   String line = "";
      while((line = bs.readLine()) != null){
       result += line;
      }
   
   log.info("HttpsUtil-sendByGet-url=" + url );
   log.info("result="+result);
  } catch(Exception ex){
   ex.printStackTrace();
   result = "error\tcrm error " + ex.toString();
   log.error("HttpsUtil-sendByGet-url=" + url + "-result=" + ex.toString());
   
  } finally{
   if(method != null){
    method.releaseConnection();
   }
  }
  
  return result;
 }
 
 public static String sendByPost(String url, Map param){
  HttpClient httpclient = null;
  PostMethod method = null;
  String result = "";
  
  try {

 

   httpclient = new HttpClient();
   method = new PostMethod(url);
   if(param != null && !param.isEmpty()){
    int len = param.size();
    method.setRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
    NameValuePair[] np = new NameValuePair[len];
    Iterator iter = param.keySet().iterator();
    int i = 0;
    while(iter.hasNext()){
        String k = (String)iter.next();
        String v = (String)param.get(k) ;
        np[i].setName(k);
        np[i].setValue(v);
    } 
   
    method.setRequestBody(np);
   }
   
   httpclient.executeMethod(method);
   //result = method.getResponseBodyAsString();
   BufferedReader bs = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "utf-8"));
   String line = "";
      while((line = bs.readLine()) != null){
       result += line;
      }
      
   log.info("HttpsUtil-sendByPost-url=" + url + "-result=" + result);
   
  } catch(Exception ex){
   ex.printStackTrace();
   result = "error\tcrm error " + ex.toString();
   log.error("HttpsUtil-sendByPost-url=" + url + "-result=" + ex.toString());
   
  } finally{
   if(method != null){
    method.releaseConnection();
   }
  }
  
  return result;  
 }

 public  static void main(String[] args){
	 
	 HttpsUtil.sendByGet("https://api.weixin.qq.com/sns/oauth2/access_token?appid=wxb37944ac0f35cd29&secret=10695da24f156d4f5f40a21314284217&code=" + "1" + "&grant_type=authorization_code");
	 
 }

}