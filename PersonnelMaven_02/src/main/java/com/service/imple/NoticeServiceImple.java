package com.service.imple;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NoticeDao;
import com.domain.Notice;
import com.domain.User;
import com.service.NoticeService;
import com.utils.StringCheckEmpty;

/**
 * Servlet implementation class NoticeServiceImple
 */
@Service
@Transactional
public class NoticeServiceImple implements NoticeService{

	@Autowired
	private NoticeDao noticeDao;

	@Override
	public List<Notice> selectAllNotice(String title,String content,String pageIndex) {
		// TODO Auto-generated method stub
		String sql="select * from tb_notice where 1=1";
		if(StringCheckEmpty.checked(title)) {
			sql+=" and title like '%"+title+"%'";
		}
		if(StringCheckEmpty.checked(content)) {
			sql+=" and content like '%"+content+"%'";
		}
		if(StringCheckEmpty.checked(pageIndex)) {
			sql+=" limit "+(Integer.parseInt(pageIndex)-1)*3+",3";
		}
		return noticeDao.selectAllNotice(sql);
	}

	@Override
	public boolean saveNotice(String title, String content,User user) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(title,content)) {
			Notice notice=new Notice(title, content,new Date(new java.util.Date().getTime()));
			notice.setUser(user);
			noticeDao.saveNotice(notice);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateNotice(int id, String title, String content, Date createDate) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(title,content)) {
			Notice notice=new Notice(id, title, content, createDate);
			noticeDao.updateNotice(notice);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteNotice(String ids) {
		// TODO Auto-generated method stub
		if(StringCheckEmpty.checked(ids)) {
			String[] id=ids.split(",");
			for(int i=0;i<id.length;i++) {
				noticeDao.deleteNotice(new Notice(Integer.parseInt(id[i])));
			}
			return true;
		}
		return false;
	}

	@Override
	public Notice selectSingleNotice(int id) {
		// TODO Auto-generated method stub
		return noticeDao.selectSngleNotice(id);
	}

	
}
