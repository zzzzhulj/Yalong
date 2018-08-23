package com.bat.yalong.manage.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.bat.yalong.bean.*;

import java.util.List;

public interface ManageService {

    NplmLoanContract getLoanContract(Integer id);

    Page<NplmLoanContract> getAllLoanContractPage();

    Page<NplmLoanContract> searchLoanContract(NplmLoanContract nplmLoanContract,Integer current,Integer pageSize);

    NplmRepaymentPlan getRepaymentPlan(String loanContractNum);

    NplmLoanContract getLoanContractByNum(String loanContractNum);

    NplmBorrowerInfo getNplmBorrowerById(String borrowerId);

    List<NplmRepaymentDetail> getNplmRepaymentDetailByNum(String loanContractNum);

    NplmOverdueContract getNplmOverdueContractByNum(String loanContractNum);

    List<RepaymentDetails> getRepaymentDetails(String loanContractNum);
}
