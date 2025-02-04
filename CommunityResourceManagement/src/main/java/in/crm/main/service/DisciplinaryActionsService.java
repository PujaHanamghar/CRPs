package in.crm.main.service;

import in.crm.main.master.DisciplinaryActionsMaster;
import in.crm.main.master.PostingHistoryMaster;

import java.util.List;

public interface DisciplinaryActionsService {

    public  Boolean addDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster);
    public  Boolean updateDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster);
    public  Boolean deleteDisciplinaryActionsService(DisciplinaryActionsMaster disciplinaryActionsMaster);

    public DisciplinaryActionsMaster getDisciplinaryActionsService(Integer disciplinaryActionId);
    public List<DisciplinaryActionsMaster> getAllDisciplinaryActionsService();

}
