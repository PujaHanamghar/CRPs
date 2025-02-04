package in.crm.main.dao;

import in.crm.main.master.PostingHistoryMaster;
import org.springframework.data.repository.CrudRepository;

public interface PostingHistoryDAO extends CrudRepository<PostingHistoryMaster,Integer> {
}
