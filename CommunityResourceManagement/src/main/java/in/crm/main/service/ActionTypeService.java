package in.crm.main.service;


import java.util.List;

import in.crm.main.master.ActionTypeMaster;

public interface ActionTypeService {
    Boolean addActionTypeService(ActionTypeMaster actionTypeMaster);
    Boolean updateActionTypeService(ActionTypeMaster actionTypeMaster);
    Boolean deleteActionTypeService(ActionTypeMaster actionTypeMaster);
    ActionTypeMaster getActionTypeService(Integer actionTypeId);
    List<ActionTypeMaster> getAllActionTypeService();
}
