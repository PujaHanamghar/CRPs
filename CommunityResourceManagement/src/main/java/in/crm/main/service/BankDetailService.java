package in.crm.main.service;

import in.crm.main.master.BankDetailMaster;
import in.crm.main.master.CommunityResourcePersonMaster;

import java.util.List;

public interface BankDetailService{

    public  Boolean addBankDetailService(BankDetailMaster bankDetailMaster);
    public  Boolean updateBankDetailService(BankDetailMaster bankDetailMaster);
    public  Boolean deleteBankDetailService(BankDetailMaster bankDetailMaster);

    public  BankDetailMaster getBankDetailsService(Integer bankDetailId);
    public  List<BankDetailMaster> getAllBankDetailsService();

}
