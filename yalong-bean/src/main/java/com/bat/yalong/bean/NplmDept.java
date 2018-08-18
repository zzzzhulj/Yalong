package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("nplm_dept")
public class NplmDept {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String deptName;

    private String deptAddress;
}
