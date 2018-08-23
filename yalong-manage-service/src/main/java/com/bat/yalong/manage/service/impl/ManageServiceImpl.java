package com.bat.yalong.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.bat.yalong.bean.*;
import com.bat.yalong.manage.mapper.*;
import com.bat.yalong.manage.service.ManageService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

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

    @Autowired
    private NplmRepaymentPlanMapper nplmRepaymentPlanMapper;

    @Autowired
    private NplmRepaymentDetailMapper nplmRepaymentDetailMapper;

    @Autowired
    private NplmRepaymentRecordMapper nplmRepaymentRecordMapper;

    @Autowired
    private NplmOverdueContractMapper nplmOverdueContractMapper;

    @Autowired
    private RepaymentDetailsMapper repaymentDetailsMapper;
    @Override
    public NplmLoanContract getLoanContract(Integer id) {

        return nplmLoanContractMapper.selectById(id);
    }

    @Override
    public Page<NplmLoanContract> getAllLoanContractPage() {
        return null;
    }


    @Override
    public Page<NplmLoanContract> searchLoanContract(NplmLoanContract nplmLoanContract,Integer current,Integer pageSize) {
        String loanContractNum = nplmLoanContract.getLoanContractNum();

        EntityWrapper<NplmLoanContract> nplmLoanContractEntityWrapper = new EntityWrapper<>();
        Map<String,Object> map  = new HashMap<>();
        if(loanContractNum!=null&&loanContractNum.trim().length()>0){
            nplmLoanContractEntityWrapper.eq("loan_contract_num", loanContractNum);
        }
        String contractType = nplmLoanContract.getContractType();
        if(!StringUtils.isEmpty(contractType)&&!contractType.equals("0")){
            nplmLoanContractEntityWrapper.eq("contract_type", contractType);
        }

        Integer trustAgencyId = nplmLoanContract.getTrustAgencyId();
        if(trustAgencyId!=null&&trustAgencyId!=0){
            nplmLoanContractEntityWrapper.eq("trust_agency_id", trustAgencyId);
        }

        Integer trustSeriesId = nplmLoanContract.getTrustSeriesId();
        if(trustSeriesId!=null&&trustSeriesId!=0){
            nplmLoanContractEntityWrapper.eq("trust_series_id", trustSeriesId);
        }
        Integer trustPlanId = nplmLoanContract.getTrustPlanId();
        if(trustPlanId!=null&&trustPlanId!=0){
            nplmLoanContractEntityWrapper.eq("trust_plan_id", trustPlanId);
        }

        String clientName = nplmLoanContract.getClientName();
        if(!StringUtils.isEmpty(clientName)){
            nplmLoanContractEntityWrapper.eq("client_name",clientName );
        }

        String identityNum = nplmLoanContract.getIdentityNum();
        if(!StringUtils.isEmpty(identityNum)){
            nplmLoanContractEntityWrapper.eq("identity_num", identityNum);
        }

        String businessType = nplmLoanContract.getBusinessType();
        if(!StringUtils.isEmpty(businessType)){
            nplmLoanContractEntityWrapper.eq("business_type", businessType);
        }

        String changeType = nplmLoanContract.getChangeType();
        if(!StringUtils.isEmpty(changeType)){
            nplmLoanContractEntityWrapper.eq("change_type", changeType);
        }

        String deptAddress = nplmLoanContract.getDeptAddress();
        if(!StringUtils.isEmpty(deptAddress)){
            nplmLoanContractEntityWrapper.eq("dept_address", deptAddress);
        }

        String deptName = nplmLoanContract.getDeptName();
        if(!StringUtils.isEmpty(deptName)){
            nplmLoanContractEntityWrapper.eq("dept_name", deptName);
        }
        String createTimeEnd = nplmLoanContract.getCreateTimeEnd();
        String createTimeStart = nplmLoanContract.getCreateTimeStart();
        if(!StringUtils.isEmpty(createTimeStart)&&!StringUtils.isEmpty(createTimeEnd)){
            nplmLoanContractEntityWrapper.between("create_time", createTimeStart, createTimeEnd);
        }else if(!StringUtils.isEmpty(createTimeStart)&&StringUtils.isEmpty(createTimeEnd)){
            nplmLoanContractEntityWrapper.gt("create_time", createTimeStart);
        }else if(StringUtils.isEmpty(createTimeStart)&&!StringUtils.isEmpty(createTimeEnd)){
            nplmLoanContractEntityWrapper.lt("create_time", createTimeEnd);
        }

        String putTimeEnd = nplmLoanContract.getCreateTimeEnd();
        String putTimeStart = nplmLoanContract.getCreateTimeStart();
        if(!StringUtils.isEmpty(putTimeStart)&&!StringUtils.isEmpty(putTimeEnd)){
            nplmLoanContractEntityWrapper.between("put_time", putTimeStart, putTimeEnd);
        }else if(!StringUtils.isEmpty(putTimeStart)&&StringUtils.isEmpty(putTimeEnd)){
            nplmLoanContractEntityWrapper.gt("put_time", putTimeStart);
        }else if(StringUtils.isEmpty(putTimeStart)&&!StringUtils.isEmpty(putTimeEnd)){
            nplmLoanContractEntityWrapper.lt("put_time", putTimeEnd);
        }

        Page<NplmLoanContract> page = new Page<>(current,pageSize);
        List<NplmLoanContract> nplmLoanContracts = nplmLoanContractMapper.selectPage(page, nplmLoanContractEntityWrapper);
        getLoanContractsAttr(nplmLoanContracts);


        page.setRecords(nplmLoanContracts);
        return page;
    }

    @Override
    public NplmRepaymentPlan getRepaymentPlan(String loanContractNum) {
        NplmRepaymentPlan nplmRepaymentPlan = new NplmRepaymentPlan();
        nplmRepaymentPlan.setLoanContractNum(Integer.parseInt(loanContractNum));
        NplmRepaymentPlan nplmRepaymentPlan1 = nplmRepaymentPlanMapper.selectOne(nplmRepaymentPlan);
        return nplmRepaymentPlan1;
    }

    @Override
    public NplmLoanContract getLoanContractByNum(String loanContractNum) {
        NplmLoanContract nplmLoanContract = new NplmLoanContract();
        nplmLoanContract.setLoanContractNum(loanContractNum);
        NplmLoanContract nplmLoanContract1 = nplmLoanContractMapper.selectOne(nplmLoanContract);
        return nplmLoanContract1;
    }

    @Override
    public NplmBorrowerInfo getNplmBorrowerById(String borrowerId) {
        NplmBorrowerInfo borrowerInfo = nplmBorrowerInfoMapper.selectById(borrowerId);
        return borrowerInfo;
    }

    @Override
    public List<NplmRepaymentDetail> getNplmRepaymentDetailByNum(String loanContractNum) {
        List<NplmRepaymentDetail> nplmRepaymentDetails = nplmRepaymentDetailMapper.selectList(new EntityWrapper<NplmRepaymentDetail>().eq("LOAN_CONTRACT_NUM", loanContractNum));
        return nplmRepaymentDetails;
    }

    @Override
    public NplmOverdueContract getNplmOverdueContractByNum(String loanContractNum) {
        NplmOverdueContract nplmOverdueContract = new NplmOverdueContract();
        nplmOverdueContract.setLoanContractNum(loanContractNum);
        NplmOverdueContract nplmOverdueContract1 = nplmOverdueContractMapper.selectOne(nplmOverdueContract);
        return nplmOverdueContract1;
    }

    @Override
    public List<RepaymentDetails> getRepaymentDetails(String loanContractNum) {
        List<RepaymentDetails> repaymentDetailsList = repaymentDetailsMapper.selectList(new EntityWrapper<RepaymentDetails>().eq("loan_contract_num", loanContractNum));

        return repaymentDetailsList;
    }

    private void getLoanContractsAttr(List<NplmLoanContract> nplmLoanContracts) {
        for (NplmLoanContract contract : nplmLoanContracts) {
            //借款人Id
            String borrowerId = contract.getBorrowerId();
            NplmBorrowerInfo nplmBorrowerInfo =
                    nplmBorrowerInfoMapper.selectById(borrowerId);
            contract.setNplmBorrowerInfo(nplmBorrowerInfo);
            //合同Id
            String id = contract.getId();
            NplmContractAttribute nplmContractAttribute = new NplmContractAttribute();
            nplmContractAttribute.setLoanContractId(id);
            NplmContractAttribute nplmContractAttribute1 = bpNplmContractAttributeMapper.selectOne(nplmContractAttribute);
            contract.setNplmContractAttribute(nplmContractAttribute1);
            //信托机构id
            Integer trustAgencyId = contract.getTrustAgencyId();
            NplmTrustAgency nplmTrustAgency =
                    nplmTrustAgencyMapper.selectById(trustAgencyId);
            contract.setNplmTrustAgency(nplmTrustAgency);
            //信托计划id
            Integer trustPlanId = contract.getTrustPlanId();
            NplmTrustPlan nplmTrustPlan = nplmTrustPlanMapper.selectById(trustPlanId);
            contract.setNplmTrustPlan(nplmTrustPlan);
            //信托产品系列
            Integer trustSeriesId = contract.getTrustSeriesId();
            NplmTrustSeries nplmTrustSeries = nplmTrustSeriesMapper.selectById(trustSeriesId);
            contract.setNplmTrustSeries(nplmTrustSeries);
            //贷款品种
            Integer loanVarietyId = contract.getLoanVarietyId();
            NplmLoanVariety nplmLoanVariety = nplmLoanVarietyMapper.selectById(loanVarietyId);
            contract.setNplmLoanVariety(nplmLoanVariety);
        }
    }
}
