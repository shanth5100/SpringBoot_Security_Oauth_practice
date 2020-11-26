package com.me.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.me.model.Oauth_User;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<Oauth_User, Long>{
	Oauth_User findByUsername(String username);
}
