package in.crm.main.controller;

import in.crm.main.master.DesignationMaster;
import in.crm.main.master.PostingHistoryMaster;
import in.crm.main.service.PostingHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/PostingHistory")
public class PostingHistoryController {

    @Autowired
    private PostingHistoryService postingHistoryService;

    @PostMapping("/addPostingHistory")
    public ResponseEntity<String> addPostingHistory(@RequestBody PostingHistoryMaster postingHistoryMaster)
    {
        Boolean isAdded = postingHistoryService.addPostingHistoryService(postingHistoryMaster);
        if(isAdded){
            return  new ResponseEntity<>("PostingHistory added successfully !", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Failed to add PostingHistory",HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updatePostingHistory/{postingId}")
    public ResponseEntity<String> updatePostingHistory(@PathVariable("postingId") Integer postingId,@RequestBody PostingHistoryMaster postingHistoryMaster)
    {
        postingHistoryMaster.setPostingId(postingId);
        Boolean isUpdated=postingHistoryService.updatePostingHistoryService(postingHistoryMaster);
        if(isUpdated)
        {
            return new ResponseEntity<>("updatePostingHistory updated successfully!",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("Failed to update updatePostingHistory",HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deletePostingHistory/{postingId}")
    public ResponseEntity<String> deletePostingHistory(@PathVariable("postingId") Integer postingId,@RequestBody PostingHistoryMaster postingHistoryMaster)
    {
        postingHistoryService.getPostingHistoryService(postingId);
        if(postingHistoryMaster!= null)
        {
            Boolean isDeleted = postingHistoryService.deletePostingHistoryService(postingHistoryMaster);
            if(isDeleted)
            {
                return new ResponseEntity<>("Posting History deleted successfully",HttpStatus.OK);
            }
        }
        return new ResponseEntity<>("failed to delete Posting History",HttpStatus.BAD_REQUEST);

    }
    @GetMapping("/getPostingHistory/{postingId}")
    public ResponseEntity<PostingHistoryMaster>getPostingHistory(@PathVariable("postingId") Integer postingId)
    {
        PostingHistoryMaster postingHistoryMaster=postingHistoryService.getPostingHistoryService(postingId);
        if (postingHistoryMaster !=null)
        {
            return new ResponseEntity<>(postingHistoryMaster,HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllPostingHistory")
    public ResponseEntity<List<PostingHistoryMaster>> getAllPostingHistory()
    {
        List<PostingHistoryMaster> allPostingHistory = postingHistoryService.getAllPostingHistoryService();
        return new ResponseEntity<>(allPostingHistory,HttpStatus.OK);
    }







}
