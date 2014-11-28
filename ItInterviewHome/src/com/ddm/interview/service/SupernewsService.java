package com.ddm.interview.service;

import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.Supernews;

public interface SupernewsService {

	/**
	 * 
	 * 
	 * @功能说明：注册账号信息
	 * 
	 * @返回类型：void
	 */
	public abstract void save(Supernews news);
	public abstract  void  update(Supernews news);
	public abstract  void  delete(Supernews news);
	public PagerModel<Supernews> getSupernewsBySelectSql(String sql,Pager pager) ;
	
	public abstract Supernews findById(Long id);
}