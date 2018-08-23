package com.bat.yalong.count.task;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.bat.yalong.bean.DayCount;
import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.bean.YalongBaseCount;
import com.bat.yalong.config.RedisUtil;
import com.bat.yalong.manage.service.CountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@EnableScheduling
@Component
public class CountTask {

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private CountService countService;


    //每两分钟执行一次
    @Scheduled(cron = "0 0/2 * * * ?")
    public void saveBaseCountToDB(){
        Jedis jedis = redisUtil.getJedis();
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        String format = fm.format(date);

//            String 当天访问详情的key
        String baseCountKey = "yalong:"+format+":baseCount";
        Long hlen = jedis.llen(baseCountKey);
        List<String> lrange = jedis.lrange(baseCountKey, 0, hlen);
        for (String s : lrange) {
            YalongBaseCount yalongBaseCount = JSON.parseObject(s, YalongBaseCount.class);
            countService.insertYalongBaseCount(yalongBaseCount);
        }
        jedis.del(baseCountKey);
//            当天的访问量统计key
        String dayCountKsy = "yalong:"+format+":dayCount";

        String s = jedis.get(dayCountKsy);
        if(!StringUtils.isEmpty(s)){
            DayCount dayCount = new DayCount();
            dayCount.setCount(Integer.parseInt(s));
            dayCount.setTime(format);
            countService.insertDayCount(dayCount);
        }

        jedis.del(dayCountKsy);

    }

    @Scheduled(cron = "0 0/2 * * * ?")
    public void saveDayCountDetailToDB(){
        Jedis jedis = redisUtil.getJedis();
        Date date = new Date();
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = fm.format(date);
        DayCountDetail dayCountDetail = new DayCountDetail();
        dayCountDetail.setDay(format);
        dayCountDetail.setDayOfDetail(fm2.format(date));
        Long aLong = jedis.dbSize();
        dayCountDetail.setCount(aLong);
        countService.insertDayCountDetail(dayCountDetail);
    }

}
