package com.offcn.springboot.service;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.dao.DeptDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Resource
    private DeptDao deptDao;

    @Override
    public List<Dept> getAllDept(Integer eid) {
       // return deptDao.selectAllInfo();
        //return deptDao.findAll();
        return deptDao.findDeptByDeptnoIsNot(eid);
    }
}
