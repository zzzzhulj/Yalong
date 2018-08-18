package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("nplm_trust_plan")
public class NplmTrustPlan implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String trustPlanName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrustPlanName() {
        return trustPlanName;
    }

    public void setTrustPlanName(String trustPlanName) {
        this.trustPlanName = trustPlanName;
    }
}
