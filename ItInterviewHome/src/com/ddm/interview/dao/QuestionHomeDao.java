package com.ddm.interview.dao;

import java.util.List;

import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.QuestionHome;

public interface QuestionHomeDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xxyd.iap_service_monitor.dao.QuestionHomeDao#save(com.xxyd.
	 * iap_service_monitor.pojo.QuestionHome)
	 */
	public abstract void save(QuestionHome news);
	public abstract  void  update(QuestionHome news);
	public abstract  void  delete(QuestionHome news);
	public PagerModel<QuestionHome> getQuestionHomeBySelectSql(String sql,Pager pager) ;
	
	public abstract QuestionHome findById(Long id);

}