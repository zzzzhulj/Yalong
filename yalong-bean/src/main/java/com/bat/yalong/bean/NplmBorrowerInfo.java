package com.bat.yalong.bean;


import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;


/**
 * 客户_借款人信息
 */
@TableName("nplm_borrower_info")
public class NplmBorrowerInfo implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;//'客户编号',
    private Integer applyClientId;//'进件客户编号',
    private Integer ecifId;//'ECIF客户号',
    private String clientName;//'客户姓名',
    private String mobile;////'发短信移动电话',
    private String oldName;//'曾用名',
    private String sex;
    private String nation;
    private String birthday;
    private String marital;//'婚姻状况',
    private Integer haveChildren;//'有无子女 1为没有，2为有'
    private Integer childrenCount;
    private String nationality;//'国籍',
    private String hProvince;//'户籍所在省',
    private String hCity;
    private String hDress;//'户籍所在地',
    private String identityType;//'证件类型',
    private String identityNum;//'证件号码',
    private String identityValidDate;//'证件有效期限',
    private String haveCar;//'有无车产 Y:有  N:无',
    private String houseExplain;//'房产情况',
    private String resideExplain;// '居住情况',
    private String resideYear;//'居住年限',
    private String degree;//'学历'
    private String diploma;//'学位',
    private Integer yearIncome;//'年收入',
    private String industry;//'行业',
    private String job;//'职业',
    private String company;//'公司名称',
    private String companyType;//'单位性质',
    private String department;//'所在部门',
    private String position;//'职位',
    private Integer workTime;//'该单位工作时间',
    private String workTimeUnit;//该单位工作时间单位',
    private String clientArea;//'客户所在地域',
    private String clientType;//'客户类型',
    private String fNation;// '家庭地址_国家',
    private String fProvince;//'家庭地址_省州',
    private String fCity;//'家庭地址_城市',
    private String fArea;//'家庭地址_区县',
    private String fStreet;// '家庭地址_街道单元'
    private String fZipcode;//家庭地址_邮政编码',
    private String cNation;//'公司地址_国家',
    private String cProvince;//'公司地址_省州'
    private String cCity;//'公司地址_城市',
    private String cArea;//'公司地址_区县
    private String cStreet;//'公司地址_街道单元',
    private String cZipcode;//公司地址_邮政编码',
    private String mobile1;
    private String mobile2;
    private String mobile3;
    private String fTel1;
    private String fTel2;
    private String fTel3;
    private String cTel1;
    private String cTel2;
    private String cTel3;
    private String email1;
    private String email2;
    private String email3;
    private Integer creditAmount;//'信用卡额度',
    private String sociallSecurity;//'是否拥有社保基金 Y：有  N：无',
    private String creator;
    private String updater;
    private String updateType;
    private Date createTime;
    private Date updateTIme;


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTIme() {
        return updateTIme;
    }

    public void setUpdateTIme(Date updateTIme) {
        this.updateTIme = updateTIme;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getApplyClientId() {
        return applyClientId;
    }

    public void setApplyClientId(Integer applyClientId) {
        this.applyClientId = applyClientId;
    }

    public Integer getEcifId() {
        return ecifId;
    }

    public void setEcifId(Integer ecifId) {
        this.ecifId = ecifId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMarital() {
        return marital;
    }

    public void setMarital(String marital) {
        this.marital = marital;
    }

    public Integer getHaveChildren() {
        return haveChildren;
    }

    public void setHaveChildren(Integer haveChildren) {
        this.haveChildren = haveChildren;
    }

    public Integer getChildrenCount() {
        return childrenCount;
    }

    public void setChildrenCount(Integer childrenCount) {
        this.childrenCount = childrenCount;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String gethProvince() {
        return hProvince;
    }

    public void sethProvince(String hProvince) {
        this.hProvince = hProvince;
    }

    public String gethCity() {
        return hCity;
    }

    public void sethCity(String hCity) {
        this.hCity = hCity;
    }

    public String gethDress() {
        return hDress;
    }

    public void sethDress(String hDress) {
        this.hDress = hDress;
    }

    public String getIdentityType() {
        return identityType;
    }

    public void setIdentityType(String identityType) {
        this.identityType = identityType;
    }

    public String getIdentityNum() {
        return identityNum;
    }

    public void setIdentityNum(String identityNum) {
        this.identityNum = identityNum;
    }

    public String getIdentityValidDate() {
        return identityValidDate;
    }

    public void setIdentityValidDate(String identityValidDate) {
        this.identityValidDate = identityValidDate;
    }

    public String getHaveCar() {
        return haveCar;
    }

    public void setHaveCar(String haveCar) {
        this.haveCar = haveCar;
    }

    public String getHouseExplain() {
        return houseExplain;
    }

    public void setHouseExplain(String houseExplain) {
        this.houseExplain = houseExplain;
    }

    public String getResideExplain() {
        return resideExplain;
    }

    public void setResideExplain(String resideExplain) {
        this.resideExplain = resideExplain;
    }

    public String getResideYear() {
        return resideYear;
    }

    public void setResideYear(String resideYear) {
        this.resideYear = resideYear;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public Integer getYearIncome() {
        return yearIncome;
    }

    public void setYearIncome(Integer yearIncome) {
        this.yearIncome = yearIncome;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public String getWorkTimeUnit() {
        return workTimeUnit;
    }

    public void setWorkTimeUnit(String workTimeUnit) {
        this.workTimeUnit = workTimeUnit;
    }

    public String getClientArea() {
        return clientArea;
    }

    public void setClientArea(String clientArea) {
        this.clientArea = clientArea;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getfNation() {
        return fNation;
    }

    public void setfNation(String fNation) {
        this.fNation = fNation;
    }

    public String getfProvince() {
        return fProvince;
    }

    public void setfProvince(String fProvince) {
        this.fProvince = fProvince;
    }

    public String getfCity() {
        return fCity;
    }

    public void setfCity(String fCity) {
        this.fCity = fCity;
    }

    public String getfArea() {
        return fArea;
    }

    public void setfArea(String fArea) {
        this.fArea = fArea;
    }

    public String getfStreet() {
        return fStreet;
    }

    public void setfStreet(String fStreet) {
        this.fStreet = fStreet;
    }

    public String getfZipcode() {
        return fZipcode;
    }

    public void setfZipcode(String fZipcode) {
        this.fZipcode = fZipcode;
    }

    public String getcNation() {
        return cNation;
    }

    public void setcNation(String cNation) {
        this.cNation = cNation;
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince;
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity;
    }

    public String getcArea() {
        return cArea;
    }

    public void setcArea(String cArea) {
        this.cArea = cArea;
    }

    public String getcStreet() {
        return cStreet;
    }

    public void setcStreet(String cStreet) {
        this.cStreet = cStreet;
    }

    public String getcZipcode() {
        return cZipcode;
    }

    public void setcZipcode(String cZipcode) {
        this.cZipcode = cZipcode;
    }

    public String getMobile1() {
        return mobile1;
    }

    public void setMobile1(String mobile1) {
        this.mobile1 = mobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getMobile3() {
        return mobile3;
    }

    public void setMobile3(String mobile3) {
        this.mobile3 = mobile3;
    }

    public String getfTel1() {
        return fTel1;
    }

    public void setfTel1(String fTel1) {
        this.fTel1 = fTel1;
    }

    public String getfTel2() {
        return fTel2;
    }

    public void setfTel2(String fTel2) {
        this.fTel2 = fTel2;
    }

    public String getfTel3() {
        return fTel3;
    }

    public void setfTel3(String fTel3) {
        this.fTel3 = fTel3;
    }

    public String getcTel1() {
        return cTel1;
    }

    public void setcTel1(String cTel1) {
        this.cTel1 = cTel1;
    }

    public String getcTel2() {
        return cTel2;
    }

    public void setcTel2(String cTel2) {
        this.cTel2 = cTel2;
    }

    public String getcTel3() {
        return cTel3;
    }

    public void setcTel3(String cTel3) {
        this.cTel3 = cTel3;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getEmail3() {
        return email3;
    }

    public void setEmail3(String email3) {
        this.email3 = email3;
    }

    public Integer getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Integer creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getSociallSecurity() {
        return sociallSecurity;
    }

    public void setSociallSecurity(String sociallSecurity) {
        this.sociallSecurity = sociallSecurity;
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
