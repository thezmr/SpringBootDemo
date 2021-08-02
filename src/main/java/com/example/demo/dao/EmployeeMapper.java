package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper extends BaseMapper<Employee> {
    List<Employee> findEmployee();//输出所有信息

    int addEmployee(Employee employee);

    int deleteEmployee(long id);

    int updateEmployee(Employee employee);

    Employee queryEmployee(long id);

}
