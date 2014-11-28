package com.ddm.interview.IapUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

public class WebvarPropertyUtil {

	public final static Properties p = new Properties();
	public static String USER_SORTFIELD = "";
	public static String ACTIVE_SORTFIELD = "";
	
	
	public static String User_Sort_Name = "UserSortField";
	public static String Active_Sort_Name = "ActiveSortField";

	static {
		try {
			USER_SORTFIELD = getValueByKey(User_Sort_Name);

			ACTIVE_SORTFIELD = getValueByKey(Active_Sort_Name);
		} catch (Exception e) {
			// TODO Auto-generated catch block

		}
	}

	
	
	
	public static String getValueByKey(String key) throws Exception {

		if (p.isEmpty()) {
			InputStream is = WebvarPropertyUtil.class.getClassLoader()
					.getResourceAsStream("webvar.properties");
			try {
				p.load(is);
			} catch (IOException e) {
				throw new Exception("load failure,system.properties not exist!");
			} finally {

				is.close();

			}
		}

		return p.getProperty(key);
	}

	/**
	 * 修改或添加键值对 如果key存在，修改 反之，添加。
	 * 
	 * @param key
	 * @param value
	 * @throws UnsupportedEncodingException
	 */
	public static void writeData(String key, String value)
			throws UnsupportedEncodingException {

		String pathsrc = WebvarPropertyUtil.class.getResource("/").getFile()
				+ "webvar.properties";
		pathsrc = URLDecoder.decode(pathsrc, "utf-8");
		pathsrc = pathsrc.substring(1, pathsrc.length());
		System.out.println(pathsrc);
		OutputStream fos = null;
		try {
			File file = new File(pathsrc);
			if (!file.exists())
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			p.load(fis);
			fis.close();// 一定要在修改值之前关闭fis

			fos = new FileOutputStream(file);
			p.setProperty(key, value);
			p.store(fos, "Update '" + key + "' value");
			fos.close();
		} catch (IOException e) {
			System.err.println("Visit " + pathsrc + " for updating " + value
					+ " value error");
		} finally {

			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void main(String args[]) throws IOException {

		try {
			System.out.println(WebvarPropertyUtil.getValueByKey("pagesize"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			WebvarPropertyUtil.writeData("pagesize", "10");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			System.out.println(WebvarPropertyUtil.getValueByKey("pagesize"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
