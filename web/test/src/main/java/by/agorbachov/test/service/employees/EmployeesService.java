package by.agorbachov.test.service.employees;

import java.util.List;

import by.agorbachov.test.model.Employee;

/**
 * Interface service for employees
 * 
 * @author Andrey Gorbachov
 *
 */

public interface EmployeesService {

	Employee get(Long id);

	void save(Employee employee);

	void delete(Long id);

	List<Employee> getAll();

}
