package com.servletcontroller;

import java.io.IOException;
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

import com.domain.Job;
import com.service.JobService;
import com.utils.PageUtils;

@Controller
public class JobController {

	@Autowired
	private JobService jobService;
	@RequestMapping("/jsp/job/addJob")
	public void addJob(String flag,Job job,HttpServletResponse response) throws IOException {
		if("1".equals(flag)) {
			response.sendRedirect("showAddJob.jsp");			
		}else if("2".equals(flag)) {
			boolean saveJob = jobService.saveJob(job.getName(), job.getRemark());
			if(saveJob) {
				response.sendRedirect("selectJob");
			}
		}
	}
	@RequestMapping("/jsp/job/removeJob")
	public void deleteJob(String ids,HttpServletResponse response) throws IOException {
		boolean deleteJob = jobService.deleteJob(ids);
		if(deleteJob) {
			response.sendRedirect("selectJob");
		}
	}
	@RequestMapping("/jsp/job/selectJob")
	public String selectJob(Model model,String name,String pageIndex) {
		if(pageIndex==null) {
			pageIndex="1";
		}
		List<Job> selectAllJob = jobService.selectAllJob(name,pageIndex);
		int size=jobService.selectAllJob(name,"").size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("jobs", selectAllJob);
		return "/jsp/job/job.jsp";
	}
	@RequestMapping("/jsp/job/updateJob")
	public void UpdateJob(HttpServletRequest request,HttpServletResponse response,String flag,Job job) throws ServletException, IOException {
		if("1".equals(flag)) {
			Job selectSingleJob = jobService.selectSingleJob(job.getId());
			request.setAttribute("job", selectSingleJob);
			request.getRequestDispatcher("showUpdateJob.jsp").forward(request, response);
		}else if("2".equals(flag)) {
			jobService.updateJob(job.getId(), job.getName(), job.getRemark());
			response.sendRedirect("selectJob");
		}
	}
	
}
