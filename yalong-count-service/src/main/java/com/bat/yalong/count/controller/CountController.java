package com.bat.yalong.count.controller;

import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.bean.YalongBaseCount;
import com.bat.yalong.manage.service.CountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CountController {


    @Autowired
    private CountService countService;


    @RequestMapping("/getOnlineCount")
    @ResponseBody
    public Object getOnlineCount(){
        Integer result = countService.getOnlineCount();
        return result;
    }

    @RequestMapping("/onlineCount")
    public String onlineCount(){
        return "onlineCountListener";
    }


    @RequestMapping("/base_count")
    public String base_count(){
        return "base_count";
    }

    @RequestMapping("/day_count_detail")
    public String index(){
        return "day_count_detail";
    }

    @RequestMapping("/getBaseCount")
    @ResponseBody
    public Object getBaseCount(String year,String mouth,String day){

        Map map = new HashMap();
        List<YalongBaseCount> yalongBaseCounts = new ArrayList<>();
        if(StringUtils.isEmpty(year)||StringUtils.isEmpty(mouth)||StringUtils.isEmpty(day)){
            Date date = new Date();

            YalongBaseCount yalongBaseCount = new YalongBaseCount();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

            String format = simpleDateFormat.format(date);
            yalongBaseCount.setTime(format);
            yalongBaseCounts = countService.getBaseCountsBetweenTime(yalongBaseCount);
        }else{
            String dateStr = year+"-"+mouth+"-"+day;
            YalongBaseCount yalongBaseCount = new YalongBaseCount();
            yalongBaseCount.setTime(dateStr);
            yalongBaseCounts = countService.getBaseCountsBetweenTime(yalongBaseCount);
        }

        List<String> urlList = new ArrayList<>();
        List<Map> seriesData = new ArrayList<>();
        for (YalongBaseCount yalongBaseCount : yalongBaseCounts) {
            String requestUrl = yalongBaseCount.getRequestUrl();
            int i = requestUrl.lastIndexOf("/");
            String substring = requestUrl.substring(i);
//            requestUrl.substring();
            Integer count = yalongBaseCount.getCount();
            urlList.add(substring);
            Map map1 = new HashMap();
            map1.put("value", count);
            map1.put("name", substring);
            seriesData.add(map1);
        }
        map.put("urlList", urlList);
        map.put("seriesData", seriesData);
        return map;
    }


    @RequestMapping("/getDayCount")
    @ResponseBody
    public Object getDayCount(String year,String mouth,String day){
        if(StringUtils.isEmpty(year)||StringUtils.isEmpty(mouth)||StringUtils.isEmpty(day)){
            DayCountDetail dayCountDetail = new DayCountDetail();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            dayCountDetail.setDay(format);
            return getdayCountList(dayCountDetail);
        }else{
            String dateStr = year+"-"+mouth+"-"+day;
            DayCountDetail dayCountDetail = new DayCountDetail();
            dayCountDetail.setDay(dateStr);

            return getdayCountList(dayCountDetail);
        }

    }

    private Object getdayCountList(DayCountDetail dayCountDetail) {
        List<DayCountDetail> dayCountDetailList = countService.getDayCountDetails(dayCountDetail);
        List<Long> dayCount = new ArrayList<>();
        for (DayCountDetail countDetail : dayCountDetailList) {
            dayCount.add(countDetail.getCount());
        }
        return dayCount;
    }

}
