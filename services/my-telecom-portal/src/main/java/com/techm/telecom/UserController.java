package com.techm.telecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.telecom.service.UserService;
import com.techm.telecom.model.Authenticate;
import com.techm.telecom.model.User;
import com.techm.telecom.model.account.MyAccount;

@RestController("/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/all", produces = "application/json; charset=UTF-8")
	public ResponseEntity<List<User>> getUserDetails() {
		return new ResponseEntity<List<User>>(userService.getUserDetails(), HttpStatus.OK);
	}

	@GetMapping("/single/{id}")
	public ResponseEntity<User> getUserByUserId(@PathVariable String id) {
		return new ResponseEntity<User>(userService.getUserByUserId(Long.parseLong(id)), HttpStatus.OK);
	}

	@PostMapping("/authenticate")
	public ResponseEntity<List<MyAccount>> getAuthentication(@RequestBody Authenticate authenticate) {
		return new ResponseEntity<List<MyAccount>>(userService.getAuthication(authenticate), HttpStatus.OK);
	}

	@PostMapping("/save/all")
	public ResponseEntity<List<User>> saveAllUsers(@RequestBody List<User> users) {
		return new ResponseEntity<List<User>>(userService.saveUserList(users), HttpStatus.CREATED);
	}

	@PostMapping("save/single")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.saveSingleUser(user), HttpStatus.CREATED);
	}

	@GetMapping("/myPhone/{myPhone}")
	public ResponseEntity<List<MyAccount>> getMyAccountByMyPhone(@PathVariable String myPhone) {
		return new ResponseEntity<List<MyAccount>>(userService.getMyAccountByMyPhone(myPhone), HttpStatus.OK);
	}

	@PutMapping("update/account/{accountId}/plan/{planId}")
	public ResponseEntity<MyAccount> UpdateMyAccountToNewPlan(@PathVariable long accountId, @PathVariable long planId) {
		System.out.println("usercontroller: " + accountId + " : " + planId);
		return new ResponseEntity<MyAccount>(userService.UpdateMyAccountToNewPlan(accountId, planId), HttpStatus.OK);
	}
}
