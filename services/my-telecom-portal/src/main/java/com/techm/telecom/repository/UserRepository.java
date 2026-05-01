package com.techm.telecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techm.telecom.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select c from User c where c.userName = :userName and c.password = :password or c.mobile = :mobile and c.password = :password")
	public User getAuthentication(@Param("userName") String userName, @Param("mobile") String mobile,
			@Param("password") String password);
}
