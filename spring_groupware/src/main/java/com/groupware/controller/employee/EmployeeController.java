package com.groupware.controller.employee;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;
import com.groupware.request.SearchCriteria;
import com.groupware.service.employee.DepartmentService;
import com.groupware.service.employee.EmployeeService;
import com.groupware.service.employee.PositionService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService deptService;

	@Autowired
	private PositionService positionService;

	@Resource(name = "employeeAttachPath")
	private String employeeAttachPath;

	@Resource(name = "picture")
	private String pircurePath;

	@RequestMapping("list") // @GetMapping("list") : spring 4.3
	public ModelAndView list(SearchCriteria cri, ModelAndView mnv) throws Exception {
		String url = "employee/employee_list";

		mnv.addAllObjects(employeeService.getEmployeeList(cri));
		mnv.setViewName(url);

		return mnv;
	}

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String registGet(Model model) throws Exception {
		String url = "employee/regist";

		model.addAttribute("positionList", positionService.getPosotionList());
		model.addAttribute("deptList", deptService.getDeptList());

		return url;
	}

	@RequestMapping("/detail")
	public String detail(String id, Model model) throws Exception {
		String url = "employee/detail";

		Map<String, Object> dataMap = employeeService.getEmployee(id);

		EmployeeVO employee = (EmployeeVO) dataMap.get("employee");
		EmployeeVO register = (EmployeeVO) employeeService.getEmployee(employee.getRegister()).get("employee");

		dataMap.put("register", register);
		model.addAllAttributes(dataMap);

		return url;
	}

	@RequestMapping(value="/regist", method=RequestMethod.POST, consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String registPost(@ModelAttribute EmployeeVO employee, @ModelAttribute List<CareerVO> careers) throws Exception {
		String url = "employee/regist_success";
		
		employeeService.regist(employee, careers);
		System.out.println(employee);
		return url;
	}
	
//	public ModelAndView idCheck(String id) throws Exception {
//		String url = "";
//		
//	}
}
