package com.offcn.springboot.service;

import com.offcn.springboot.bean.Dept;

import java.util.List;

public interface DeptService {

    public List<Dept> getAllDept(Integer eid);
}
