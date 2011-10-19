package spring.jquery.demo.server.dao.impl;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import spring.jquery.demo.server.dao.EmployeeDao;
import spring.jquery.demo.server.entity.Employee;

import java.util.*;

public class EmployeeFakeDaoImpl implements EmployeeDao {

    Map<Long, Employee> map = new HashMap<Long, Employee>();

    @Override
    public Employee findById(Long id, boolean lock) {
        return map.get(id);
    }

    @Override
    public List<Employee> findAll() {
        //Prevent empty result set
        if (map.values().size() == 0) {
            makePersistent(new Employee("A1", "B", 1000));
            makePersistent(new Employee("A2", "B", 1200));
            makePersistent(new Employee("A3", "B", 1300));
            makePersistent(new Employee("A4", "B", 1500));
            makePersistent(new Employee("A5", "B", 1400));
            makePersistent(new Employee("A6", "B", 1600));
            makePersistent(new Employee("A7", "B", 1700));
            makePersistent(new Employee("A8", "B", 1800));
        }
        return new ArrayList<Employee>(map.values());
    }

    private String searchResultJson(List<Employee> list, Integer pageCount) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        JSONObject root = new JSONObject();
        JSONArray regionsArray = new JSONArray();
        for (Employee e : list) {

            JSONObject directory = new JSONObject();
            directory.put("firstName", "view.html?id="+ e.getFirstName());
            directory.put("lastName", e.getLastName());
            directory.put("baseSalary", e.getBaseSalary());
            directory.put("birthday", e.getBirthday());

            regionsArray.add(directory);
        }
        root.put("results", regionsArray);
        root.put("pages", pageCount);

        return root.toJSONString();
    }

    @Override
    public List<Employee> findByExample(Employee exampleInstance, String[] excludeProperty) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Employee makePersistent(Employee entity) {
        map.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void makeTransient(Employee entity) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
