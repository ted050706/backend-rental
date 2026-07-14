// L24-8: 建立 RentalItemRepository 介面，繼承 JpaRepository，提供對 RentalItem 實體的 CRUD 操作和自訂查詢方法。
package com.example.demo.rental.repository.test_repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.rental.model.entity.RentalItem;

@Repository
public interface RentalItemRepository extends JpaRepository<RentalItem, Long> {
	List<RentalItem> findByNameContainingIgnoreCase(String keyword);
	List<RentalItem> findByTypeContainingIgnoreCase(String type);
	List<RentalItem> findByNameContainingIgnoreCaseAndTypeIgnoreCase(String keyword, String type);

}
