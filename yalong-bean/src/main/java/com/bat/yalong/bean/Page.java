package com.bat.yalong.bean;


import java.beans.Transient;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.pagination.Pagination;

/**
 * <p>
 * 实现分页辅助类
 * </p>
 *
 * @author hubin
 * @Date 2016-03-01
 */
public class Page<T> extends Pagination implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 查询数据列表
     */
    private List<T> records = Collections.emptyList();

    private int start;

    public int getStart() {

        return start;
    }

    /**
     * 查询参数（ 不会传入到 xml 层，这里是 Controller 层与 service 层传递参数预留 ）
     */
    private Map<String, Object> condition;

    public Page() {
        /* 注意，传入翻页参数 */
    }

    public Page(int current, int size) {
        super(current, size);
    }

    public Page(int current, int size, String orderByField) {
        super(current, size);
        this.setOrderByField(orderByField);
    }

    public Page(int current, int size, String orderByField, boolean isAsc) {
        this(current, size, orderByField);
        this.setAsc(isAsc);
    }

    public List<T> getRecords() {
        return records;
    }

    public Page<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    @Transient
    public Map<String, Object> getCondition() {
        return condition;
    }

    public Page<T> setCondition(Map<String, Object> condition) {
        this.condition = condition;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder pg = new StringBuilder();
        pg.append(" Page:{ [").append(super.toString()).append("], ");
        if (records != null) {
            pg.append("records-size:").append(records.size());
        } else {
            pg.append("records is null");
        }
        return pg.append(" }").toString();
    }

}

