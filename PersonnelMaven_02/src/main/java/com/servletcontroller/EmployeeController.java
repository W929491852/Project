package com.servletcontroller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.domain.Dept;
import com.domain.Employee;
import com.domain.Job;
import com.domain.User;
import com.service.DeptService;
import com.service.EmployeeService;
import com.service.JobService;
import com.utils.PageUtils;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private JobService jobService;
	@Autowired
	private DeptService deptService;

	@RequestMapping("/jsp/employee/addEmployee")
	public void addEmployee(Employee employee, String flag, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if ("1".equals(flag)) {
			List<Job> selectAllJob = jobService.selectAllJob("", "");
			List<Dept> selectAllDept = deptService.selectAllDept("", "");
			request.setAttribute("jobs", selectAllJob);
			request.setAttribute("depts", selectAllDept);
			request.getRequestDispatcher("showAddEmployee.jsp").forward(request, response);
		} else if ("2".equals(flag)) {
			User user = (User) request.getSession().getAttribute("user_session");
			employee.setCreateDate(new Date());
			System.out.println("员工---------------------:"+employee.getCreateDate());
			employee.setUser(user);
			boolean saveEmployee = employeeService.saveEmployee(employee);
			if (saveEmployee) {
				response.sendRedirect("selectEmployee");
			}
		}
	}

	@RequestMapping("/jsp/employee/removeEmployee")
	public void deleteEmployee(String ids, HttpServletResponse response) throws IOException {
		boolean deleteEmployee = employeeService.deleteEmployee(ids);
		if (deleteEmployee) {
			response.sendRedirect("selectEmployee");
		}
	}

	@RequestMapping("/jsp/employee/selectEmployee")
	public String selectEmployee(Employee employee, String pageIndex, Model model) {
		if (pageIndex == null) {
			pageIndex = "1";
		}
		System.out.println(employee.getJob());
		if(employee.getJob()==null) {
			employee.setJob(new Job());
		}
		if(employee.getDept()==null) {
			employee.setDept(new Dept());
		}
		List<Employee> selectAllEmployee = employeeService.selectAllEmployee(employee.getJob().getId() + "",
				employee.getName(), employee.getCardId(), employee.getSex() + "", employee.getPhone(),
				employee.getDept().getId() + "", pageIndex);
		List<Job> selectAllJob = jobService.selectAllJob("", "");
		List<Dept> selectAllDept = deptService.selectAllDept("", "");
		int size = employeeService.selectAllEmployee(employee.getJob().getId() + "", employee.getName(),
				employee.getCardId(), employee.getSex() + "", employee.getPhone(), employee.getDept().getId() + "", "")
				.size();
		model.addAttribute("pageModel", PageUtils.getPage(Integer.parseInt(pageIndex), size));
		model.addAttribute("employees", selectAllEmployee);
		model.addAttribute("jobs", selectAllJob);
		model.addAttribute("depts", selectAllDept);
		return "/jsp/employee/employee.jsp";
	}

	@RequestMapping("/jsp/employee/updateEmployee")
	public void updateEmployee(Employee employee, String flag, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		User user = (User) request.getSession().getAttribute("user_session");
		if ("1".equals(flag)) {
			List<Job> selectAllJob = jobService.selectAllJob("", "");
			List<Dept> selectAllDept = deptService.selectAllDept("", "");
			Employee selectSingleEmployee = employeeService.selectSingleEmployee(employee.getId() + "");
			request.setAttribute("jobs", selectAllJob);
			request.setAttribute("depts", selectAllDept);
			request.setAttribute("employee", selectSingleEmployee);
			request.getRequestDispatcher("showUpdateEmployee.jsp").forward(request, response);
		} else if ("2".equals(flag)) {
			employee.setUser(user);
			boolean updateEmployee = employeeService.updateEmployee(employee);
			if (updateEmployee) {
				response.sendRedirect("selectEmployee");
			}

		}
	}
}
