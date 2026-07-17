// L25-8: 建立 ReservationResponse DTO 所需欄位，用於封裝 租賃預約回應 的資訊。
package com.example.demo.rental.model.dto.reservation;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservationResponse {
	
	private Long id;
	private Long userId;
	private String username;
	private String fullname;
	private Long itemId;
	private String itemName;
	private String itemType;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private BigDecimal totalAmount;
	private String status;
	private String note;
	private LocalDateTime createdAt;
	
}