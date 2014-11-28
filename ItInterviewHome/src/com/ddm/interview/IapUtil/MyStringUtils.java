package com.ddm.interview.IapUtil;

/**
 * 
 * 
 * @类名：StringUtils.java
 * 
 * @功能说明：字符串工具类
 * 
 * @创建人： foxcen
 * 
 * @创建日期： #build 2013-12-22 -0
 * 
 * @修改人： foxcen
 * 
 * @修改日期： #change 2013-12-22 -0
 * 
 * @版本号：1.00
 */
public class MyStringUtils {

	/**
	 * 
	 * 
	 * @功能说明：字符串不为null且不为“”
	 * 
	 * @返回类型：boolean
	 */
	public static boolean isNotNullAndEmpty(Object param) {

		if (null != param && !param.equals("")) {
			return true;
		}

		return false;

	}

}
