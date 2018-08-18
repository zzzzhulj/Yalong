package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("nplm_trust_series")
public class NplmTrustSeries implements Serializable {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String trustSeriesName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrustSeriesName() {
        return trustSeriesName;
    }

    public void setTrustSeriesName(String trustSeriesName) {
        this.trustSeriesName = trustSeriesName;
    }
}
