package in.crm.main.service;

import in.crm.main.master.DesignationMaster;
import in.crm.main.master.PostingHistoryMaster;

import java.util.List;

public interface PostingHistoryService {
    public Boolean addPostingHistoryService(PostingHistoryMaster postingHistoryMaster);
    public Boolean updatePostingHistoryService(PostingHistoryMaster postingHistoryMaster);
    public Boolean deletePostingHistoryService(PostingHistoryMaster postingHistoryMaster);
    public PostingHistoryMaster getPostingHistoryService(Integer postingId);
    public List<PostingHistoryMaster> getAllPostingHistoryService();
}
