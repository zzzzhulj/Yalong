package com.bat.yalong.count.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.bat.yalong.bean.DayCount;
import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.bean.YalongBaseCount;
import com.bat.yalong.config.RedisUtil;
import com.bat.yalong.count.mapper.DayCountDetailMapper;
import com.bat.yalong.count.mapper.DayCountMapper;
import com.bat.yalong.count.mapper.YalongBaseCountMapper;
import com.bat.yalong.manage.service.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.thymeleaf.expression.Lists;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.*;


@org.springframework.stereotype.Service
public class CountServiceImpl implements CountService {

    @Autowired
    private YalongBaseCountMapper yalongBaseCountMapper;

    @Autowired
    private DayCountMapper dayCountMapper;

    @Autowired
    private DayCountDetailMapper dayCountDetailMapper;

    @Autowired
    private RedisUtil redisUtil;

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

    @Override
    public List<YalongBaseCount> getBaseCountsBetweenTime(YalongBaseCount yalongBaseCount) {
        String time = yalongBaseCount.getTime();

        String start = time+ " 00:00:00";
        String end = time+ " 23:59:59";

        System.out.println(start);
        System.out.println(end);
        List<YalongBaseCount> yalongBaseCounts = yalongBaseCountMapper.selectBaseCountsBetweenTime(start,end);
        return yalongBaseCounts;
    }

    @Override
    public Integer getOnlineCount() {
        Jedis jedis = redisUtil.getJedis();
        Long aLong = jedis.dbSize();
        jedis.close();
        return Integer.parseInt(aLong.toString());
    }
}
