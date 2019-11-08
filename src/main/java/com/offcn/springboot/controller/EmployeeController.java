package com.offcn.springboot.controller;

import com.offcn.springboot.bean.Dept;
import com.offcn.springboot.bean.Employee;
import com.offcn.springboot.service.DeptService;
import com.offcn.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DeptService deptService;

    //跳转方法(进入我们的template)
    /*@RequestMapping(value = {"/","/index.html"})
    public String jump(){
        System.out.println("跳转方法");
        return "login";
    }*/


    //登录方法
    @PostMapping("login")
    public String login(Integer eid, String ename, Model model,HttpSession session){
        Employee employee = employeeService.login(eid,ename);
        if(employee!=null){
             /*
             *    /templates/emp/show.html
             * */
             session.setAttribute("activeUser",employee);
             return "redirect:/showInfo";
        }else{
            model.addAttribute("msg","登录异常");
            return "login";
        }
    }

    //展示所有用户的方法
    @GetMapping("showInfo")
    public  String showInfo(Model model,@RequestParam(name = "cp",defaultValue = "0") Integer currentPage){
        /*List<Employee> employeeList = employeeService.showInfo();
        model.addAttribute("list",employeeList);*/
        Page<Employee> pages = employeeService.showInfo(currentPage);
        model.addAttribute("pageInfo",pages);
        model.addAttribute("list",pages.getContent());
        //System.out.println(pages.getContent().get(0).getDept().getDname());
        return "emp/show";
    }

    @GetMapping("deleteInfo")
    public  String deleteInfo(Integer eid){
        boolean  flag = employeeService.deleteInfo(eid);
        return "redirect:/showInfo";
    }

    //查询当前内容显示到我们表单中
    @GetMapping("updateInfo")
    public  String updateInfo(Integer eid, HttpSession session){
         Employee employee = employeeService.getInfoById(eid);
         session.setAttribute("OneInfo",employee);
         session.setAttribute("depts",deptService.getAllDept(employee.getDeptno()));
         return "/emp/edit";
    }

    //数据更新的内容
    @PostMapping("updateById")
    public String  updateById(Employee employee){
        employeeService.updateById(employee);
        return "redirect:/showInfo";
    }






}
