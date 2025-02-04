package in.crm.main.serviceImpl;

import in.crm.main.dao.PostingHistoryDAO;
import in.crm.main.master.DesignationMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.PostingHistoryService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostingHistoryServiceImpl implements PostingHistoryService {

    private static final Logger logger= LogManager.getLogger(PostingHistoryServiceImpl.class);

    @Autowired
    private PostingHistoryDAO postingHistoryDAO;

    @Override
    public Boolean addPostingHistoryService(PostingHistoryMaster postingHistoryMaster) {

        try {
            logger.info("In addPostingHistoryService");
            postingHistoryDAO.save(postingHistoryMaster);
            logger.info("Out of addPostingHistoryService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
          return false;
        }

    }

    @Override
    public Boolean updatePostingHistoryService(PostingHistoryMaster postingHistoryMaster) {
        try {
            logger.info("In updatePostingHistoryService");
            postingHistoryDAO.findById(postingHistoryMaster.getPostingId());
            postingHistoryMaster.setPostingDate(postingHistoryMaster.getPostingDate());
            postingHistoryMaster.setManagerName(postingHistoryMaster.getManagerName());
            postingHistoryMaster.setRemarks(postingHistoryMaster.getRemarks());
            postingHistoryDAO.save(postingHistoryMaster);
            logger.info("In updatePostingHistoryService");
            return true;
        }
        catch (Exception e)
        {
            logger.info("CRP: " + e.getMessage(), e);
            return false;
        }
    }

    @Override
    public Boolean deletePostingHistoryService(PostingHistoryMaster postingHistoryMaster) {
        try {
            logger.info("In deletePostingHistoryService");
            postingHistoryDAO.findById(postingHistoryMaster.getPostingId());
            postingHistoryDAO.delete(postingHistoryMaster);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public PostingHistoryMaster getPostingHistoryService(Integer postingId) {
    try {
       logger.info("In getPostingHistoryService");
       PostingHistoryMaster postingHistoryMaster=postingHistoryDAO.findById(postingId).orElse(null);
       logger.info("Out of getPostingHistoryService");
       return postingHistoryMaster;
    }
   catch (Exception e)
   {
       logger.info("CRP:"+e.getMessage(),e);
    return null;
    }

    }

    @Override
    public List<PostingHistoryMaster> getAllPostingHistoryService() {
        List<PostingHistoryMaster> allPostingHistory=new ArrayList<>();
        try {
            logger.info(" In getAllPostingHistory");
            allPostingHistory =(List<PostingHistoryMaster>) postingHistoryDAO.findAll();
            logger.info(" Out Of getAllPostingHistoryService");
        }
        catch (Exception e)
        {
            logger.error("CRP: "+e.getMessage());
        }
         return allPostingHistory;
    }
}
