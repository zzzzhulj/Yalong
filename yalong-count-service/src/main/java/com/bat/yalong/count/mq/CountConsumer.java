package com.bat.yalong.count.mq;

import com.alibaba.fastjson.JSON;
import com.bat.yalong.bean.YalongBaseCount;
import com.bat.yalong.config.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class CountConsumer {

    @Autowired
    private RedisUtil redisUtil;
    /**
     * 将数据放到缓存中 开启定时任务将数据插入到数据库
     * @param mapMessage
     */
    @JmsListener(destination = "YALONG_COUNT_QUEUE",containerFactory = "jmsQueueListener")
    public void consumerPaymentResultCheck(MapMessage mapMessage){
        try {
            Date date = new Date();
            SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat fm2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String agent = mapMessage.getString("agent");
            String requestURL = mapMessage.getString("requestURL");
            String remoteAddr = mapMessage.getString("remoteAddr");

            YalongBaseCount yalongBaseCount = new YalongBaseCount();
            yalongBaseCount.setBrowser(agent);
            yalongBaseCount.setRequestUrl(requestURL);
            yalongBaseCount.setIp(remoteAddr);
            yalongBaseCount.setTime(fm2.format(date));
//            使用list的存储结构 key为当前日期
            String format = fm.format(date);
            Jedis jedis =
                    redisUtil.getJedis();
//            String 当天访问详情的key
            String baseCountKey = "yalong:"+format+":baseCount";
            jedis.lpush(baseCountKey, JSON.toJSONString(yalongBaseCount));

//            当天的流量统计key
            String dayCountKsy = "yalong:"+format+":dayCount";

            Boolean exists = jedis.exists(dayCountKsy);
            if(!exists){
                jedis.set(dayCountKsy, "1");
            }else{
                jedis.incr(dayCountKsy);
            }



            //
            String onLineKey = "yalong:"+ remoteAddr+":online";
            jedis.setex(onLineKey, 60*10,"如果登陆了就用用户id,没有登陆就存个0");

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }

}
