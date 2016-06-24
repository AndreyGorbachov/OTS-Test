package by.agorbachov.test.web.mvc.employees;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import by.agorbachov.test.model.Employee;
import by.agorbachov.test.service.employees.EmployeesService;
import by.agorbachov.test.web.mvc.ControllerConstants;
import by.agorbachov.test.web.mvc.ResponseForm;

/**
 * 
 * @author Andrey Gorbachov
 *
 */
@Controller
public class EmployeesController {

	private static final String EMPLOYEES = "employees";

	@Autowired
	private EmployeesService employeesService;

	@RequestMapping(value = "/employees.html", method = RequestMethod.GET)
	public String getEmployeesPage(Model model) {
		model.addAttribute("employeesList", employeesService.getAll());
		return EMPLOYEES;
	}

	@RequestMapping(value = "/get_all_employees.json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseForm getEmployeesList() {
		ResponseForm form = new ResponseForm();
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("employeesList", employeesService.getAll());
			data.put("employeeForm", new Employee());
			form.setData(data);
		} catch (Exception e) {
			form.setResultCode(ControllerConstants.RESULT_SERVER_ERROR);
		}
		return form;
	}

	@RequestMapping(value = "/get_employee.json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseForm editEmployee(@RequestBody Long id) {
		ResponseForm form = new ResponseForm();
		try {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("employeeForm", employeesService.get(id));
			form.setData(data);
		} catch (Exception e) {
			form.setResultCode(ControllerConstants.RESULT_SERVER_ERROR);
		}
		return form;
	}

	@RequestMapping(value = "/save_employee.json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseForm saveEmployee(@RequestBody Employee employee) {
		ResponseForm form = new ResponseForm();
		try {
			employeesService.save(employee);
		} catch (Exception e) {
			form.setResultCode(ControllerConstants.RESULT_SERVER_ERROR);
		}
		return form;
	}

	@RequestMapping(value = "/delete_employee.json", method = RequestMethod.POST)
	@ResponseBody
	public ResponseForm deleteEmployee(@RequestBody Long id) {
		ResponseForm form = new ResponseForm();
		try {
			employeesService.delete(id);
		} catch (Exception e) {
			form.setResultCode(ControllerConstants.RESULT_SERVER_ERROR);
		}
		return form;
	}

}
