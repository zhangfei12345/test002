package com.offcn.springboot.service;

import com.offcn.springboot.bean.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {


    Employee login(Integer eid, String ename);

    Page<Employee> showInfo(Integer currentPage);

    boolean deleteInfo(Integer eid);

    Employee getInfoById(Integer eid);

    boolean  updateById(Employee employee);

}
