package com.bat.yalong.bean;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("repayment_details")
public class RepaymentDetails implements Serializable {

  @TableId(type = IdType.AUTO)
  private Integer id;
  private Integer repaymentPlanId;
  private Integer repaymentRecordId;
  private String loanContractNum;
  private java.sql.Date repaymentData;
  private Integer repaymentMoney;
  private String repaymentBank;
  private String repaymentType;
  private String repaymentAccount;
  private java.sql.Date repaymentConfirmDate;
  private String toAccount;
  private String iscard;


  public String getLoanContractNum() {
    return loanContractNum;
  }

  public void setLoanContractNum(String loanContractNum) {
    this.loanContractNum = loanContractNum;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getRepaymentPlanId() {
    return repaymentPlanId;
  }

  public void setRepaymentPlanId(Integer repaymentPlanId) {
    this.repaymentPlanId = repaymentPlanId;
  }


  public Integer getRepaymentRecordId() {
    return repaymentRecordId;
  }

  public void setRepaymentRecordId(Integer repaymentRecordId) {
    this.repaymentRecordId = repaymentRecordId;
  }


  public java.sql.Date getRepaymentData() {
    return repaymentData;
  }

  public void setRepaymentData(java.sql.Date repaymentData) {
    this.repaymentData = repaymentData;
  }


  public Integer getRepaymentMoney() {
    return repaymentMoney;
  }

  public void setRepaymentMoney(Integer repaymentMoney) {
    this.repaymentMoney = repaymentMoney;
  }


  public String getRepaymentBank() {
    return repaymentBank;
  }

  public void setRepaymentBank(String repaymentBank) {
    this.repaymentBank = repaymentBank;
  }


  public String getRepaymentType() {
    return repaymentType;
  }

  public void setRepaymentType(String repaymentType) {
    this.repaymentType = repaymentType;
  }

  public String getRepaymentAccount() {
    return repaymentAccount;
  }

  public void setRepaymentAccount(String repaymentAccount) {
    this.repaymentAccount = repaymentAccount;
  }


  public java.sql.Date getRepaymentConfirmDate() {
    return repaymentConfirmDate;
  }

  public void setRepaymentConfirmDate(java.sql.Date repaymentConfirmDate) {
    this.repaymentConfirmDate = repaymentConfirmDate;
  }


  public String getToAccount() {
    return toAccount;
  }

  public void setToAccount(String toAccount) {
    this.toAccount = toAccount;
  }


  public String getIscard() {
    return iscard;
  }

  public void setIscard(String iscard) {
    this.iscard = iscard;
  }

}
