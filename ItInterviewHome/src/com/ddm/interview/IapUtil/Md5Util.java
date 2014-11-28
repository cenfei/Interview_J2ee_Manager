package com.ddm.interview.IapUtil;

import java.security.*;
import java.util.*;

/**
 *
 */
public class Md5Util {

	 public static String md5Digest(String src) throws Exception {  
         // 定义数字签名方法, 可用：MD5, SHA-1  
         MessageDigest md = MessageDigest.getInstance("MD5");  
         byte[] b = md.digest(src.getBytes("utf-8"));  
             
         return byte2HexStr(b);  
    }
    

     private static String byte2HexStr(byte[] b) {  
         StringBuilder sb = new StringBuilder();  
         for (int i = 0; i < b.length; i++) {  
             String s = Integer.toHexString(b[i] & 0xFF);  
             if (s.length() == 1) {  
                  sb.append("0");  
             }  
                   
             sb.append(s.toUpperCase());  
          }  
               
          return sb.toString();  
     } 
     public  static void  main(String args[]) throws Exception{
    	 
    	 System.out.println(Md5Util.md5Digest("123456"));
    	 
    	 
     }
     
}
