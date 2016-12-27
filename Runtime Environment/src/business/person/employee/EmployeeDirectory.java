/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.person.employee;

import business.role.Role;
import java.util.ArrayList;

/**
 *
 * @author raseswaridas
 */
public class EmployeeDirectory {

    private ArrayList<Employee> employeeList;
    
    public EmployeeDirectory(){
        employeeList = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee addEmployee(Role role) {
        Employee employee = new Employee(role);
        employeeList.add(employee);
        return employee;
    }

    public Employee searchEmployeeById(int id) {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    public void removeCustomer(Employee employee) {
        employeeList.remove(employee);
    }
}
