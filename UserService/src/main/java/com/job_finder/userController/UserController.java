package com.job_finder.userController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.job_finder.entity.UserDtls;
import com.job_finder.helperClass.Employment;
import com.job_finder.helperClass.LoginForm;
import com.job_finder.helperClass.RegistrationForm;
import com.job_finder.response.LoginMessage;
import com.job_finder.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired
	private  UserService userService;

	@PostMapping("/save")
    public String saveEmployee(@RequestBody RegistrationForm form) {
    	String id=userService.addEmployee(form);
    	return id;
    }
	@PostMapping("/login")
	public ResponseEntity<LoginMessage> loginEmployee(@RequestBody LoginForm loginForm) {
		  LoginMessage loginResponse = userService.loginEmployee(loginForm);
	        return new ResponseEntity<>(loginResponse,HttpStatus.OK);
	        
	}
    
	@PostMapping("/employment-save")
	public ResponseEntity<Employment> addEmployment(@RequestBody Employment value) {
	    Employment updatedEmployment = userService.updateEmploymentDetails(value);

	    if (updatedEmployment != null) {
	        return new ResponseEntity<>(updatedEmployment, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
    @GetMapping("/test")
    public String welcome() {
    	return "this is working";
    }
    
    @GetMapping("/users")
    public List<UserDtls> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDtls> getUserById(@PathVariable Long userId) {
        Optional<UserDtls> user = userService.getUserDetailsById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> createUser(@RequestBody UserDtls user) {
        boolean isRegister = userService.createUser(user);
        
        return new ResponseEntity<>(isRegister, HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDtls> updateUser(@PathVariable Long userId, @RequestBody UserDtls updatedUser) {
        UserDtls updated = userService.updateUser(userId, updatedUser);
        return updated != null
                ? new ResponseEntity<>(updated, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}