package com.ddm.interview.IapUtil;

import java.util.ArrayList;
import java.util.List;
/**
 * 功能：作为分页的工具类  存放分页信息list和总共公的记录条数
 * @author fox
 *
 * @param <T>
 */
public class PagerModel<T> {

	private int total;

	private List<T> datas;

	public List<T> getDatas() {

		if (datas == null) {
			datas = new ArrayList<T>();
		}
		return datas;
	}

	public void setDatas(List<T> datas) {

		this.datas = datas;
	}

	public int getTotal() {

		return total;
	}

	public void setTotal(int total) {

		this.total = total;
	}
}
