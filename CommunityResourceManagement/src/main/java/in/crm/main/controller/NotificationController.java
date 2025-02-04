package in.crm.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.crm.main.master.NotificationMaster;
import in.crm.main.service.NotificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
@RestController
@RequestMapping("/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@PostMapping("/addNotification")
	public ResponseEntity<String> addNotification(@RequestBody @Valid  NotificationMaster notificationMaster) {
		Boolean isAdded = notificationService.addNotificationService(notificationMaster);
		if (isAdded) {
			return new ResponseEntity<>("notification added successfully!", HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>("Failed to add notification.", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updatenotification/{notificationId}") public ResponseEntity<String>
	  updatenotification(
	  
	  @PathVariable("notificationId")
	  @Positive(message ="notification ID must be positive") Integer notificationId,
	  @RequestBody @Valid NotificationMaster notificationMaster) {
		notificationMaster.setNotificationId(notificationId);
			Boolean isUpdated = notificationService.updateNotificationService(notificationMaster);
			if (isUpdated) {
				return new ResponseEntity<>("notification updated successfully!", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("notification to update notification.", HttpStatus.BAD_REQUEST);
			}
		}

		@DeleteMapping("/deletenotification/{notificationId}")
		public ResponseEntity<String> deletenotification(
				@PathVariable("notificationId") @Positive(message = "notification ID must be positive") Integer notificationId) {
			NotificationMaster notificationMaster = notificationService.getNotificationService(notificationId);
			if (notificationMaster != null) {
				Boolean isDeleted = notificationService.deleteNotificationService(notificationMaster);
				if (isDeleted) {
					return new ResponseEntity<>("notification deleted successfully!", HttpStatus.OK);
				}
			}
			return new ResponseEntity<>("Failed to delete notification.", HttpStatus.BAD_REQUEST);
		}

	@GetMapping("/getNotification/{notificationId}")
	public ResponseEntity<NotificationMaster> getnotification(
			@PathVariable("countryId") @Positive(message = "notification ID must be positive") Integer notificationId) {
		NotificationMaster notificationMaster = notificationService.getNotificationService(notificationId);
		if (notificationMaster != null) {
			return new ResponseEntity<>(notificationMaster, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/getAllCountries")
	public ResponseEntity<List<NotificationMaster>> getAllNotifications() {
		List<NotificationMaster> allNotifications;
		try {
			allNotifications = notificationService.getAllNotificationService();
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(allNotifications, HttpStatus.OK);
	}
}

