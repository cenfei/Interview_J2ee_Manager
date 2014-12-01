package com.ddm.interview.service;

import org.apache.log4j.Logger;

import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.dao.QuestionHomeDao;
import com.ddm.interview.pojo.QuestionHome;

/**
 * 
 * 
 * @类名：QuestionHomeServiceImpl.java
 * 
 * @功能说明：面试题表
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
public class QuestionHomeServiceImpl implements QuestionHomeService {
	private Logger log = Logger.getLogger(QuestionHomeServiceImpl.class);

	private QuestionHomeDao questionHomeDao;

	public void save(QuestionHome news) {
		questionHomeDao.save(news);
	}

	public void update(QuestionHome news) {
		questionHomeDao.update(news);
	}

	public void delete(QuestionHome news) {
		questionHomeDao.delete(news);
	}

	public PagerModel<QuestionHome> getQuestionHomeBySelectSql(String sql,
			Pager pager) {
		return questionHomeDao.getQuestionHomeBySelectSql(sql, pager);
	}

	public QuestionHome findById(Long id) {

		return questionHomeDao.findById(id);
	}

	/**
	 * @return the questionHomeDao
	 */
	public QuestionHomeDao getQuestionHomeDao() {
		return questionHomeDao;
	}

	/**
	 * @param questionHomeDao
	 *            the questionHomeDao to set
	 */
	public void setQuestionHomeDao(QuestionHomeDao questionHomeDao) {
		this.questionHomeDao = questionHomeDao;
	}

}
