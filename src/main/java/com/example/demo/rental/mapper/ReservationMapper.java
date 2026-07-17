// L25-8: 建立 ReservationMapper 類別，用於將 Reservation 實體轉換為 ReservationResponse DTO，方便在 API 回應中使用。
package com.example.demo.rental.mapper;

import com.example.demo.rental.model.dto.reservation.ReservationResponse;
import com.example.demo.rental.model.entity.Reservation;

public class ReservationMapper {
	
	public static ReservationResponse toResponse(Reservation r) {
		return new ReservationResponse(
				r.getId(), 
				r.getUser().getId(),
				r.getUser().getUsername(), 
				r.getUser().getFullName(),
				r.getItem().getId(),
				r.getItem().getName(),
				r.getItem().getType(),
				r.getStartTime(),
				r.getEndTime(),
				r.getTotalAmount(),
				r.getStatus().name(),
				r.getNote(),
				r.getCreatedAt());
	}
	
}