package com.qf.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.qf.annotation.JdbcField;

/**
 * 作者：老邢 时间：2017年5月26日 版本：v1.0 说明：数据库工具类
 */
public class DbHelp {

	private static DataSource ds = new ComboPooledDataSource();

	// 增删改
	public static boolean update(String sql, Object... values) {
		boolean res = false;
		QueryRunner qr = new QueryRunner(ds);
		try {
			qr.update(sql, values);
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	// 开启事物增删改
	public static boolean updateTranaction(Map<Object[],String> map) {
		boolean res = false;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			conn.setAutoCommit(false);
			QueryRunner qr = new QueryRunner();
			for (Object[] vs : map.keySet()) {
				
				qr.update(conn, map.get(vs), vs);
			}
			conn.commit();
			res = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return res;
	}

	// 查询单个
	public static <T> T querySingle(String sql, Class<T> cls, Object... values) {
		QueryRunner qr = new QueryRunner(ds);
		try {
			return qr.query(sql, new BeanHandler<T>(cls), values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	// 查询全部
	public static <T> List<T> queryAll(String sql, Class<T> cls, Object... values) {
		QueryRunner qr = new QueryRunner(ds);
		try {
			return qr.query(sql, new BeanListHandler<T>(cls), values);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	// 查询全部---结果类型万能
	public static <T> T queryAll(String sql, ResultSetHandler<T> rsh, Object... values) {
			QueryRunner qr = new QueryRunner(ds);
			try {
				return qr.query(sql, rsh, values);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	
	
	public static List<String> queryAll(String sql,Object... vs){
		QueryRunner qr = new QueryRunner(ds);
		try {
			return qr.query(sql,new ResultSetHandler<List<String>>(){

				@Override
				public List<String> handle(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					List<String> list=new ArrayList<>();
					while(rs.next()) {
						list.add(rs.getString(1));
					}
					return list;
				}} , vs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	//查询数量
	public static int queryCount(String sql) {
		QueryRunner qr = new QueryRunner(ds);
		try {
			return qr.query(sql,new ResultSetHandler<Integer>(){

				@Override
				public Integer handle(ResultSet rs) throws SQLException {
					// TODO Auto-generated method stub
					if(rs.next()){
						return rs.getInt(1);
					}
					return 0;
				}
				
			});
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	//自定义工具类
	public static <T> List<T> selectAll(String sql,Class<T> cls,Object... vs){
		List<T> list;
		try {
			Connection conn=ds.getConnection();
			ResultSet rs;
			if(vs.length>0){
				PreparedStatement ps=conn.prepareStatement(sql);
				for(int i=0;i<vs.length;i++){
					ps.setObject(i+1, vs[i]);
				}
				rs=ps.executeQuery();
			}else{
				Statement st=conn.createStatement();
				rs=st.executeQuery(sql);
			}
			list = new ArrayList<>();
			while(rs.next()){
				T obj=cls.newInstance();
				Field[] fs=cls.getDeclaredFields();
				for(Field f:fs){
					f.setAccessible(false);
					try {
						JdbcField jf=f.getAnnotation(JdbcField.class);
						if(jf!=null){
							f.set(obj, rs.getObject(jf.value()));

						}else{
							
							f.set(obj, rs.getObject(f.getName()));
						}
					} catch (SQLException e) {
						
					}
				}
				
				
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	

}
