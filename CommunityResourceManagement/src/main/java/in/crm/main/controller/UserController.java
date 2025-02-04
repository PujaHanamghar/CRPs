package in.crm.main.controller;
import java.util.List;

import in.crm.main.master.UserMaster;
import in.crm.main.service.UserService;
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



import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserMaster>> getAllUsers() {
        List<UserMaster> allUsers = userService.getAllUserService();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<UserMaster> getUser(
            @PathVariable("userId") @Positive(message = "User Id must be positive") Integer userId) {
        UserMaster userMaster = userService.getUserServiceById(userId);
        if (userMaster != null) {
            return new ResponseEntity<>(userMaster, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(@RequestBody @Valid UserMaster userMaster) {
        Boolean isAdded = userService.addUserService(userMaster);
        if (isAdded) {
            return new ResponseEntity<>("User added successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to add user", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<String> updateUser(
            @PathVariable("userId") @Positive(message = "User ID must be positive") Integer userId,
            @RequestBody @Valid UserMaster userMaster) {
        userMaster.setUserId(userId);

        Boolean isUpdated = userService.updateUserService(userMaster);
        if (isUpdated) {
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update user", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<String> deleteUser(
            @PathVariable("userId") @Positive(message = "User Id must be Positive") Integer userId) {
        try {
            UserMaster user = userService.getUserServiceById(userId);
            if (user != null) {
                Boolean isDeleted = userService.deleteUser(user);
                if (isDeleted) {
                    return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
                }
            }
        } catch (Exception e) {
        }
        return new ResponseEntity<>("Failed to delete user", HttpStatus.BAD_REQUEST);
    }
}
