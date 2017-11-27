package com.servletcontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.domain.Email;
import com.domain.Notice;
import com.domain.User;
import com.service.NoticeService;
import com.utils.EmailUtils;
import com.utils.PageUtils;

@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@RequestMapping("/jsp/notice/addEmail")
	public void addEmail(String flag, HttpServletResponse response, Email email) throws IOException {
		if ("1".equals(flag)) {
			response.sendRedirect("showAddEmail.jsp");
		} else {
			EmailUtils.sendEmail(email);
		}
	}

	@RequestMapping("/jsp/notice/addNotice")
	public void addNotice(String flag, Notice notice, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		User user = (User) request.getSession().getAttribute("user_session");
		if ("1".equals(flag)) {
			response.sendRedirect("showAddNotice.jsp");
		} else if ("2".equals(flag)) {
			boolean saveNotice = noticeService.saveNotice(notice.getTitle(), notice.getContent(), user);
			if (saveNotice) {
				response.sendRedirect("selectNotice");
			}
		}
	}

	@RequestMapping("/jsp/notice/removeNotice")
	public void deleteNotice(String ids, HttpServletResponse response) throws IOException {
		boolean deleteNotice = noticeService.deleteNotice(ids);
		if (deleteNotice) {
			response.sendRedirect("selectNotice");
		}
	}

	@RequestMapping("/jsp/notice/previewNotice")
	public String previewNotice(int id, Model model) {
		Notice selectSingleNotice = noticeService.selectSingleNotice(id);
		model.addAttribute("notice", selectSingleNotice);
		return "/jsp/notice/previewNotice.jsp";
	}

	@RequestMapping("/jsp/notice/selectNotice")
	public String selectNotice(String pageIndex, Notice notice, Model model) {
		if (pageIndex == null) {
			pageIndex = "1";
		}
		List<Notice> selectAllNotice = noticeService.selectAllNotice(notice.getTitle(), notice.getContent(), pageIndex);
		int size = noticeService.selectAllNotice(notice.getTitle(), notice.getContent(), "").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("notices", selectAllNotice);
		return "/jsp/notice/notice.jsp";
	}

	@RequestMapping("/jsp/notice/updateNotice")
	public void upateNotice(String flag, Notice notice, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if ("1".equals(flag)) {
			Notice selectSingleNotice = noticeService.selectSingleNotice(notice.getId());
			request.setAttribute("notice", selectSingleNotice);
			request.getRequestDispatcher("showUpdateNotice.jsp").forward(request, response);
		} else if ("2".equals(flag)) {
			boolean updateNotice = noticeService.updateNotice(notice.getId(), notice.getTitle(), notice.getContent(),notice.getCreateDate());
			if (updateNotice) {
				response.sendRedirect("selectNotice");
			}

		}
	}
}
