package in.crm.main.serviceImpl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.crm.main.dao.AppraisalsDAO;
import in.crm.main.master.AppraisalsMaster;
import in.crm.main.service.AppraisalsService;

@Service
public class AppraisalsServiceIMPL implements AppraisalsService {

    @Autowired
    private AppraisalsDAO appraisalsDAO;

    @Override
    public Boolean addAppraisals(AppraisalsMaster appraisalsMaster) {
        try {
            appraisalsDAO.save(appraisalsMaster);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean updateAppraisals(AppraisalsMaster appraisalsMaster) {
        try {
            if (appraisalsDAO.existsById(appraisalsMaster.getAppraisalsId())) {
                appraisalsDAO.save(appraisalsMaster);
                return true;
            } else {
                System.out.println("Appraisal not found for update.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteAppraisals(Integer appraisalsId) {
        try {
            if (appraisalsDAO.existsById(appraisalsId)) {
                appraisalsDAO.deleteById(appraisalsId);
                return true;
            } else {
                System.out.println("Appraisal not found for deletion.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public AppraisalsMaster getAppraisalsById(Integer appraisalsId) {
        try {
            return appraisalsDAO.findById(appraisalsId).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<AppraisalsMaster> getAllAppraisals() {
        try {
            return (List<AppraisalsMaster>) appraisalsDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
