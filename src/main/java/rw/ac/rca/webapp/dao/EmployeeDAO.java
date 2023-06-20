/**
 *
 */
package rw.ac.rca.webapp.dao;

import rw.ac.rca.webapp.orm.Employee;

import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
public interface EmployeeDAO {

    public Employee saveEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public Employee saveOrUpdateEmployee(Employee employee);
    public boolean deleteEmployee(Employee employee);
    public Employee getEmployeeById(int employeeId);
    public List<Employee> getAllEmployees();

}
