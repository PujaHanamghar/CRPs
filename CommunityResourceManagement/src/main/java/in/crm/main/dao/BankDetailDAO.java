package in.crm.main.dao;

import in.crm.main.master.BankDetailMaster;
import org.springframework.data.repository.CrudRepository;

public interface BankDetailDAO extends CrudRepository<BankDetailMaster,Integer> {

    
}
