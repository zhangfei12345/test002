package com.offcn.springboot.service;

import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.dao.EmployeeDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDao employeeDao;

    @Override
    public Employee login(Integer eid, String ename) {
        // employeeDao.getOne(); 查询如果当前对象存在那么就会返回该对象的，如果对象不存在抛出异常
        // hibernate    get(id)(如果不存在当前id的对象，那么就会抛出异常)  find(id)
        return employeeDao.findByEidAndEname(eid,ename);
    }

    @Override
    public Page<Employee> showInfo(Integer currentPage) {
        //return  employeeDao.findAllInfo();
        Sort.Order order1 = new Sort.Order(Sort.Direction.DESC, "eid");
        Sort sort = Sort.by(order1);
        PageRequest pageable = PageRequest.of(currentPage, 2, sort);
        Page<Employee> page = employeeDao.findAll(pageable);

        return page;
    }

    @Override
    public boolean deleteInfo(Integer eid) {
        employeeDao.deleteById(eid);
        return true;
    }

    @Override
    public Employee getInfoById(Integer eid) {
           return  employeeDao.getEmployeeByEid(eid);
    }

    @Override
    public boolean updateById(Employee employee) {
        //全部字段更新，这个时候如果有关联那么关联的字段还没有改变这个时候就会出现级联查询异常
          employeeDao.save(employee);
          return true;
    }
}
