package com.service;

import java.util.Date;
import java.util.List;

import com.domain.Notice;
import com.domain.User;

public interface NoticeService {

	// 查询所有通知
	List<Notice> selectAllNotice(String title,String content,String pageIndex);

	// 添加通知
	boolean saveNotice(String title, String content,User user);

	// 修改通知信息
	boolean updateNotice(int id, String title, String content,Date createDate);

	// 删除通知
	boolean deleteNotice(String ids);

	// 根据id查询通知
	Notice selectSingleNotice(int id);
}
