package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

//NPLM_OVERDUE_CONTRACT

/**
 * 还款_逾期合同表
 */
@TableName("NPLM_OVERDUE_CONTRACT")
public class NplmOverdueContract implements Serializable {

    @TableId(type = IdType.AUTO)
    private String id;
    private String loanContractNum;//合同编号
    private String overdueStatus;//逾期状态 2 逾期 9正常还清
    private Integer overdueDays;//现存逾期天数
    private Integer instalmentCnt;//现存逾期期数
    private Integer allDays;//总逾期天数
    private Integer allInstalmentCnt;//总逾期期数
    private Integer allNumber;//累计逾期天数
    private Integer principalInterest;//尚欠本息
    private Integer allForfeit;//滞纳总金额
    private Integer allAmerce;//罚息总额
    private Integer allShould;//累计应收款
    private Integer allIndeed;//累计实收款
    private Integer currentRepay;//当期应还总金额
    private Integer allRepaymentAmount;//一次性结清金额
    private Date firstDate;//首次逾期日期
    private Date startDate;//现存逾期开始日期
    private Date serialStartDate;//首次出现连续逾期的开始日期
    private String overdueHistory;//过去18个月逾期历史
    private Date computeDate;//计算违约日期
    private String creator;
    private String updater;
    private String updateType;
    private Timestamp createTime;
    private Timestamp updateTime;

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

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

    public String getOverdueStatus() {
        return overdueStatus;
    }

    public void setOverdueStatus(String overdueStatus) {
        this.overdueStatus = overdueStatus;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Integer getInstalmentCnt() {
        return instalmentCnt;
    }

    public void setInstalmentCnt(Integer instalmentCnt) {
        this.instalmentCnt = instalmentCnt;
    }

    public Integer getAllDays() {
        return allDays;
    }

    public void setAllDays(Integer allDays) {
        this.allDays = allDays;
    }

    public Integer getAllInstalmentCnt() {
        return allInstalmentCnt;
    }

    public void setAllInstalmentCnt(Integer allInstalmentCnt) {
        this.allInstalmentCnt = allInstalmentCnt;
    }

    public Integer getAllNumber() {
        return allNumber;
    }

    public void setAllNumber(Integer allNumber) {
        this.allNumber = allNumber;
    }

    public Integer getPrincipalInterest() {
        return principalInterest;
    }

    public void setPrincipalInterest(Integer principalInterest) {
        this.principalInterest = principalInterest;
    }

    public Integer getAllForfeit() {
        return allForfeit;
    }

    public void setAllForfeit(Integer allForfeit) {
        this.allForfeit = allForfeit;
    }

    public Integer getAllAmerce() {
        return allAmerce;
    }

    public void setAllAmerce(Integer allAmerce) {
        this.allAmerce = allAmerce;
    }

    public Integer getAllShould() {
        return allShould;
    }

    public void setAllShould(Integer allShould) {
        this.allShould = allShould;
    }

    public Integer getAllIndeed() {
        return allIndeed;
    }

    public void setAllIndeed(Integer allIndeed) {
        this.allIndeed = allIndeed;
    }

    public Integer getCurrentRepay() {
        return currentRepay;
    }

    public void setCurrentRepay(Integer currentRepay) {
        this.currentRepay = currentRepay;
    }

    public Integer getAllRepaymentAmount() {
        return allRepaymentAmount;
    }

    public void setAllRepaymentAmount(Integer allRepaymentAmount) {
        this.allRepaymentAmount = allRepaymentAmount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getSerialStartDate() {
        return serialStartDate;
    }

    public void setSerialStartDate(Date serialStartDate) {
        this.serialStartDate = serialStartDate;
    }

    public String getOverdueHistory() {
        return overdueHistory;
    }

    public void setOverdueHistory(String overdueHistory) {
        this.overdueHistory = overdueHistory;
    }

    public Date getComputeDate() {
        return computeDate;
    }

    public void setComputeDate(Date computeDate) {
        this.computeDate = computeDate;
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

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }
}
