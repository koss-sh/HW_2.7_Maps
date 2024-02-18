package pro.sky.hw2_7.services;
import org.springframework.stereotype.Service;
import pro.sky.hw2_7.exceptions.EmployeeAlreadyAddedException;
import pro.sky.hw2_7.exceptions.EmployeeNotFoundException;
import pro.sky.hw2_7.exceptions.EmployeeStorageIsFullException;
import pro.sky.hw2_7.model.Employee;


import java.util.*;

@Service
public class EmployeeService {
    private final int SIZE = 3;
    private Map<String, Employee> employees = new HashMap<>(SIZE);

    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.size() < SIZE) {
            if (employees.containsKey(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            employees.put(employee.getName(), employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = findEmployee(firstName, lastName);
        employees.remove(employee.getName());
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getName())) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
}
