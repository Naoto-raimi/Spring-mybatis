package com.example.persistence.mapper;

import com.example.persistence.entity.Employee;
import com.example.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class EmployeeMapperTest {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        ApplicationContext context = application.run(args);

        EmployeeMapper employeeMapper = context.getBean(EmployeeMapper.class);

        // 新規追加
        System.out.println("==== 新規追加 ====");
        employeeMapper.insert(new Employee("和田三郎", LocalDate.of(2019, 1, 1), 10));

        // 全件検索
        System.out.println("==== 全件検索 ====");
        List<Employee> employeeList1 = employeeMapper.findAll();
        for (Employee employee : employeeList1) {
            System.out.println(employee);
        }

        // 名前キーワード検索
        System.out.println("==== 名前キーワード検索 ====");
        List<Employee> employeeList2 = employeeMapper.findByNameLike("%田%");
        for (Employee employee : employeeList2) {
            System.out.println(employee);
        }

    }
}
