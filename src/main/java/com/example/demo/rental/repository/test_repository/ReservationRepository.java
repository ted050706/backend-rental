// L24-9: 建立 ReservationRepository 介面，繼承 JpaRepository，提供對 Reservation 實體的 CRUD 操作和自訂查詢方法。
package com.example.demo.rental.repository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.rental.model.entity.Reservation;
import com.example.demo.rental.model.enums.ReservationStatus;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	List<Reservation> findByUserIdOrderByCreatedAtDesc(Long userId);
	List<Reservation> findAllByOrderByCreatedAtDesc();
	
	@Query("""
			SELECT COUNT(r) > 0 FROM Reservation r
			WHERE r.id = :itemId
				AND r.status IN :statuses
				AND r.startTime < :newEndDate
				AND r.endTime > :newStartDate
			""")
	boolean exitsOverlap(
			@Param("itemId") Long itemId,
			@Param("statuses") Collection<ReservationStatus> statuses,
			@Param("newEndDate") LocalDateTime newEndDate,
			@Param("newStartDate") LocalDateTime newStartDate
			);
	
/*	
 // ItemId And Status In  StartTime LessThan And EndTime GreaterThan
	boolean existsByItemIdAndStatusInStartTimeLessThanAndEndTimeGreaterThan(
			Long itemId,
			Collection<ReservationStatus> statuses,
			LocalDateTime newEndDate,
			LocalDateTime newStartDate
			);
*/
	
}
