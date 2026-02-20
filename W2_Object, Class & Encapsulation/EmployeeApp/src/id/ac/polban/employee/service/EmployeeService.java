package id.ac.polban.employee.service;

import java.util.HashMap;
import java.util.Map;
import id.ac.polban.employee.model.Employee;

public class EmployeeService {

    private static int totalEmployee = 0;

    private Map<Integer, Employee> employees = new HashMap<>();

    public void addEmployee(Employee emp) {
        employees.put(emp.getId(), emp);
        totalEmployee++;
    }

    public Employee getEmployee(int id) {
        return employees.get(id);
    }

    public void raiseSalary(int id, double percent) {
        Employee emp = employees.get(id);
        if (emp != null) {
            emp.setSalary(emp.getSalary() * (1 + percent / 100));
        }
    }

    public static int getTotalEmployee() {
        return totalEmployee;
    }
}