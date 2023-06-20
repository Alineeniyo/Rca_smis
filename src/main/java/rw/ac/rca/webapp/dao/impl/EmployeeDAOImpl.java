/**
 *
 */
package rw.ac.rca.webapp.dao.impl;

import org.hibernate.Query;
import rw.ac.rca.webapp.dao.EmployeeDAO;
import rw.ac.rca.webapp.orm.Employee;

import java.util.List;

/**
 * @author Aphrodice Rwagaju
 *
 */
public class EmployeeDAOImpl extends DAO  implements EmployeeDAO {

    private static EmployeeDAOImpl instance;

    private EmployeeDAOImpl() {
    }

    public static EmployeeDAOImpl getInstance() {
        if (instance == null) {
            return new EmployeeDAOImpl();
        } else {
            return instance;
        }
    }

    public Employee saveEmployee(Employee employee) {
        try {
            begin();
            getSession().save(employee);
            commit();
            return employee;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    public Employee updateEmployee(Employee employee) {
        try {
            begin();
            getSession().update(employee);
            commit();
            return employee;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    public Employee saveOrUpdateEmployee(Employee employee) {
        try {
            begin();
            getSession().saveOrUpdate(employee);
            commit();
            return employee;
        } catch (Exception e) {
            rollback();
            return null;
        }
    }

    public boolean deleteEmployee(Employee employee) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from Employee where id= :ref");
            query.setInteger("ref", employee.getId());
            Employee crs = (Employee) query.uniqueResult();
            getSession().delete(crs);
            commit();
            return true;

        } catch (Exception e) {
            rollback();
            return false;
        }
    }

    public Employee getEmployeeById(int employeeId) {
        try {
            begin();
            Query query = getSession().createQuery(
                    "from Employee where id= :ref");
            query.setInteger("ref", employeeId);
            Employee employee = (Employee) query.uniqueResult();
            commit();
            return employee;
        } catch (Exception e) {
            rollback();
            return null;

        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Employee> getAllEmployees() {
        try {
            begin();
            Query query = getSession().createQuery("FROM Employee");
            List<Employee> employee = query.list();
             commit();
            return employee;
        } catch (Exception e) {
            rollback();
            e.printStackTrace();
            return null;
        }
    }
}