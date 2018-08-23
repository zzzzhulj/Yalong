package com.bat.yalong.manage.service;

import com.bat.yalong.bean.DayCount;
import com.bat.yalong.bean.DayCountDetail;
import com.bat.yalong.bean.YalongBaseCount;

import java.util.List;


public interface CountService {
    void insertYalongBaseCount(YalongBaseCount yalongBaseCount);

    void insertDayCount(DayCount dayCount);

    void insertDayCountDetail(DayCountDetail dayCountDetail);

    List<DayCountDetail> getDayCountDetails(DayCountDetail dayCountDetail);

    List<YalongBaseCount> getBaseCountsBetweenTime(YalongBaseCount yalongBaseCount);

    Integer getOnlineCount();
}
