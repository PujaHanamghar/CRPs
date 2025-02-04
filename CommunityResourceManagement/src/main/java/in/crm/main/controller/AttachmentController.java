package in.crm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.crm.main.master.AttachmentMaster;
import in.crm.main.service.Attachmentservice;
import jakarta.validation.constraints.Positive;

@RequestMapping("/attachment")
@RestController
public class AttachmentController {

	@Autowired
	Attachmentservice attachmentService;

	
	  @PostMapping("/addAttachment") 
	  public ResponseEntity<String>addAttachement
	  (@RequestBody @Validated AttachmentMaster attachmentMaster)
	  {
	  Boolean isAdded = attachmentService.addAttachmentService(attachmentMaster);
	  	if (isAdded) { return new ResponseEntity<>("Attachment added successfully!",
	  HttpStatus.CREATED); } else { return new
	  ResponseEntity<>("Failed to add Attachment.", HttpStatus.BAD_REQUEST); } }
	  
	  
	  @PutMapping("/updateAttachment/{attachmentId}")
	  public ResponseEntity<String> updateAttachment(
	          @PathVariable("attachmentId") @Positive(message = "Attachment ID must be positive") Integer attachmentId,
	          @RequestBody @Validated AttachmentMaster attachmentMaster) {
	      
	      attachmentMaster.setAttachmentId(attachmentId);
	      Boolean isUpdated = attachmentService.updateAttachmentService(attachmentMaster);
	      if (isUpdated) {
	          return new ResponseEntity<>("Attachment updated successfully!", HttpStatus.OK);
	      } else {
	          return new ResponseEntity<>("Failed to update Attachment.", HttpStatus.BAD_REQUEST);
	      }
	  }


	  @DeleteMapping("/deleteAttachment/{attachmentId}")
	  public ResponseEntity<String> deleteAttachment(
	          @PathVariable("attachmentId") @Positive(message = "Attachment ID must be positive") Integer attachmentId) {
	      
	      AttachmentMaster attachmentMaster = attachmentService.getAttachmentService(attachmentId);
	      if (attachmentMaster != null) {
	          Boolean isDeleted = attachmentService.deleteAttachmentService(attachmentMaster);
	          if (isDeleted) {
	              return new ResponseEntity<>("Attachment deleted successfully!", HttpStatus.OK);
	          }
	      }
	      return new ResponseEntity<>("Failed to delete Attachment.", HttpStatus.BAD_REQUEST);
	  }

	@GetMapping("/getAttachment/{attachmentId}")
	public ResponseEntity<AttachmentMaster> getAttachment(
			@PathVariable("attachmentId") @Positive(message = "Attachment ID must be positive") Integer attachmentId) {
		AttachmentMaster attachmentMaster = attachmentService.getAttachmentService(attachmentId);
		if (attachmentMaster != null) {
			return new ResponseEntity<>(attachmentMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllAttachments")
	public ResponseEntity<List<AttachmentMaster>> getAllAttachments() {
		List<AttachmentMaster> allAttachments;
		try {
			allAttachments = attachmentService.getAllAttachmentService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allAttachments, HttpStatus.OK);
	}
}
