package com.bat.yalong.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bat.yalong.bean.NplmLoanContract;
import com.bat.yalong.manage.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManageController {

    @Reference
    private ManageService manageService;

    @RequestMapping("/smp")
    public String smp(){
        return "smp";
    }

    @RequestMapping("合同列表/合同列表")
    public String getHeTongList(){
        return "合同列表/合同列表";
    }


    @RequestMapping("text")
    @ResponseBody
    public Object text(Integer id){
        NplmLoanContract nplmLoanContract = manageService.getLoanContract(id);
        return nplmLoanContract;
    }

}
