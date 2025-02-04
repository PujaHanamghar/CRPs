package in.crm.main.service;


import in.crm.main.master.HonorariumHistoryMaster;

import java.util.List;

public interface HonorariumHistoryService {

    public Boolean addHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster);
    public Boolean updateHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster);
    public Boolean deleteHonorariumHistoryService(HonorariumHistoryMaster honorariumHistoryMaster);


    public HonorariumHistoryMaster getHonorariumHistoryService(Integer hid);
    public List<HonorariumHistoryMaster> getAllHonorariumHistoryService();


}
