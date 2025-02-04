package in.crm.main.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.crm.main.dao.ActionTypeDAO;
import in.crm.main.master.ActionTypeMaster;
import in.crm.main.service.ActionTypeService;

@Service
public class ActionTypeServiceIMPL implements ActionTypeService {

    @Autowired
    private ActionTypeDAO actionTypeDAO;

  
    @Override
    public Boolean addActionTypeService(ActionTypeMaster actionTypeMaster) {
        try {
            actionTypeDAO.save(actionTypeMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Boolean updateActionTypeService(ActionTypeMaster actionTypeMaster) {
        try {
            ActionTypeMaster existingActionType = actionTypeDAO.findById(actionTypeMaster.getActionTypeId()).orElse(null);
            if (existingActionType != null) {
                existingActionType.setActionTypeName(actionTypeMaster.getActionTypeName());
                existingActionType.setActionTypeDesc(actionTypeMaster.getActionTypeDesc());

                actionTypeDAO.save(existingActionType);
                return true;
            } else {
                System.out.println("ActionType not found for update.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Transactional
    @Override
    public Boolean deleteActionTypeService(ActionTypeMaster actionTypeMaster) {
        try {
            actionTypeDAO.deleteById(actionTypeMaster.getActionTypeId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public ActionTypeMaster getActionTypeService(Integer actionTypeId) {
        try {
            return actionTypeDAO.findById(actionTypeId).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<ActionTypeMaster> getAllActionTypeService() {
        try {
            return (List<ActionTypeMaster>) actionTypeDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
