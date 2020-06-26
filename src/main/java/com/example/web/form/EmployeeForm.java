package com.example.web.form;

import com.example.persistence.entity.Employee;
import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class EmployeeForm {
    @NotBlank
    @Length(min = 1, max = 10)
    private String name;

    @PastOrPresent
    @NotNull
    @DateTimeFormat(pattern = "uuuu-MM-dd")
    private LocalDate joinedDate;

    @NotNull
    private Integer departmentId;

    public Employee convertToEntity(){
        return new Employee(name, joinedDate, departmentId);
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

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }
}
