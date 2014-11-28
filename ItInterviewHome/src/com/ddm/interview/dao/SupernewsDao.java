package com.ddm.interview.dao;

import java.util.List;

import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.Supernews;

public interface SupernewsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xxyd.iap_service_monitor.dao.SupernewsDao#save(com.xxyd.
	 * iap_service_monitor.pojo.Supernews)
	 */
	public abstract void save(Supernews news);
	public abstract  void  update(Supernews news);
	public abstract  void  delete(Supernews news);
	public PagerModel<Supernews> getSupernewsBySelectSql(String sql,Pager pager) ;
	
	public abstract Supernews findById(Long id);

}