
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

/**
 * 

 * @类名：SystemPropertyUtil.java

 * @功能说明：增删改查配置文件  

 * @创建人： felix

 * @创建日期：  #build 2012-10-24  -0

 * @修改人： fellix

 * @修改日期：  #change 2012-10-24  -0

 * @版本号：1.00
 */

public class SystemPropertyUtil {

	public final static Properties p = new Properties();

	public static String getValueByKey(String key) throws Exception {

		if ( p.isEmpty() )
		{
			InputStream is = SystemPropertyUtil.class.getClassLoader().getResourceAsStream("db.properties");
			try
			{
				p.load(is);
			}
			catch ( IOException e )
			{
				throw new Exception("load failure,system.properties not exist!");
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
	public static void writeData(String key, String value) throws UnsupportedEncodingException {

		String pathsrc = SystemPropertyUtil.class.getResource("/").getFile() + "db.properties";
		pathsrc = URLDecoder.decode(pathsrc, "utf-8");
		pathsrc = pathsrc.substring(1, pathsrc.length());
		System.out.println(pathsrc);
		try
		{
			File file = new File(pathsrc);
			if ( !file.exists() )
				file.createNewFile();
			InputStream fis = new FileInputStream(file);
			p.load(fis);
			fis.close();// 一定要在修改值之前关闭fis

			OutputStream fos = new FileOutputStream(file);
			p.setProperty(key, value);
			p.store(fos, "Update '" + key + "' value");
			fos.close();
		}
		catch ( IOException e )
		{
			System.err.println("Visit " + pathsrc + " for updating " + value + " value error");
		}
	}

	public static List<PropertiesTool> readProperties() throws UnsupportedEncodingException {

		String src = SystemPropertyUtil.class.getResource("/").getFile() + "db.properties";
		src = URLDecoder.decode(src, "utf-8");
		src = src.substring(1, src.length());

		Properties props = new Properties();
		List<PropertiesTool> proList = new ArrayList<PropertiesTool>();

		Integer i = 0;
		try
		{
			File file = new File(src);
			InputStream in = new FileInputStream(file);
			props.load(in);
			Enumeration en = props.propertyNames();
			while ( en.hasMoreElements() )
			{
				String key = (String) en.nextElement();
				String value = props.getProperty(key);
				PropertiesTool proTool = new PropertiesTool();
				proTool.setKey(key);
				proTool.setValue(value);
				proList.add(i, proTool);
				i++;
				// 把properties文件中的key-value存放到一个map中
			}
			return proList;
		}
		catch ( Exception e )
		{
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String args[]) throws IOException {

	}
}
