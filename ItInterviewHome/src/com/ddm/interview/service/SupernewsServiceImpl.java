package com.ddm.interview.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ddm.interview.IapUtil.MyStringUtils;
import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.dao.SupernewsDao;
import com.ddm.interview.pojo.Supernews;

/**
 * 
 * 
 * @类名：SupernewsServiceImpl.java
 * 
 * @功能说明：校友录账号信息业务层
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
public class SupernewsServiceImpl implements SupernewsService {
	private Logger log = Logger.getLogger(SupernewsServiceImpl.class);

	private SupernewsDao supernewsDao;

	public SupernewsDao getSupernewsDao() {
		return supernewsDao;
	}

	public void setSupernewsDao(SupernewsDao supernewsDao) {
		this.supernewsDao = supernewsDao;
	}

	public void save(Supernews news) {
		supernewsDao.save(news);
	}

	public void update(Supernews news) {
		supernewsDao.update(news);
	}

	public void delete(Supernews news) {
		supernewsDao.delete(news);
	}

	public PagerModel<Supernews> getSupernewsBySelectSql(String sql, Pager pager) {
		return supernewsDao.getSupernewsBySelectSql(sql, pager);
	}

	public Supernews findById(Long id) {

		return supernewsDao.findById(id);
	}

	
}
