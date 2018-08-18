package com.bat.yalong.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bat.yalong.bean.NplmLoanContract;
import com.bat.yalong.bean.NplmLoanVariety;
import com.bat.yalong.bean.NplmTrustAgency;
import com.bat.yalong.manage.mapper.*;
import com.bat.yalong.manage.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    private NplmBorrowerInfoMapper nplmBorrowerInfoMapper;

    @Autowired
    private NplmContractAttributeMapper bpNplmContractAttributeMapper;

    @Autowired
    private NplmLoanContractMapper nplmLoanContractMapper;

    @Autowired
    private NplmLoanVarietyMapper nplmLoanVarietyMapper;

    @Autowired
    private NplmTrustAgencyMapper nplmTrustAgencyMapper;

    @Autowired
    private NplmDeptMapper nplmDeptMapper;

    @Autowired
    private NplmTrustPlanMapper nplmTrustPlanMapper;

    @Autowired
    private NplmTrustSeriesMapper nplmTrustSeriesMapper;

    @Override
    public NplmLoanContract getLoanContract(Integer id) {

        return nplmLoanContractMapper.selectById(id);
    }
}
