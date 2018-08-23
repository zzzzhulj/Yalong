package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

@TableName("day_count_detail")
public class DayCountDetail {

    @TableId(type = IdType.AUTO)
    private String id;

    private String day;

    private Long count;

    private String dayOfDetail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getDayOfDetail() {
        return dayOfDetail;
    }

    public void setDayOfDetail(String dayOfDetail) {
        this.dayOfDetail = dayOfDetail;
    }
}
