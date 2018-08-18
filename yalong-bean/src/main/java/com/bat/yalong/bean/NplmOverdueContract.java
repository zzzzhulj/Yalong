package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

//NPLM_OVERDUE_CONTRACT

/**
 * 还款_逾期合同表
 */
@TableName("NPLM_OVERDUE_CONTRACT")
public class NplmOverdueContract implements Serializable {

    @TableId(type = IdType.ID_WORKER_STR)
    private String id;
    private String loanContractNum;
    private String overdueStatus;
    private Date overdueDays;
    private Integer instalmentCnt;
    private Integer allDays;
    private Integer allInstalmentCnt;
    private Integer allNumber;
    private Integer principalInterest;
    private Integer allForfeit;
    private Integer allAmerce;
    private Integer allShould;
    private Integer allIndeed;
    private Integer currentRepay;
    private Integer allRepaymentAmount;
    private String firstDate;
    private String startDate;
    private String serialStartDate;
    private String overdueHistory;
    private String computeDate;
    private String creator;
    private String updater;
    private String updateType;

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

    public Date getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Date overdueDays) {
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

    public String getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(String firstDate) {
        this.firstDate = firstDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getSerialStartDate() {
        return serialStartDate;
    }

    public void setSerialStartDate(String serialStartDate) {
        this.serialStartDate = serialStartDate;
    }

    public String getOverdueHistory() {
        return overdueHistory;
    }

    public void setOverdueHistory(String overdueHistory) {
        this.overdueHistory = overdueHistory;
    }

    public String getComputeDate() {
        return computeDate;
    }

    public void setComputeDate(String computeDate) {
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
