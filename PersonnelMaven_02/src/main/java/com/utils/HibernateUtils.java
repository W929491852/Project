package com.utils;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.domain.User;
import com.sun.org.apache.regexp.internal.recompile;

public class HibernateUtils {

	private static <T> void setParameter(NativeQuery<T> query, Object... obj) {
		// TODO Auto-generated method stub
		if (obj != null) {
			for (int i = 0; i < obj.length; i++) {
				query.setParameter(i + 1, obj[i]);
			}
		}
	}

	public static <T> List<T> selectAll(Session session, String sql, Class<T> clz, Object... obj) {
		NativeQuery<T> query = session.createNativeQuery(sql, clz);
		setParameter(query, obj);
		System.out.println("-----------------------");
		List<T> resultList = query.getResultList();
		System.out.println(resultList);
		return resultList;

	}

	public static boolean update(Session session, String sql, Object... obj) {
		NativeQuery query = session.createNativeQuery(sql);
		setParameter(query, obj);
		int executeUpdate = query.executeUpdate();
		if (executeUpdate > 0) {
			return true;
		} else {
			return false;
		}
	}

}
