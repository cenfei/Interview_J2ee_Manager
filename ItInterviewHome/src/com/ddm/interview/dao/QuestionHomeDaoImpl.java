package com.ddm.interview.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.ddm.interview.IapUtil.BaseDaoSupport;
import com.ddm.interview.IapUtil.Pager;
import com.ddm.interview.IapUtil.PagerModel;
import com.ddm.interview.pojo.QuestionHome;

public class QuestionHomeDaoImpl extends BaseDaoSupport<QuestionHome> implements
		QuestionHomeDao {

	private Logger log = Logger.getLogger(QuestionHomeDaoImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.xxyd.iap_service_monitor.dao.QuestionHomeDao#save(com.xxyd.
	 * iap_service_monitor.pojo.QuestionHome)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ddm.alumin.dao.QuestionHomeDao#save(com.ddm.alumin.pojo.QuestionHome)
	 */
	public void save(QuestionHome news) {

		try {
			log.debug("save start");
			this.getHibernateTemplate().save(news);
			log.info("save success");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}

	}

	public PagerModel<QuestionHome> getQuestionHomeBySelectSql(String sql, Pager pager) {

		PagerModel<QuestionHome> pModel = new PagerModel<QuestionHome>();

		try {
			final Integer pageSize = pager.getMaxresult();
			final Integer currentPage = pager.getFirstindex();

			final String hql = " from QuestionHome u order by u.showTimeDate asc ";

			List<QuestionHome> list = getHibernateTemplate().executeFind(
					new HibernateCallback() {
						public Object doInHibernate(Session session)
								throws HibernateException, SQLException {
							List<QuestionHome> result = session.createQuery(hql)
									.setFirstResult(currentPage)
									.setMaxResults(pageSize).list();
							return result;
						}
					});

			pModel.setDatas(list);

			String hql2 = "select  count(u.id) from QuestionHome u";
			List list2 = getHibernateTemplate().find(hql2);
			Long countLong = null;
			countLong = (Long) list2.get(0);
			pModel.setTotal(countLong.intValue());
		} catch (RuntimeException re) {
			log.error("getting failed findIdListByMgrid", re);
			throw re;
		}
		return pModel;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ddm.alumin.dao.QuestionHomeDao#findById(java.lang.Long)
	 */
	public QuestionHome findById(Long id) {

		return this.find(id);
	}

	public void update(QuestionHome news) {

		try {
			log.debug("update start");
			this.getHibernateTemplate().update(news);
			log.info("update success");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}

	}

	public void delete(QuestionHome news) {

		try {
			log.debug("delete start");
			this.getHibernateTemplate().delete(news);
			log.info("delete success");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}

	}
}
