package com.dao;

import java.util.List;

import com.domain.Notice;

public interface NoticeDao {
	// 查询所有公告
	List<Notice> selectAllNotice(String sql);

	// 添加公告
	boolean saveNotice(Notice notice);

	// 修改公告
	boolean updateNotice(Notice notice);

	// 删除公告
	boolean deleteNotice(Notice notice);

	// 根据id查询公告信息
	Notice selectSngleNotice(int id);
}
