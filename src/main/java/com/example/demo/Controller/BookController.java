package com.example.demo.Controller;

import com.example.demo.dao.Employee;
import com.example.demo.dao.EmployeeMapper;
import com.example.demo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class BookController {

    @Value("${wuhan2020}")
    String wuhan2020;

    @Autowired
    EmployeeMapper employeeMapper;

    private List<Book> books = new ArrayList<>();

    @PostMapping("/book")
    public ResponseEntity<List<Book>> addBook(@RequestBody Book book) {
        books.add(book);   //0 1 2 3 
        return ResponseEntity.ok(books);
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity deleteBookById(@PathVariable("id") int id) {
        books.remove(id);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/book")
    public ResponseEntity getBookByName(@RequestParam("name") String name) {
        List<Book> results = books.stream().filter(book -> book.getName().equals(name)).collect(Collectors.toList());
        return ResponseEntity.ok(results);
    }
    @GetMapping("/employee")
    public String employeeTest(){
        //初始数据
        List<Employee> list = employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("______________________添加员工___________________________");
        //添加新员工
        Employee newEmployee = new Employee(6l,"king","king@qq.com",20);
        employeeMapper.addEmployee(newEmployee);
        //添加后输出
        list = employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("______________________删除员工___________________________");
        //删除
        employeeMapper.deleteEmployee(6L);
        //删除后输出
        list = employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("______________________修改员工___________________________");
        //修改
        Employee upEmployee = new Employee(4l,"kingdommmmm","king@qq.com",20);
        employeeMapper.updateEmployee(upEmployee);
        //修改后输出
        list = employeeMapper.findEmployee();
        list.forEach(System.out::println);
        System.out.println("______________________查询员工___________________________");
        //查询
        Employee queryEmployee = employeeMapper.queryEmployee(1l);
        System.out.println(queryEmployee);
        return "测试完成";

    }
}