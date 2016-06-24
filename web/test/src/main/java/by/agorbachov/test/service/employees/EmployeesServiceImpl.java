package by.agorbachov.test.service.employees;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.agorbachov.test.dao.EmployeesDao;
import by.agorbachov.test.model.Employee;

/**
 * Class service for employees
 * 
 * @author Andrey Gorbachov
 *
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesDao employeesDao;

	public Employee get(Long id) {
		return employeesDao.read(id);
	}

	public void save(Employee employee) {
		if (employee.getId() == null) {
			employeesDao.create(employee);
		} else {
			employeesDao.update(employee);
		}
	}

	public void delete(Long id) {
		employeesDao.delete(id);
	}

	public List<Employee> getAll() {
		return employeesDao.findAll();
	}

}
