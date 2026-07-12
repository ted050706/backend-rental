// L24-3: 建立 RentalItem 實體類別，對應資料庫中的 rental_item 表格，並使用 Jakarta Persistence 註解進行欄位映射。
package com.example.demo.rental.model.entity;

import java.math.BigDecimal;

import com.example.demo.rental.model.enums.ItemStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "rental_item")
@Getter
@Setter
@NoArgsConstructor
public class RentalItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, length = 100)
	private String name;
	
	@Column(nullable = false, length = 40)
	private String type;
	
	@Column(nullable = false, length = 120)
	private String location;
	
	@Column(name = "price_per_hour", nullable = false, precision = 10, scale = 2)
	private BigDecimal pricePerHour;
	
	@Column(length = 500)
	private String description;
	
	@Column(name = "image_url", length = 500)
	private String imageUrl;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 30)
	/* 需另外在 /model/enums/ItemStatus.java [enum] 定義 AVAILABLE 和 MAINTENANCE 狀態 */
	private ItemStatus status = ItemStatus.AVAILABLE;

}
