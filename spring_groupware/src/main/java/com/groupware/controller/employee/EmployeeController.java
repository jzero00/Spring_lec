package com.groupware.controller.employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.groupware.dto.CareerVO;
import com.groupware.dto.EmployeeVO;
import com.groupware.exception.IdNotFoundException;
import com.groupware.exception.InvalidPasswordException;
import com.groupware.request.RegistEmployeeCommand;
import com.groupware.request.SearchCriteria;
import com.groupware.service.employee.DepartmentService;
import com.groupware.service.employee.EmployeeService;
import com.groupware.service.employee.PositionService;
import com.groupware.utils.FileUpload;


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
	private String picturePath;

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

	@RequestMapping(value = "/regist", method = RequestMethod.POST/*, consumes = MediaType.MULTIPART_FORM_DATA_VALUE*/)
	public String registPost(RegistEmployeeCommand command, List<CareerVO> careers)
			throws Exception {
		String url = "employee/regist_success";

		System.out.println(command.getId());
		System.out.println(command.getAddress1());
		System.out.println(command.getAddress2());
		System.out.println(command.getEmail());
		System.out.println(command.getDept_no());
		System.out.println(command.getPosi_no());
		EmployeeVO employee = command.toEmployeeVO();
		
		try {
			employeeService.regist(employee, careers);
		} catch (SQLException e) {
			e.printStackTrace();
			url = "employee/regist_fail";
		}
		return url;
	}
	
	@RequestMapping(value="/idCheck")
	public ResponseEntity<String> checkId(String id) throws Exception {

		ResponseEntity<String> entity = null;
		System.out.println(id);
		
		try {
			employeeService.login(id, null);
		} catch (IdNotFoundException e) {
			entity = new ResponseEntity<String>("SUCCESS", HttpStatus.OK);
		} catch (SQLException | InvalidPasswordException e) {
			entity = new ResponseEntity<String>("FAIL", HttpStatus.BAD_REQUEST);
		}

		return entity;
	}
	
	@RequestMapping(value="/picture/upload", method=RequestMethod.POST, produces="text/plain;charset=utf-8")
	@ResponseBody
	public ResponseEntity<String> uploadProfileImg(MultipartFile file) throws Exception {		
		ResponseEntity<String> entity=null; 

		String sourcePath = null; 
		 
		try { 
			sourcePath = FileUpload.saveFile(file,picturePath).getName(); 
			entity = new ResponseEntity<String>(sourcePath,HttpStatus.CREATED); 
		}catch(Exception e) { 
			entity = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);  
		}			 
		 
		return entity; 
	}

}
