package by.agorbachov.test.dao;

import java.util.List;

import by.agorbachov.test.model.Employee;

/**
 * Interface for DAO the table "employees"
 * 
 * @author Andrey Gorbachov
 *
 */

public interface EmployeesDao {

	void create(Employee employee);

	Employee read(Long id);

	void update(Employee employee);

	void delete(Long id);

	List<Employee> findAll();

}
