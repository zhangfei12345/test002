package com.offcn.springboot.dao;

import com.offcn.springboot.bean.Dept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeptDao  extends JpaRepository<Dept,Integer> {
/*
    @Query("from Dept")
    public List<Dept> selectAllInfo();
*/

   List<Dept> findDeptByDeptnoIsNot(Integer eid);

}
