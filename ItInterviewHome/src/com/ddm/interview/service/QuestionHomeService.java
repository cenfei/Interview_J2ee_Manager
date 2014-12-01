package com.ddm.interview.service;

import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.QuestionHome;

public interface QuestionHomeService {

	public abstract void save(QuestionHome news);

	public abstract void update(QuestionHome news);

	public abstract void delete(QuestionHome news);

	public PagerModel<QuestionHome> getQuestionHomeBySelectSql(String sql,
			Pager pager);

	public abstract QuestionHome findById(Long id);
}