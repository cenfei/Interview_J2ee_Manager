/*
 *	全国三级城市联动 js版
 *	author:		mrasong
 *	homepage:	http://asong.us/
 *	E-mail:		mrasong#163.com
 *	version:	1.0.2
 *	data:		tencent
 *
 * 维度端前端网整理 http://www.weiduduan.com/
 *
 **/
function Dsy() {
	this.Items = {};
}
Dsy.prototype.add = function(id, iArray) {
	this.Items[id] = iArray;
}
Dsy.prototype.Exists = function(id) {
	if (typeof (this.Items[id]) == "undefined")
		return false;
	return true;
}

function change(v) {
	var str = "0";
	for (i = 0; i < v; i++) {
		str += ("_" + (document.getElementById(typeArray[i]).selectedIndex - 1));
	}
	;
	var ss = document.getElementById(typeArray[v]);
	with (ss) {
		length = 0;
		options[0] = new Option(opt0[v], opt0[v]);
		if (v && document.getElementById(typeArray[v - 1]).selectedIndex > 0
				|| !v) {
			if (dsy.Exists(str)) {
				ar = dsy.Items[str];
				for (i = 0; i < ar.length; i++) {
					options[length] = new Option(ar[i], ar[i]);
				}// end for
				if (v) {
					options[0].selected = true;
				}
			}
		}// end if v
		if (++v < typeArray.length) {
			change(v);
		}
	}// End with
}

var dsy = new Dsy();

dsy.add("0", [ "Java", "Andoird", "Ios", "C", "C++", "PHP" ]);
dsy.add("0_0", [ "java章节基础题", "java经典编程题", "java流行框架题", "java性能优化题",
		"java名企面试题" ]);
dsy.add("0_0_0",
		[ "java基础题", "构造方法", "字符和数组", "集合", "继承", "异常", "接口和抽象类", "线程", "重写",
				"JSP", "Sevlet", "JDBC", "Util", "IO流", "Misc", "xml", "其他" ]);
dsy.add("0_0_1", [ "java经典编程题——二级" ]);
dsy.add("0_0_2", [ "java流行框架题——二级" ]);
dsy.add("0_0_3", [ "java性能优化题——二级" ]);
dsy.add("0_0_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

dsy.add("0_1", [ "Andoird章节基础题", "Andoird经典编程题", "Andoird流行框架题",
		"Andoird性能优化题", "Andoird名企面试题" ]);
dsy.add("0_1_0", [ "Android基础题", "Activity", "Service", "Receivers",
		"Content providers", "Android进阶", "NFC&Serial Port", "Sqlite", "适配器",
		"布局和动画", "Android的位置管理器和传感器", "Adb和Ddms", "Http和WebService", "Widgets",
		"Fragment碎片", "安全和权限", "电话管理", "UI", "其他" ]);
dsy.add("0_1_1", [ "Andoird经典编程题——二级" ]);
dsy.add("0_1_2", [ "Andoird流行框架题——二级" ]);
dsy.add("0_1_3", [ "Andoird性能优化题——二级" ]);
dsy.add("0_1_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

dsy.add("0_2", [ "Ios章节基础题", "Ios经典编程题", "Ios流行框架题", "Ios性能优化题", "Ios名企面试题" ]);
dsy.add("0_2_0", [ "Ios章节基础题——二级" ]);
dsy.add("0_2_1", [ "Ios经典编程题——二级" ]);
dsy.add("0_2_2", [ "Ios流行框架题——二级" ]);
dsy.add("0_2_3", [ "Ios性能优化题——二级" ]);
dsy.add("0_2_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

dsy.add("0_3", [ "C章节基础题", "C经典编程题", "C流行框架题", "C性能优化题", "C名企面试题" ]);
dsy.add("0_3_0", [ "C章节基础题——二级" ]);
dsy.add("0_3_1", [ "C经典编程题——二级" ]);
dsy.add("0_3_2", [ "C流行框架题——二级" ]);
dsy.add("0_3_3", [ "C性能优化题——二级" ]);
dsy.add("0_3_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

dsy.add("0_4", [ "C++章节基础题", "C++经典编程题", "C++流行框架题", "C++性能优化题", "C++名企面试题" ]);
dsy.add("0_4_0", [ "C++章节基础题——二级" ]);
dsy.add("0_4_1", [ "C++经典编程题——二级" ]);
dsy.add("0_4_2", [ "C++流行框架题——二级" ]);
dsy.add("0_4_3", [ "C++性能优化题——二级" ]);
dsy.add("0_4_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

dsy.add("0_5", [ "PHP章节基础题", "PHP经典编程题", "PHP流行框架题", "PHP性能优化题", "PHP名企面试题" ]);
dsy.add("0_5_0", [ "PHP章节基础题——二级" ]);
dsy.add("0_5_1", [ "PHP经典编程题——二级" ]);
dsy.add("0_5_2", [ "PHP流行框架题——二级" ]);
dsy.add("0_5_3", [ "PHP性能优化题——二级" ]);
dsy.add("0_5_4", [ "阿里巴巴", "百度", "腾讯", "唯品会", "一号店", "网易", "新浪", "大众点评" ]);

var typeArray = [ "s_language_type", "s_contentfirst_type",
		"s_contentsecond_type" ];// 三个select的name
var opt0 = [ "程序语言类别", "内容一级分类", "内容二级分类" ];// 初始值
function _init_area() { // 初始化函数

	for (i = 0; i < typeArray.length - 1; i++) {
		document.getElementById(typeArray[i]).onchange = new Function("change("
				+ (i + 1) + ")");
	}
	change(0);
} /* 维度端前端网整理 http://www.weiduduan.com */