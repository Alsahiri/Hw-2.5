package com.example.hw2_5;

import com.example.hw2_5.exceptions.EmployeeNotFoundException;
import com.example.hw2_5.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

public interface EmployeeService {

    void addEmployee(String firstName, String lastName);

    void removeEmployee(String firstName, String lastName);

    void findEmployee(String firstName, String lastName);
}
