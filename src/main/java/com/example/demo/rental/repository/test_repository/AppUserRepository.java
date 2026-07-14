// L24-7: 建立 AppUserRepository 介面，繼承 JpaRepository，提供對 AppUser 實體的 CRUD 操作和自訂查詢方法。
package com.example.demo.rental.repository.test_repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.rental.model.entity.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	Optional<AppUser> findByUsername(String username);
	boolean existsByUsername(String username);

}
