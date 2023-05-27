package com.example.hw2_5;

import com.example.hw2_5.exceptions.EmployeeAlreadyAddedException;
import com.example.hw2_5.exceptions.EmployeeNotFoundException;
import com.example.hw2_5.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Иван", "Иванов"),
            new Employee("Артем", "Иванов"),
            new Employee("Петр", "Петров"),
            new Employee("Илья", "Ильин"),
            new Employee("Антон", "Антонов"),
            new Employee("Ivan","Ivanov")
    ));
    int maxNumberEmployees = 7;
@Override
    public void addEmployee(String firstName, String lastName){
    Employee employee = new Employee(firstName, lastName);
        if (employees.size() == maxNumberEmployees) {
            throw new EmployeeStorageIsFullException("Штат заполнен. Новые сотрудники не нужны");
        } else if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник у нас работает");
        } else {
            employees.add(employee);
        }
}
@Override
    public void removeEmployee(String firstName, String lastName){
    Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            employees.remove(employee);
        } else {
            throw new EmployeeNotFoundException("Работник не найден");
        }
    }
    @Override
    public void findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            System.out.println("Такой сотрудник у нас работает");
        } else {
            throw new EmployeeNotFoundException("Работник не найден");
        }
    }
}
