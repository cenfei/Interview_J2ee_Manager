
package com.ddm.interview.IapUtil;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * db query,save,update delete utils support
 * 
 * @author kangminggang
 * 
 * @param <T>
 */
public abstract class BaseDaoSupport<T> extends HibernateDaoSupport {

	//Logger logger = LoggerFactory.getLogger(BaseDaoSupport.class);

	@SuppressWarnings("unchecked")
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());

	// entity class name
	protected String entityClassName = getEntityName(this.entityClass);

	public void setSuperSessionFactory(SessionFactory sessionFactory) {

		
		
		super.setSessionFactory(sessionFactory);
	}

	// example query
	@SuppressWarnings("unchecked")
	public List<T> findByEntity(Object entiey) {

		return super.getHibernateTemplate().findByExample(entiey);
	}

	// find by property
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {

		String queryString = "from " + entityClassName + " o where o." + propertyName + "= ?";
		return super.getHibernateTemplate().find(queryString, value);
	}

	// find by hql
	@SuppressWarnings({ "rawtypes" })
	public List findByHql(String queryString, Object... values) {

		if ( values == null || values.length == 0 )
		{

			return super.getHibernateTemplate().find(queryString);
		} else
		{
			return super.getHibernateTemplate().find(queryString, values);
		}

	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {

		String queryString = "from " + entityClassName + " o ";
		return super.getHibernateTemplate().find(queryString);
	}

	@SuppressWarnings({ "rawtypes" })
	public List findByNamedParam(String queryString, String paramName, Object value) {

		return findByNamedParam(queryString, new String[] { paramName }, new Object[] { value });
	}

	@SuppressWarnings({ "rawtypes" })
	public List findByNamedParam(String queryString, String[] paramName, Object[] value) {

		return super.getHibernateTemplate().findByNamedParam(queryString, paramName, value);
	}

	@SuppressWarnings({ "rawtypes" })
	public List findByNamedParam(String queryString, Map<String, Object> params) {

		String[] paramKeys = new String[params.size()];
		Object[] paramValues = new Object[params.size()];
		int i = 0;
		for ( Entry<String, Object> entry : params.entrySet() )
		{
			paramKeys[i] = entry.getKey();
			paramValues[i] = entry.getValue();
			i++;
		}

		return super.getHibernateTemplate().findByNamedParam(queryString, paramKeys, paramValues);
	}

	// delete by ids
	public void delete(Serializable... entityids) {

		for ( Object id : entityids )
		{

			super.getHibernateTemplate().delete(find((Serializable) id));
		}
	}

	// query by id
	public T find(Serializable entityId) {

		if ( null != entityId )
			return (T) super.getHibernateTemplate().get(entityClass, entityId);
		return null;
	}

	public Session openSession() {

		return getHibernateTemplate().getSessionFactory().getCurrentSession();
	}

	public Query createSql(String sql) {

		Session mySession = this.getHibernateTemplate().getSessionFactory().openSession();
		Query len = mySession.createSQLQuery(sql);

		return len;
	}

	/**
	 * get scroll data
	 * 
	 * @param firstindex
	 * @param maxresult
	 * @param wherejpql
	 * @param queryParams
	 * @param orderby
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PagerModel<T> getBaseScrollData(final Pager pager, final String wherejpql, final Map<String, Object> params,
					final LinkedHashMap<String, String> orderby) {

		final PagerModel<T> queryResult = new PagerModel<T>();

		try
		{

			super.getHibernateTemplate().execute(new HibernateCallback() {

				public T doInHibernate(Session session) throws HibernateException, SQLException {

					String hql = "from " + entityClassName + " o" + ( wherejpql == null || "".equals(wherejpql.trim()) ? "" : " where " + wherejpql );

					// count
					String countHql = getQuery(hql);
					Query coutQuery = session.createQuery(countHql);
					setQueryParams(coutQuery, params);// where
					try
					{
						queryResult.setTotal(( (Long) coutQuery.list().get(0) ).intValue());// first get size
					}
					catch ( Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					hql += buildOrderby(orderby);
					Query resultQuey = session.createQuery(hql);
					setQueryParams(resultQuey, params);// where
					if ( pager.getFirstindex() != -1 && pager.getMaxresult() != -1 )
						resultQuey.setFirstResult(pager.getFirstindex()).setMaxResults(pager.getMaxresult());// last page

					queryResult.setDatas(resultQuey.list());

					return null;
				}

			});
		}
		catch ( DataAccessException e )
		{
			System.err.println(e);
			// e.printStackTrace();
		}

		return queryResult;

	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	private PagerModel<T> getBaseScrollData(final Pager pager, final Map<String, Object> where, final LinkedHashMap<String, String> orderby) {

		final PagerModel<T> queryResult = new PagerModel<T>();

		try
		{

			super.getHibernateTemplate().execute(new HibernateCallback() {

				public T doInHibernate(Session session) throws HibernateException, SQLException {

					StringBuffer sb = new StringBuffer("from " + entityClassName + " o where 1=1");
					Map<String, Object> params = new LinkedHashMap<String, Object>();
					if ( where != null && !where.isEmpty() )
					{
						for ( Entry<String, Object> entry : where.entrySet() )
						{
							sb.append(" and o." + entry.getKey() + " =:" + entry.getKey());
							params.put(entry.getKey(), entry.getValue());
						}
					}
					// count
					String countHql = getQuery(sb.toString());
					Query coutQuery = session.createQuery(countHql);
					setQueryParams(coutQuery, params);// where
					try
					{
						queryResult.setTotal(( (Long) coutQuery.list().get(0) ).intValue());// first get size
					}
					catch ( Exception e )
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					sb.append(buildOrderby(orderby));
					Query resultQuey = session.createQuery(sb.toString());
					setQueryParams(resultQuey, params);// where
					if ( pager.getFirstindex() != -1 && pager.getMaxresult() != -1 )
						resultQuey.setFirstResult(pager.getFirstindex()).setMaxResults(pager.getMaxresult());// last page

					queryResult.setDatas(resultQuey.list());

					return null;
				}

			});
		}
		catch ( DataAccessException e )
		{
			System.err.println(e);
			// e.printStackTrace();
		}

		return queryResult;

	}

	public PagerModel<T> getScrollDatas(final Pager pager, final Map<String, Object> where, final LinkedHashMap<String, String> orderby) {

		Pager temp = pager == null ? new Pager() : pager;
		return getBaseScrollData(temp, where, orderby);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public PagerModel<T> getScrollDatas(final Pager pager, final Map<String, Object> where) {

		Pager temp = pager == null ? new Pager() : pager;
		return getBaseScrollData(pager, where, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public PagerModel<T> getScrollDatas(final Pager pager, LinkedHashMap<String, String> orderby) {

		Pager temp = pager == null ? new Pager() : pager;
		return getBaseScrollData(pager, null, orderby);
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
	public PagerModel<T> getScrollDatas(final Pager pager) {

		Pager temp = pager == null ? new Pager() : pager;
		return getBaseScrollData(pager, null, null);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private PagerModel getBaseScrollData(final String hql, final Pager pager, final Map<String, Object> queryParams) {

		final PagerModel queryResult = new PagerModel();

		super.getHibernateTemplate().execute(new HibernateCallback() {

			public T doInHibernate(Session session) throws HibernateException, SQLException {

				// count
				String countHql = getQuery(hql);
				Query coutQuery = session.createQuery(countHql);
				setQueryParams(coutQuery, queryParams);// where
				queryResult.setTotal(( (Long) coutQuery.list().get(0) ).intValue());// first get size
				Query resultQuey = session.createQuery(hql);
				setQueryParams(resultQuey, queryParams);// where
				if ( pager.getFirstindex() != -1 && pager.getMaxresult() != -1 )
					resultQuey.setFirstResult(pager.getFirstindex()).setMaxResults(pager.getMaxresult());// last page

				queryResult.setDatas(resultQuey.list());
				return null;
			}

		});

		return queryResult;

	}

	/**
	 * get scroll data
	 * 
	 * @param firstindex
	 * @param maxresult
	 * @param wherejpql
	 * @param queryParams
	 * @param orderby
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagerModel<T> getScrollData(Pager pager, String wherejpql, Map<String, Object> queryParams, LinkedHashMap<String, String> orderby) {

		Pager temp = pager == null ? new Pager() : pager;
		return this.getBaseScrollData(temp, wherejpql, queryParams, orderby);

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagerModel getScrollData(String hql, Pager pager, Map<String, Object> queryParams) {

		Pager temp = pager == null ? new Pager() : pager;
		return this.getBaseScrollData(hql, temp, queryParams);

	}

	public PagerModel<T> getScrollData(Pager pager, String wherejpql, Map<String, Object> queryParams) {

		Pager temp = pager == null ? new Pager() : pager;
		return getScrollData(temp, wherejpql, queryParams, null);
	}

	public PagerModel<T> getScrollData(Pager pager, LinkedHashMap<String, String> orderby) {

		Pager temp = pager == null ? new Pager() : pager;
		return getScrollData(temp, null, null, orderby);

	}

	public PagerModel<T> getScrollData(Pager pager) {

		Pager temp = pager == null ? new Pager() : pager;
		return getScrollData(temp, null, null, null);
	}

	public PagerModel<T> getScrollData() {

		Pager pager = new Pager();
		pager.setOffset("-1");
		pager.setPageSize("-1");
		return getScrollData(pager, null, null, null);

	}

	public PagerModel getScrollData(String hql, Pager pager) {

		Pager temp = pager == null ? new Pager() : pager;
		return getScrollData(hql, temp, null);

	}

	public PagerModel getScrollData(String hql)

	{

		Pager pager = new Pager();
		pager.setOffset("-1");
		pager.setPageSize("-1");
		return getScrollData(hql, pager);
	}

	/**
	 * 获取实体的名称
	 * 
	 * @param <E>
	 * @param clazz 实体类
	 * @return
	 */
	protected static <E> String getEntityName(Class<E> clazz) {

		String entityname = clazz.getSimpleName();
		return entityname;
	}

	/**
	 * 设置HQL里边的属性值
	 * 
	 * @param query
	 * @param queryParams
	 */
	protected static void setQueryParams(Query query, Map<String, Object> queryParams) {

		if ( queryParams != null && queryParams.size() > 0 )
		{
			for ( Entry<String, Object> entry : queryParams.entrySet() )
			{
				query.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * 组装order by语句
	 * 
	 * @param orderby
	 * @return
	 */
	protected static String buildOrderby(LinkedHashMap<String, String> orderby) {

		StringBuffer orderbyql = new StringBuffer("");
		if ( orderby != null && orderby.size() > 0 )
		{
			orderbyql.append(" order by ");
			for ( String key : orderby.keySet() )
			{
				orderbyql.append(" o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		return orderbyql.toString();
	}

	protected static String getQuery(String hql) {

		hql = hql.replace("FROM", "from");
		return hql.indexOf("from") == -1 ? hql : "select count(*) " + hql.substring(hql.indexOf("from"));
	}

}
