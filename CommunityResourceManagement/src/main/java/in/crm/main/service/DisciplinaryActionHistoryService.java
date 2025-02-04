package in.crm.main.service;

import in.crm.main.master.DisciplinaryActionHistoryMaster;
import in.crm.main.master.DisciplinaryActionsMaster;

import java.util.List;

public interface DisciplinaryActionHistoryService {

    public  Boolean addDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster);
    public  Boolean updateDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster);
    public  Boolean deleteDisciplinaryActionHistoryService(DisciplinaryActionHistoryMaster disciplinaryActionHistoryMaster);

    public DisciplinaryActionHistoryMaster getDisciplinaryActionHistoryService(Integer disciplinaryActionHistoryId);
    public List<DisciplinaryActionHistoryMaster> getAllDisciplinaryActionHistoryService();

}
