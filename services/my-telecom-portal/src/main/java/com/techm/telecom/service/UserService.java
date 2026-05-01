package com.techm.telecom.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.techm.telecom.model.Authenticate;
import com.techm.telecom.model.User;
import com.techm.telecom.model.account.MyAccount;
import com.techm.telecom.model.account.Plan;
import com.techm.telecom.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public List<User> getUserDetails() {
		return userRepository.findAll();
	}

	public User getUserByUserId(long id) {
		return userRepository.findById(id).get();
	}

	public List<MyAccount> getAuthication(Authenticate authenticate) {
		User user = userRepository.getAuthentication(authenticate.getUserName(), authenticate.getMobile(),
				authenticate.getPassword());
		List<MyAccount> myAccounts = getMyAccountByMyPhone(user.getMobile());
		for (MyAccount myAccount : myAccounts) {
			myAccount.setUserName(authenticate.getUserName());
		}
		if (user != null && myAccounts != null && myAccounts.size() > 0) {
			return myAccounts;
		}
		return null;
	}

	public List<User> saveUserList(List<User> users) {
		return userRepository.saveAll(users);
	}

	public User saveSingleUser(User user) {
		return userRepository.save(user);
	}

	public List<MyAccount> getMyAccountByMyPhone(String myPhone) {
		String url = "http://localhost:8282/myPhone/" + myPhone;
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(mediaTypes);
		HttpEntity<MyAccount> httpEntity = new HttpEntity<MyAccount>(null, headers);
		ResponseEntity<MyAccount[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity,
				MyAccount[].class);
		MyAccount[] myAccount = responseEntity.getBody();
		System.out.println("responseEntity: " + myAccount[0]);
		List<MyAccount> myAccountList = new ArrayList<MyAccount>(Arrays.asList(myAccount[0]));
		return myAccountList;
	}

	public MyAccount UpdateMyAccountToNewPlan(long accountId, long planId) {
//		String url = "http://my-telecom-account.default.svc.cluster.local:8282/update/account/" + accountId + "/plan/"
//				+ planId;
		String url = "http://localhost:8282/update/account/" + accountId + "/plan/"
				+ planId;
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.APPLICATION_JSON);
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(mediaTypes);
		HttpEntity<MyAccount> httpEntity = new HttpEntity<MyAccount>(null, headers);
		System.out.println("userservice url: " + url);
		ResponseEntity<MyAccount> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, httpEntity,
				MyAccount.class);
		MyAccount myAccount = responseEntity.getBody();
		System.out.println("responseEntity: " + myAccount);
		return myAccount;
	}
}
