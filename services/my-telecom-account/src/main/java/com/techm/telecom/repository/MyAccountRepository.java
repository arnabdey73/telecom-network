package com.techm.telecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.techm.telecom.model.MyAccount;

public interface MyAccountRepository extends JpaRepository<MyAccount, Long> {

	@Query("select c from MyAccount c where c.myPhone = :myPhone")
    public List<MyAccount> getMyAccountByMyPhone(@Param("myPhone") String myPhone);
}
