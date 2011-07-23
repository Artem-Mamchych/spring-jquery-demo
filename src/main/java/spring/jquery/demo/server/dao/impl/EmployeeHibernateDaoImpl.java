package spring.jquery.demo.server.dao.impl;

import spring.jquery.demo.server.dao.EmployeeDao;
import spring.jquery.demo.server.entity.Employee;

public class EmployeeHibernateDaoImpl
        extends GenericHibernateDaoImpl<Employee, Long>
        implements EmployeeDao {
}
