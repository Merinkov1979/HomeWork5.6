package com.example.homework56.service;

import com.example.homework56.exception.EmployeeAlreadyAddedException;
import com.example.homework56.exception.EmployeeNotFoundException;
import com.example.homework56.exception.EmployeeStoragelsFullException;
import com.example.homework56.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private static final int SIZE = 5;

    private final List <Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employees.contains(employee)) {
                throw new EmployeeAlreadyAddedException();
            }
            if (employees.size() >= SIZE) {
                throw new EmployeeStoragelsFullException();
            }
            employees.add(employee);
            return employee;
        }


    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException();
    }


    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();

    }
    public List<Employee> findAll(){
        return Collections.unmodifiableList(employees);
    }

}


