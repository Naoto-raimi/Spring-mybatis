package com.example.web.form;

import com.example.persistence.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EmployeeForm {
    private String name;

    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate joinedDate;

    private Integer departmentID;

    public Employee convertToEntity(){
        return new Employee(name, joinedDate, departmentID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(LocalDate joinedDate) {
        this.joinedDate = joinedDate;
    }

    public Integer getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(Integer departmentID) {
        this.departmentID = departmentID;
    }
}
