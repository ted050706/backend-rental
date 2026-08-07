// L24-5: 建立 Reservation 實體類別，對應資料庫中的 reservation 表格，並使用 Jakarta Persistence 註解進行欄位映射。
package com.example.demo.rental.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.rental.model.enums.ReservationStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reservation")
@Getter
@Setter
@NoArgsConstructor
public class Reservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/*
	 * 建立 多對一 關聯（多筆預約紀錄對應同一個使用者）
	 * fetch = FetchType.LAZY: 設定延遲載入，查詢預約時不會立刻查詢用戶資料，提升效能
	 * optional = false: 設定此關聯為必填，預約紀錄不能沒有對應的使用者
	 * @JoinColumn(name = "user_id"): 在資料表中建立名為 user_id 的外鍵（Foreign Key）欄位
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	private AppUser user;
	
	/* 
	 * 建立 多對一 關聯（多筆預約紀錄對應同一個出租物品）
	 * fetch = FetchType.LAZY: 設定延遲載入，避免非必要的連表查詢
	 * optional = false: 設定此關聯為必填，預約紀錄不能沒有對應的出租物品
	 * @JoinColumn(name = "item_id"): 在資料表中建立名為 item_id 的外鍵（Foreign Key）欄位
	 */
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "item_id", nullable = false)
	private RentalItem item;
	
	
	// 對應 start_time 欄位，不允許為空，記錄預約開始時間
	@Column(name = "start_time", nullable = false)
	private LocalDateTime startTime;
	
	// 對應 end_time 欄位，不允許為空，記錄預約結束時間
	@Column(name = "end_time", nullable = false)
	private LocalDateTime endTime;
	
	
	// 對應 total_amount 欄位，不允許為空，記錄預約總金額 (precision=10, scale=2 代表總共10位數且包含2位小數)
	@Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
	private BigDecimal totalAmount;
	
	
	// 定義一個「預約狀態」欄位，並設定它在資料庫中的儲存格式與預設值
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	/* 需另外在 /model/enums/ReservationStatus.java [enum] 定義 PENDING、APPROVED、REJECTED、CANCELLED 和 FINISHED 狀態 */
	private ReservationStatus status = ReservationStatus.PENDING; 
	
	
	// 對應「note」欄位，允許為空，最大長度 500 個字元
	@Column(length = 500)
	private String note;
	
	
	// Hibernate 註解：在資料第一次新增（Insert）時，自動寫入當前系統時間
	@CreationTimestamp
	@Column(name = "created_at", nullable = false)
	private LocalDateTime createdAt;
	
	// Hibernate 註解：在資料每次更新（Update）時，自動刷新為當前系統時間
	@UpdateTimestamp
	@Column(name = "updated_at", nullable = false)
	private LocalDateTime updatedAt;
}
