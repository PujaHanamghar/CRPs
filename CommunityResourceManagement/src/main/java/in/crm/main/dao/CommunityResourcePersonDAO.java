package in.crm.main.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.crm.main.master.CommunityResourcePersonMaster;
import org.springframework.data.repository.CrudRepository;

public interface CommunityResourcePersonDAO extends CrudRepository<CommunityResourcePersonMaster,Integer>
{

}
