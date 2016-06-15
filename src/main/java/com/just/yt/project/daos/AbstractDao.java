package com.just.yt.project.daos;

import cn.org.rapid_framework.page.Page;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.List;

@Repository
public class AbstractDao {

	@Resource
    SessionFactory sessionFactory;

	/**
	 * 保存对象
	 * @param obj
	 * @return
	 */
	public Serializable save(final Object obj)  {
		return getSession().save(obj);
	}

    /**
     * 删除对象
     * @param obj
     */
    public void delete(final Object obj)  {
        getSession().delete(obj);
    }

    /**
	 * 修改对象
	 * @param obj
	 */
	public void update(final Object obj)  {
		getSession().update(obj);
	}

    /**
     * 查找对象
     * @param tableName
     * @param where
     * @return
     */
    Long getCount(final String tableName, String where){
        where = (where != null && where.length() != 0) ? " WHERE "+where : "";
        String sql = MessageFormat.format("SELECT COUNT(*) FROM {0} {1}", tableName, where);
        return  ((BigInteger) getSession().createSQLQuery(sql).uniqueResult()).longValue();
    }

    /**
     * 查找对象
     * @param tableName
     * @param where
     * @return
     */
    Object getObject(final String tableName, String where) {
        where = (where != null && where.length() != 0) ? " WHERE "+where : "";
        String hql = MessageFormat.format("FROM {0} {1}", tableName, where);
        return getSession().createQuery(hql).uniqueResult();
    }

    /**
     * 查找所有对象
     * @param tableName
     * @param where
     * @return
     */
    List<?> list(String tableName, String where){
        where = (where != null && where.length() != 0) ? " WHERE "+where : "";
        String hql = MessageFormat.format("FROM {0} {1}", tableName, where);
        Query query = getSession().createQuery(hql);
        return query.list();
    }

	/**
	 * 分页查找
	 * @param tableName
	 * @param where
     * @param page
	 * @return
	 */
    List<?> listByPage(String tableName, String where, final Page<Object> page) {
        where = (where != null && where.length() != 0) ? " WHERE "+where : "";
        String hql = MessageFormat.format("FROM {0} {1}", tableName, where);
        Query query = getSession().createQuery(hql);
        query.setMaxResults(page.getPageSize());
        query.setFirstResult(page.getFirstResult());
        return query.list();
    }


    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    private Session openSession(){
        return sessionFactory.openSession();
    }
}


