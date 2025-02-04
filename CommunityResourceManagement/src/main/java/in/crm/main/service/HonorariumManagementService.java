package in.crm.main.service;

import in.crm.main.master.HonorariumManagementMaster;
import in.crm.main.master.PostingHistoryMaster;

import java.util.List;

public interface HonorariumManagementService {

    public Boolean addHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster);
    public Boolean updateHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster);
    public Boolean deleteHonorariumManagementService(HonorariumManagementMaster honorariumManagementMaster);

    public HonorariumManagementMaster getHonorariumManagementService(Integer honorariumId);
    public List<HonorariumManagementMaster> getAllHonorariumManagementService();


}
