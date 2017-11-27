package com.service.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.JobDao;
import com.domain.Dept;
import com.domain.Job;
import com.service.JobService;
import com.utils.StringCheckEmpty;

@Service
@Transactional
public class JobServiceImple implements JobService{

	@Autowired
	private JobDao jobDao;
	
	@Override
	public List<Job> selectAllJob(String name,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_job where 1=1";
		if(StringCheckEmpty.checked(name)) {
			sql+=" and name like '%"+name+"%'";
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return jobDao.selectAllJob(sql);
	}

	@Override
	public boolean saveJob(String name, String remark) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(name,remark)) {
			Job job=new Job();
			job.setName(name);
			job.setRemark(remark);
			jobDao.saveJob(job);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateJob(int id, String name, String remark) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(name,remark)) {
			return jobDao.updateJob(new Job(id, name, remark));			
		}
		return false;
	}

	@Override
	public boolean deleteJob(String ids) {
		// TODO Auto-generated method stub
		String[] id=ids.split(",");
		for(int i=0;i<id.length;i++) {
			jobDao.deleteJob(new Job(Integer.parseInt(id[i])));
		}
		return true;
	}

	@Override
	public Job selectSingleJob(int id) {
		// TODO Auto-generated method stub
		return jobDao.selectSngleJob(id);
	}

}
