package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.DeptDao;
import com.domain.Dept;
import com.service.DeptService;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class DeptServiceImple implements DeptService{

	@Autowired
	private DeptDao deptDao;
	@Override
	public List<Dept> selectAllDept(String name,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_dept where 1=1";
		if(StringCheckEmpty.checked(name)) {
			sql+=" and name like '%"+name+"%'";
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return deptDao.selectAllDept(sql);
	}
	@Override
	public boolean saveDept(String name, String remark) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(name,remark)) {
			Dept dept=new Dept();
			dept.setName(name);
			dept.setRemark(remark);
			deptDao.saveDept(dept);
			return true;
		}
		return false;
	}
	@Override
	public boolean updateDept(int id,String name, String remark) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(name,remark)) {
			return deptDao.updateDept(new Dept(id, name, remark));			
		}
		return false;
	}
	@Override
	public boolean deleteDept(String ids) {
		// TODO Auto-generated method stub
		String[] id=ids.split(",");
		for(int i=0;i<id.length;i++) {
			deptDao.deleteDept(new Dept(Integer.parseInt(id[i])));
		}
		return true;
	}
	@Override
	public Dept selectSingleDept(int id) {
		// TODO Auto-generated method stub
		return deptDao.selectSngleDept(id);
	}

}
