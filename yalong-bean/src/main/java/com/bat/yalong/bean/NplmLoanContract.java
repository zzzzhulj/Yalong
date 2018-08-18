package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;


/**
 * 借款合同
 */
@TableName("NPLM_loan_contract")
public class NplmLoanContract implements Serializable {

    @TableId(type = IdType.ID_WORKER)
    private String id;
    private String loanContractNum;//'合同编号'
    private String borrowerId;//'借款人id',
    private String ecifId;//'ECIF客户号',
    private String proCategoryCode;//'产品分类代码',
    private String proCategoryName;//'产品分类名称',
    private Integer productInfoId;//'产品信息id',
    private Integer loanInstalments;//'贷款分期数',
    private String loanInstalmentUnit;//'贷款分期单位',
    private Integer loanAmount;//'贷款金额',
    private Integer preFee;// '前期费用',
    private Integer putAmount;// '放款金额'
    private Date putTime;//放款日期

    public Date getPutTime() {
        return putTime;
    }

    public void setPutTime(Date putTime) {
        this.putTime = putTime;
    }

    public Integer getTrustPlanId() {
        return trustPlanId;
    }

    public void setTrustPlanId(Integer trustPlanId) {
        this.trustPlanId = trustPlanId;
    }

    private String creditType;//'贷款形式 1为信用，2为担保，3为抵押，4为其他',
    private String payMod;//'支付方式 THIRD:第三方渠道  BANK:银行渠道',

    /**
     * '还款方式
     *             01-等额本息
     *             02-等额本金
     *             03-等本等息
     *             04-付息通
     *             05-一次性还本付息
     *             06-等比累进
     *             07-等额累进
     *             08-0+N
     *             09-分阶段还款',
     */
    private String repayWay;

    /**
     * '放款模式：
     * 1:差额放款
     * 2:先放款后收费
     * 3:先收费后放款
     * 4:先放款后收费（线下收取前期费用）',
     */
    private String loanType;
    private Integer saleDepartmentId;//销售部门id',
    private String repayAccountName;//'还款账户姓名',
    private String repayAcctIdenType;//'还款账户证件类型',
    private String repayAcctIdenNum;//'还款账户证件号',
    private String repayAccount;//'还款账户',
    private String repayAccountType;//还款账户卡折标识',
    private String repayAccountBankid;//'还款账户银行行别'
    private String repayActBranchNo;//'还款账户开户行行号(支付行号)',
    private String repayAccountBankName;//'还款账户开户行名称',
    private String publicPrivate;//'还款账户对公对私标识',
    private String repayActProvince;// '还款账户开户省',
    private String repayAccountCity;//'还款账户开户市',
    private String posStatus;//'POS验证状态 未验证 0014 已验证为空',
    private Date startDate;//'首期还款日',
    private Date endDate;// '末期还款日',
    /**
     * '合同来源：
     *             NPLM_ICMP	综合信贷
     *             NPLM_RZZL	融资租赁
     *             NPLM_CDXT	车贷系统
     *             NPLM_FDXT	房贷系统
     */
    private String contractSource;

    /**
     * 贷款品种Id
     * { id: 1, text: '新薪贷' },
     *        { id: 2, text: '学信通' },
     *    { id: 3, text: '精英贷' },
     *    { id: 4, text: '助学贷' },
     *    { id: 5, text: '助业贷' },
     *    { id: 6, text: '助业宜楼贷' },
     *    { id: 7, text: '新薪宜楼贷' },
     *    { id: 8, text: '学历贷' },
     *    { id: 9, text: '宜商贷' },
     *    { id: 10, text: '宜车贷' },
     *    { id: 11, text: '小企业贷' },
     *    { id: 12, text: '房贷' },
     *    { id: 13, text: '慧聪（高级）' },
     *    { id: 14, text: '慧聪（三年）' },
     *    { id: 15, text: '慧聪（普通）' }
     */
    private Integer loanVarietyId;

    public Integer getLoanVarietyId() {
        return loanVarietyId;
    }

    public void setLoanVarietyId(Integer loanVarietyId) {
        this.loanVarietyId = loanVarietyId;
    }

    private Integer repayBalance;//'未分配还款额',

    /**
     * '合同状态:
     *  -1：合同废止
     *  0：未放款，
     *  1：还款中，
     *  2：逾期，
     *  9：正常还清，
     *  10：合同终止，
     *  11：合同核销，
     *  12：减免结清，
     *  13：特殊减免结清，
     *  14：提前结清，
     *  15：放款退回结清',
     */
    private String contractType;
    /**
     * 信托机构Id
     * 1 中航信托
     * 2 华澳华宜
     */
    private Integer trustAgencyId;

    /**
     * 信托产品系列Id
     * 1.天宜
     * 2.天惠
     * 3.天驰
     */
    private Integer trustSeriesId;

    /**
     * 信托计划Id：
     *
     */
    private Integer trustPlanId;

    public Integer getTrustSeriesId() {
        return trustSeriesId;
    }

    public void setTrustSeriesId(Integer trustSeriesId) {
        this.trustSeriesId = trustSeriesId;
    }

    public Integer getTrustAgencyId() {
        return trustAgencyId;
    }

    public void setTrustAgencyId(Integer trustAgencyId) {
        this.trustAgencyId = trustAgencyId;
    }

    private String creator;//'创建者',
    private String updater;//'末次修改者',
    private String remark;//'备注',
    private String cycleCreditId;//'循环授信编号',
    private String updateType;//'修改类型',
    private Date createTime;
    private Date updateTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanContractNum() {
        return loanContractNum;
    }

    public void setLoanContractNum(String loanContractNum) {
        this.loanContractNum = loanContractNum;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getEcifId() {
        return ecifId;
    }

    public void setEcifId(String ecifId) {
        this.ecifId = ecifId;
    }

    public String getProCategoryCode() {
        return proCategoryCode;
    }

    public void setProCategoryCode(String proCategoryCode) {
        this.proCategoryCode = proCategoryCode;
    }

    public String getProCategoryName() {
        return proCategoryName;
    }

    public void setProCategoryName(String proCategoryName) {
        this.proCategoryName = proCategoryName;
    }

    public Integer getProductInfoId() {
        return productInfoId;
    }

    public void setProductInfoId(Integer productInfoId) {
        this.productInfoId = productInfoId;
    }

    public Integer getLoanInstalments() {
        return loanInstalments;
    }

    public void setLoanInstalments(Integer loanInstalments) {
        this.loanInstalments = loanInstalments;
    }

    public String getLoanInstalmentUnit() {
        return loanInstalmentUnit;
    }

    public void setLoanInstalmentUnit(String loanInstalmentUnit) {
        this.loanInstalmentUnit = loanInstalmentUnit;
    }

    public Integer getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(Integer loanAmount) {
        this.loanAmount = loanAmount;
    }

    public Integer getPreFee() {
        return preFee;
    }

    public void setPreFee(Integer preFee) {
        this.preFee = preFee;
    }

    public Integer getPutAmount() {
        return putAmount;
    }

    public void setPutAmount(Integer putAmount) {
        this.putAmount = putAmount;
    }

    public String getCreditType() {
        return creditType;
    }

    public void setCreditType(String creditType) {
        this.creditType = creditType;
    }

    public String getPayMod() {
        return payMod;
    }

    public void setPayMod(String payMod) {
        this.payMod = payMod;
    }

    public String getRepayWay() {
        return repayWay;
    }

    public void setRepayWay(String repayWay) {
        this.repayWay = repayWay;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public Integer getSaleDepartmentId() {
        return saleDepartmentId;
    }

    public void setSaleDepartmentId(Integer saleDepartmentId) {
        this.saleDepartmentId = saleDepartmentId;
    }

    public String getRepayAccountName() {
        return repayAccountName;
    }

    public void setRepayAccountName(String repayAccountName) {
        this.repayAccountName = repayAccountName;
    }

    public String getRepayAcctIdenType() {
        return repayAcctIdenType;
    }

    public void setRepayAcctIdenType(String repayAcctIdenType) {
        this.repayAcctIdenType = repayAcctIdenType;
    }

    public String getRepayAcctIdenNum() {
        return repayAcctIdenNum;
    }

    public void setRepayAcctIdenNum(String repayAcctIdenNum) {
        this.repayAcctIdenNum = repayAcctIdenNum;
    }

    public String getRepayAccount() {
        return repayAccount;
    }

    public void setRepayAccount(String repayAccount) {
        this.repayAccount = repayAccount;
    }

    public String getRepayAccountType() {
        return repayAccountType;
    }

    public void setRepayAccountType(String repayAccountType) {
        this.repayAccountType = repayAccountType;
    }

    public String getRepayAccountBankid() {
        return repayAccountBankid;
    }

    public void setRepayAccountBankid(String repayAccountBankid) {
        this.repayAccountBankid = repayAccountBankid;
    }

    public String getRepayActBranchNo() {
        return repayActBranchNo;
    }

    public void setRepayActBranchNo(String repayActBranchNo) {
        this.repayActBranchNo = repayActBranchNo;
    }

    public String getRepayAccountBankName() {
        return repayAccountBankName;
    }

    public void setRepayAccountBankName(String repayAccountBankName) {
        this.repayAccountBankName = repayAccountBankName;
    }

    public String getPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(String publicPrivate) {
        this.publicPrivate = publicPrivate;
    }

    public String getRepayActProvince() {
        return repayActProvince;
    }

    public void setRepayActProvince(String repayActProvince) {
        this.repayActProvince = repayActProvince;
    }

    public String getRepayAccountCity() {
        return repayAccountCity;
    }

    public void setRepayAccountCity(String repayAccountCity) {
        this.repayAccountCity = repayAccountCity;
    }

    public String getPosStatus() {
        return posStatus;
    }

    public void setPosStatus(String posStatus) {
        this.posStatus = posStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getContractSource() {
        return contractSource;
    }

    public void setContractSource(String contractSource) {
        this.contractSource = contractSource;
    }

    public Integer getRepayBalance() {
        return repayBalance;
    }

    public void setRepayBalance(Integer repayBalance) {
        this.repayBalance = repayBalance;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCycleCreditId() {
        return cycleCreditId;
    }

    public void setCycleCreditId(String cycleCreditId) {
        this.cycleCreditId = cycleCreditId;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
}
