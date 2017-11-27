package com.dao.imple;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dao.DocumentDao;
import com.domain.Document;
import com.utils.HibernateUtils;
import com.utils.StringCheckEmpty;

@Repository
public class DocumentDaoImple implements DocumentDao{

	@Autowired
	private MyHibernateDao myHibernateDao;
	@Override
	public boolean saveDocument(Document document) {
		// TODO Auto-generated method stub
		int save = (int) myHibernateDao.getHibernateTemplate().save(document);
		return save>0?true:false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Document> selectAllDocument(String sql) {
		// TODO Auto-generated method stub
			return (List<Document>) myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Object>() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException {
					// TODO Auto-generated method stub
					return HibernateUtils.selectAll(session, sql, Document.class);
				}
			});
	}

	@Override
	public boolean deleteDocument(Document document) {
		// TODO Auto-generated method stub
		myHibernateDao.getHibernateTemplate().delete(document);
		return true;
	}

	@Override
	public boolean updateDocument(Document document) {
		// TODO Auto-generated method stub
		return myHibernateDao.getHibernateTemplate().execute(new HibernateCallback<Boolean>() {

			@Override
			public Boolean doInHibernate(Session session) throws HibernateException {
				// TODO Auto-generated method stub
				return HibernateUtils.update(session, "update tb_document set title=?,remark=?,fileName=? where id=?", document.getTitle(),document.getRemark(),document.getFileName(),document.getId());
			}
		});
	}

	@Override
	public Document selectSingleDocument(int id) {
		// TODO Auto-generated method stub
		return (Document) myHibernateDao.getHibernateTemplate().find("from Document where id=?", id).get(0);
	}

}
