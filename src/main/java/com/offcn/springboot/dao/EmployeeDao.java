package com.offcn.springboot.dao;

import com.offcn.springboot.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeDao extends PagingAndSortingRepository<Employee,Integer> {

    //通过用户名和密码进行查询
    public Employee findByEidAndEname(Integer eid,String ename);

    @Query("from  Employee")
    public List<Employee> findAllInfo();

    //通过我们的id获取指定的对象
    public  Employee getEmployeeByEid(Integer eid);

    /*@Query("from Employee e where e.eid=?1 and e.ename=?2")
    public Employee findByEidAndEname(Integer eid,String ename);*/
}
