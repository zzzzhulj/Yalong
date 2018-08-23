package com.bat.yalong.count.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bat.yalong.bean.DayCount;
import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.bean.YalongBaseCount;
import com.bat.yalong.count.mapper.DayCountDetailMapper;
import com.bat.yalong.count.mapper.DayCountMapper;
import com.bat.yalong.count.mapper.YalongBaseCountMapper;
import com.bat.yalong.manage.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.thymeleaf.expression.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@org.springframework.stereotype.Service
public class CountServiceImpl implements CountService {

    @Autowired
    private YalongBaseCountMapper yalongBaseCountMapper;

    @Autowired
    private DayCountMapper dayCountMapper;

    @Autowired
    private DayCountDetailMapper dayCountDetailMapper;


    @Async
    @Override
    public void insertYalongBaseCount(YalongBaseCount yalongBaseCount) {
        yalongBaseCountMapper.insertAllColumn(yalongBaseCount);
    }

    @Override
    public void insertDayCount(DayCount dayCount) {
        dayCountMapper.insertAllColumn(dayCount);
    }

    @Override
    public void insertDayCountDetail(DayCountDetail dayCountDetail) {
        dayCountDetailMapper.insertAllColumn(dayCountDetail);
    }

    @Override
    public List<DayCountDetail> getDayCountDetails(DayCountDetail dayCountDetail) {
        List<DayCountDetail> dayCountDetailList = dayCountDetailMapper.selectList(new EntityWrapper<DayCountDetail>()
                .eq("day", dayCountDetail.getDay()).orderAsc(Arrays.asList("day_of_detail")));
        return dayCountDetailList;
    }
}
