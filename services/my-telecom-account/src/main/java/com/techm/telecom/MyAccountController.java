package com.techm.telecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.telecom.model.MyAccount;
import com.techm.telecom.service.MyAccountService;

@RestController("/myaccount")
public class MyAccountController {

	@Autowired
	MyAccountService myAccountService;

	@GetMapping("/users")
	public ResponseEntity<List<MyAccount>> getMyAccountDetails() {
		return new ResponseEntity<List<MyAccount>>(myAccountService.getMyAccountDetails(), HttpStatus.OK);
	}

	@GetMapping("/myPhone/{myPhone}")
	public ResponseEntity<List<MyAccount>> getMyAccountByMyPhone(@PathVariable String myPhone) {
		return new ResponseEntity<List<MyAccount>>(myAccountService.getMyAccountByMyPhone(myPhone), HttpStatus.OK);
	}

	@PostMapping("save/users")
	public ResponseEntity<List<MyAccount>> saveAccountForMultipleUsers(@RequestBody List<MyAccount> myAccounts) {
		return new ResponseEntity<List<MyAccount>>(myAccountService.saveAccountForMultipleUsers(myAccounts),
				HttpStatus.CREATED);
	}

	@PostMapping("save/user")
	public ResponseEntity<MyAccount> saveAccountForSingleUser(@RequestBody MyAccount myAccount) {
		return new ResponseEntity<MyAccount>(myAccountService.saveAccountForSingleUser(myAccount), HttpStatus.CREATED);
	}

	@PutMapping("update/account/{accountId}/plan/{planId}")
	public ResponseEntity<MyAccount> updateNewPlan(@PathVariable long accountId, @PathVariable long planId) {
		return new ResponseEntity<MyAccount>(myAccountService.updateNewPlan(accountId, planId), HttpStatus.CREATED);
	}
}
