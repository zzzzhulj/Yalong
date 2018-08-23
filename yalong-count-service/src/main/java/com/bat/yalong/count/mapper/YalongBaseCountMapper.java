package com.bat.yalong.count.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bat.yalong.bean.YalongBaseCount;

import java.util.List;

public interface YalongBaseCountMapper extends BaseMapper<YalongBaseCount> {


    List<YalongBaseCount> selectBaseCountsBetweenTime(String start, String end);
}
