package com.bat.yalong.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.bat.yalong.bean.*;
import com.bat.yalong.manage.service.ManageService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("searchNplmRepaymentDetailAjax")
    @ResponseBody
    public Object searchNplmRepaymentDetailAjax(String loanContractNum,HttpServletRequest request){
        List<NplmRepaymentDetail> nplmRepaymentDetails = manageService.getNplmRepaymentDetailByNum(loanContractNum);
        return nplmRepaymentDetails;
    }

    @RequestMapping("/smp")
    public String smp(){
        return "smp";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }


    @RequestMapping("common/查看还款情况页面.html")
    public String getRePaymentPage(String loanContractNum,HttpServletRequest request){
        NplmRepaymentPlan nplmRepaymentPlan = manageService.getRepaymentPlan(loanContractNum);
        request.setAttribute("nplmRepaymentPlan", nplmRepaymentPlan);

        NplmLoanContract nplmLoanContract = manageService.getLoanContractByNum(loanContractNum);
        String clientName = nplmLoanContract.getClientName();
        request.setAttribute("clientName", clientName);
        request.setAttribute("nplmLoanContract", nplmLoanContract);
        String borrowerId = nplmLoanContract.getBorrowerId();
        NplmBorrowerInfo borrowerInfo = manageService.getNplmBorrowerById(borrowerId);

        String contractType = nplmLoanContract.getContractType();
        switch (contractType){
            case "-1":
                request.setAttribute("contractType", "合同废址");
                break;
            case "0":
                request.setAttribute("contractType", "未放款");
                break;
            case "1":
                request.setAttribute("contractType", "还款中");
                break;
            case "2":
                request.setAttribute("contractType", "逾期");
                break;
            case "9":
                request.setAttribute("contractType", "正常还清");
                break;
        }
        List<NplmRepaymentDetail> nplmRepaymentDetails = manageService.getNplmRepaymentDetailByNum(loanContractNum);
        request.setAttribute("repaymentTime", nplmRepaymentDetails.size()-1);
        request.setAttribute("nplmBorrowerInfo", borrowerInfo);
        NplmOverdueContract nplmOverdueContract = manageService.getNplmOverdueContractByNum(loanContractNum);
        request.setAttribute("nplmOverdueContract", nplmOverdueContract);

        List<RepaymentDetails> repaymentDetailsList = manageService.getRepaymentDetails(loanContractNum);
        request.setAttribute("repaymentDetailsList", repaymentDetailsList);

        return "common/查看还款情况页面";
    }

    @RequestMapping("common/修改还款情况页面.html")
    public String updateRePayment(){

        return "common/修改还款情况页面";
    }

    @RequestMapping("/searchRepaymentDetailAjax")
    @ResponseBody
    public Object searchRepaymentDetailAjax(String loanContractNum,HttpServletRequest request){
       List<RepaymentDetails> repaymentDetailsList = manageService.getRepaymentDetails(loanContractNum);
        request.setAttribute("repaymentDetailsList", repaymentDetailsList);

       return repaymentDetailsList;
    }

    @RequestMapping(value = "searchLoanContract")
    public String searchLoanContract(NplmLoanContract nplmLoanContract,HttpServletRequest request){
        Page<NplmLoanContract> allLoanContractPage = null;
        allLoanContractPage = manageService.searchLoanContract(nplmLoanContract,1,10);

        List<NplmLoanContract> nplmLoanContracts = allLoanContractPage.getRecords();
        request.setAttribute("nplmLoanContracts", nplmLoanContracts);
        return "合同列表/合同列表";
    }

    @RequestMapping(value = "searchLoanContractAjax")
    @ResponseBody
    public Object searchLoanContractAjax(NplmLoanContract nplmLoanContract,HttpServletRequest request){
        Page<NplmLoanContract> allLoanContractPage = null;
        String page = request.getParameter("pageNum")==null?"1":request.getParameter("pageNum");
        String rows = request.getParameter("rows");
        //调用服务 根据分页参数 查询条件参数等查询
        allLoanContractPage = manageService.searchLoanContract(nplmLoanContract,Integer.parseInt(page),Integer.parseInt(rows));

        //查询的数据封装在allLoanContractPage 对象里 这里取出
        List<NplmLoanContract> nplmLoanContractList = allLoanContractPage.getRecords();

        List<Map> nplmLoanContracs = new ArrayList<>();

        //遍历每一个对象 将所有用到的数据封装为一个map
        for (NplmLoanContract loanContract : nplmLoanContractList) {
            Map<String,Object> map = new HashMap<>();
            BeanInfo beanInfo = null;
            try {
                beanInfo = Introspector.getBeanInfo(NplmLoanContract.class, Object.class);
                //获取所有的属性描述器
                PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
                for(PropertyDescriptor pd:pds){
                    String key = pd.getName();
                    Method getter = pd.getReadMethod();
                    Object value = getter.invoke(loanContract);
                    map.put(key, value);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            String contractType = loanContract.getContractType();
            switch (contractType){
                case "-1":
                    map.put("contractType", "合同废址");
                    break;
                case "0":
                    map.put("contractType", "未放款");
                    break;
                case "1":
                    map.put("contractType", "还款中");
                    break;
                case "2":
                    map.put("contractType", "逾期");
                    break;
                case "9":
                    map.put("contractType", "正常还清");
                    break;

            }

            String identityType = loanContract.getNplmBorrowerInfo().getIdentityType();
            map.put("identityType", identityType);
            String varietyName = loanContract.getNplmLoanVariety().getVarietyName();
            map.put("varietyName", varietyName);
            String businessType = loanContract.getNplmContractAttribute().getBusinessType();

            switch (businessType){
                case "1":
                    map.put("businessType", "信托");
                    break;
                case "2":
                    map.put("businessType", "转债权");
                    break;
                case "3":
                    map.put("businessType", "融资租赁");
                    break;
                case "4":
                    map.put("businessType", "火凤凰");
                    break;
                case "5":
                    map.put("businessType", "互联网");
                    break;
            }

            String agencyName = loanContract.getNplmTrustAgency().getAgencyName();
            map.put("agencyName", agencyName);

            String trustPlanName = loanContract.getNplmTrustPlan().getTrustPlanName();
            map.put("trustPlanName", trustPlanName);

            String trustSeriesName = loanContract.getNplmTrustSeries().getTrustSeriesName();
            map.put("trustSeriesName", trustSeriesName);

            String isExpedited = loanContract.getNplmContractAttribute().getIsExpedited();
            map.put("isExpedited", isExpedited);

            Integer signType = loanContract.getNplmContractAttribute().getSignType();
            switch (signType){
                case 1:
                    map.put("signType", "纸质");
                    break;
                case 2:
                    map.put("signType", "电子签约");
                    break;
            }

            String changeMoney = loanContract.getNplmContractAttribute().getChangeMoney();
            map.put("changeMoney", changeMoney);

            String isRecycleLoad = loanContract.getNplmContractAttribute().getIsRecycleLoad();
            map.put("isRecycleLoad", isRecycleLoad);

            Integer recycleLoanCnt = loanContract.getNplmContractAttribute().getRecycleLoanCnt();
            map.put("recycleLoanCnt", recycleLoanCnt);

            String settleDate = loanContract.getNplmContractAttribute().getSettleDate();
            map.put("settleDate", settleDate);

            nplmLoanContracs.add(map);
        }

        //再定义一个返回的map对象设置参数  easyui根据rows 和 total 给表格和分页插件注入相应的值
        Map reMap = new HashedMap();
        reMap.put("rows", nplmLoanContracs);
        reMap.put("total", allLoanContractPage.getTotal());
        return reMap;
    }

}
