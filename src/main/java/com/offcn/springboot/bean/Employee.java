package com.offcn.springboot.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer eid;
    @Column
    private String ename;
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date hirdate;
    @Column
    private Double salary;
    //部门编号
    @Column
    private Integer deptno;
    //单独学习hibernate注解  jpa 基于hibernate注解完成数据库的操作的
    @ManyToOne
    private Dept dept;

}
