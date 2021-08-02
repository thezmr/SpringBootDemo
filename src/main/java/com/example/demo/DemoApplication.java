package com.example.demo;

import com.example.demo.dao.Employee;
import com.example.demo.dao.EmployeeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class DemoApplication {


    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}
