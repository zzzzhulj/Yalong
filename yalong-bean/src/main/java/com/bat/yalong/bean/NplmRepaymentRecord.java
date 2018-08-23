package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;


/**
 *  还款_还款记录表
 */
@TableName("NPLM_repayment_record")
public class NplmRepaymentRecord implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer businessRequestId;//业务请求id
    private Integer loanContractNum;//合同编号
    private Date repaymentDate;//还款请求日期
    private Integer overdueDays;//逾期天数
    private Integer overdueAmount;//逾期总金额
    private Integer repaymentAmount;//扣款金额
    private Integer successAmount;//成功金额
    /**
     *   0	处理中
     *             1	成功
     *             2	失败
     *             3	部分成功
     *             4	已撤销
     *             5              不执行
     */
    private String status;//还款状态
    private String remark;
    private String specialCode;
    private Integer sort;
    @TableField(exist = false)
    private DataCreateType dataCreateType;
    private Integer dataCreateTypeId;


    private String creator;
    private String updater;
    private String accountName;//账户姓名
    private String acctIdenType;//账户证件类型
    private String acctIdenNum;//账户证件号
    private String accountNo;//账户
    private String accountType;//账户卡折标识
    private String accountBankid;//账户银行
    private String accountBranchNo;//开户行行号
    private String accountBankName;//开户行名称
    private String publicPrivate;//对公对私标识
    private String actProvince;//开户省
    private String accountCity;//开户市
    private String updateType;
    private Timestamp reserveTime;

    public Timestamp getReserveTime() {
        return reserveTime;
    }

    public void setReserveTime(Timestamp reserveTime) {
        this.reserveTime = reserveTime;
    }

    private Timestamp createTime;
    private Timestamp updateTime;

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public DataCreateType getDataCreateType() {
        return dataCreateType;
    }

    public void setDataCreateType(DataCreateType dataCreateType) {
        this.dataCreateType = dataCreateType;
    }

    public Integer getDataCreateTypeId() {
        return dataCreateTypeId;
    }

    public void setDataCreateTypeId(Integer dataCreateTypeId) {
        this.dataCreateTypeId = dataCreateTypeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBusinessRequestId() {
        return businessRequestId;
    }

    public void setBusinessRequestId(Integer businessRequestId) {
        this.businessRequestId = businessRequestId;
    }

    public Integer getLoanContractNum() {
        return loanContractNum;
    }

    public void setLoanContractNum(Integer loanContractNum) {
        this.loanContractNum = loanContractNum;
    }

    public Date getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(Date repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Integer getOverdueAmount() {
        return overdueAmount;
    }

    public void setOverdueAmount(Integer overdueAmount) {
        this.overdueAmount = overdueAmount;
    }

    public Integer getRepaymentAmount() {
        return repaymentAmount;
    }

    public void setRepaymentAmount(Integer repaymentAmount) {
        this.repaymentAmount = repaymentAmount;
    }

    public Integer getSuccessAmount() {
        return successAmount;
    }

    public void setSuccessAmount(Integer successAmount) {
        this.successAmount = successAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSpecialCode() {
        return specialCode;
    }

    public void setSpecialCode(String specialCode) {
        this.specialCode = specialCode;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
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

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAcctIdenType() {
        return acctIdenType;
    }

    public void setAcctIdenType(String acctIdenType) {
        this.acctIdenType = acctIdenType;
    }

    public String getAcctIdenNum() {
        return acctIdenNum;
    }

    public void setAcctIdenNum(String acctIdenNum) {
        this.acctIdenNum = acctIdenNum;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountBankid() {
        return accountBankid;
    }

    public void setAccountBankid(String accountBankid) {
        this.accountBankid = accountBankid;
    }

    public String getAccountBranchNo() {
        return accountBranchNo;
    }

    public void setAccountBranchNo(String accountBranchNo) {
        this.accountBranchNo = accountBranchNo;
    }

    public String getAccountBankName() {
        return accountBankName;
    }

    public void setAccountBankName(String accountBankName) {
        this.accountBankName = accountBankName;
    }

    public String getPublicPrivate() {
        return publicPrivate;
    }

    public void setPublicPrivate(String publicPrivate) {
        this.publicPrivate = publicPrivate;
    }

    public String getActProvince() {
        return actProvince;
    }

    public void setActProvince(String actProvince) {
        this.actProvince = actProvince;
    }

    public String getAccountCity() {
        return accountCity;
    }

    public void setAccountCity(String accountCity) {
        this.accountCity = accountCity;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
}
