package com.bat.yalong.count.controller;

import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.manage.service.CountService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class CountController {

    @Autowired
    private CountService countService;


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
    public Object getBaseCount(){
        return null;
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
