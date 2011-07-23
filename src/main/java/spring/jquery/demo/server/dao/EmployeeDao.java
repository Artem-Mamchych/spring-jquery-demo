package spring.jquery.demo.server.dao;

import spring.jquery.demo.server.entity.Employee;

/**
 * Plain DAO which provides only {@link spring.jquery.demo.server.dao.impl.GenericHibernateDaoImpl} methods
 */
public interface EmployeeDao extends GenericDao<Employee, Long> {
}
