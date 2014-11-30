/**
 * @工程名：InterviewTypeStatic
 * @功能：题型的类型变量静态
 * @时间：下午1:51:23
 * @用户：foxcen
 */
package com.ddm.interview.IapUtil;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author foxcen
 * 
 */
public class InterviewTypeStatic {

	// 面试题语言类型 枚举map
	public static final Map<Integer, String> languageTypeMap = new HashMap<Integer, String>();

	// 面试题选择类型 枚举map
	public static final Map<Integer, String> chooseTypeMap = new HashMap<Integer, String>();

	public static final Map<Integer, String> bigContentTypeMap = new HashMap<Integer, String>();

	public static final Map<Integer, String> smallContentTypeMap = new HashMap<Integer, String>();
	// 面试题 语言--大内容题型---小内容题型
	public static final Map<Integer, Map<Integer, Map<Integer, String>>> lanContentTypeMap = new HashMap<Integer, Map<Integer, Map<Integer, String>>>();

	/**
	 * 
	 * @功能：根据语言表示id和大内容map获取 大题型 list列表.或者根据大内容id和小内容内容map获取 大题型 list列表
	 * @返回参数：List<String>
	 * @输入参数：@param lanType 可以使语言类别也可以是大内容类别 * @输入参数：@param typeMap 根据传入的参数返回
	 *              大类型或者小类型的列表
	 * @输入参数：@return
	 */
	public static Map<Integer, String> getBigContentListFromLanType(
			Integer lanType, Map<Integer, String> typeMap) {
		Map<Integer, String> bigContentList = new HashMap<Integer, String>();

		Set<Integer> bigKeySet = typeMap.keySet();

		Iterator<Integer> iterator = bigKeySet.iterator();
		while (iterator.hasNext()) {
			Integer keyValueInteger = iterator.next();

			if (keyValueInteger > (lanType - 1) * 100
					&& keyValueInteger < lanType * 100) {

				bigContentList.put(keyValueInteger,
						typeMap.get(keyValueInteger));
			}

		}

		return bigContentList;
	}

	/**
	 * 
	 * 
	 * @功能说明：Boolean lanBool 表示当前是否是获取语言类别map, Integer lanType 是第几类语言类别
	 * 
	 * @返回类型：Integer
	 */
	public static Integer getMapValueFromKey(Map<Integer, String> map,
			String value, Boolean lanBool, Integer lanType) {

		Set<Integer> kset = map.keySet();
		Integer returnKey = 0;
		for (Integer ks : kset) {
			String keyValue = map.get(ks);

			if (!lanBool) {
				if (value.equalsIgnoreCase(keyValue)
						&& (ks > (lanType - 1) * 100 && ks < lanType * 100)) {
					returnKey = ks;
				}

			} else {
				if (value.equalsIgnoreCase(keyValue)) {
					returnKey = ks;
				}
			}

		}
		return returnKey;
	}

	static {

		languageTypeMap.put(1, "JAVA");
		languageTypeMap.put(2, "ANDROID");
		languageTypeMap.put(3, "IOS");
		languageTypeMap.put(4, "C");
		languageTypeMap.put(5, "C++");
		languageTypeMap.put(6, "PHP");

		chooseTypeMap.put(1, "选择题");
		chooseTypeMap.put(2, "填空题");
		chooseTypeMap.put(3, "简答题");

		// 面试题 语言--大内容题型

		bigContentTypeMap.put(1, "java章节基础题");
		bigContentTypeMap.put(2, "java经典编程题");
		bigContentTypeMap.put(3, "java流行框架题");
		bigContentTypeMap.put(4, "java性能优化题");
		bigContentTypeMap.put(5, "java名企面试题");

		bigContentTypeMap.put(101, "android章节基础题");
		bigContentTypeMap.put(102, "android经典编程题");
		bigContentTypeMap.put(103, "android流行框架题");
		bigContentTypeMap.put(104, "android性能优化题");
		bigContentTypeMap.put(105, "android名企面试题");

		bigContentTypeMap.put(201, "ios章节基础题");
		bigContentTypeMap.put(202, "ios经典编程题");
		bigContentTypeMap.put(203, "ios流行框架题");
		bigContentTypeMap.put(204, "ios性能优化题");
		bigContentTypeMap.put(205, "ios名企面试题");

		smallContentTypeMap.put(1, "java基础题");
		smallContentTypeMap.put(2, "构造方法");
		smallContentTypeMap.put(3, "字符和数组");
		smallContentTypeMap.put(4, "集合");
		smallContentTypeMap.put(5, "继承");
		smallContentTypeMap.put(6, "异常");
		smallContentTypeMap.put(7, "接口和抽象类");
		smallContentTypeMap.put(8, "线程");
		smallContentTypeMap.put(9, "重写");
		smallContentTypeMap.put(10, "JSP");
		smallContentTypeMap.put(11, "Sevlet");
		smallContentTypeMap.put(12, "JDBC");
		smallContentTypeMap.put(13, "Util");
		smallContentTypeMap.put(14, "IO流");
		smallContentTypeMap.put(16, "Misc");
		smallContentTypeMap.put(17, "xml");
		smallContentTypeMap.put(15, "其他");

		smallContentTypeMap.put(101, "Android基础题");
		smallContentTypeMap.put(102, "Activity");
		smallContentTypeMap.put(103, "Service");
		smallContentTypeMap.put(104, "线程");
		smallContentTypeMap.put(105, "Receivers");
		smallContentTypeMap.put(106, "Content providers");
		smallContentTypeMap.put(107, "Android进阶");
		smallContentTypeMap.put(108, "NFC&Serial Port");
		smallContentTypeMap.put(109, "Sqlite");
		smallContentTypeMap.put(110, "适配器");
		smallContentTypeMap.put(111, "布局和动画");
		smallContentTypeMap.put(112, "Android的位置管理器和传感器");
		smallContentTypeMap.put(113, "Adb和Ddms");
		smallContentTypeMap.put(114, "Http和WebService");
		smallContentTypeMap.put(115, "Widgets");
		smallContentTypeMap.put(116, "Fragment碎片");
		smallContentTypeMap.put(117, "安全和权限");
		smallContentTypeMap.put(118, "电话管理");
		smallContentTypeMap.put(119, "UI");
		smallContentTypeMap.put(120, "其他");

		// smallContentTypeMap.put(201, "选择题");
		// smallContentTypeMap.put(202, "填空题");
		// smallContentTypeMap.put(203, "简答题");
		// smallContentTypeMap.put(204, "选择题");
		// smallContentTypeMap.put(205, "填空题");
		// smallContentTypeMap.put(206, "简答题");

	}

}
