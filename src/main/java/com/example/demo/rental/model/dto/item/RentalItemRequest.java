// L25-5: 建立 RentalItemRequest DTO 所需欄位，用於封裝 租賃物品請求 的資訊，並使用 Jakarta Bean Validation 註解進行欄位驗證。
package com.example.demo.rental.model.dto.item;

import java.math.BigDecimal;

import com.example.demo.rental.model.enums.ItemStatus;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RentalItemRequest {
	
	@NotBlank(message = "名稱不可空白")
	private String name;
	
	@NotBlank(message = "類型不可空白")
	private String type;
	
	@NotBlank(message = "地點不可空白")
	private String location;
	
	@NotNull(message = "每小時價格不可為空")
	@DecimalMin(value = "0.0", inclusive = false, message = "每小時價格必須大於 0")
	private BigDecimal pricePerHour;
	
	private ItemStatus status = ItemStatus.AVAILABLE;
	
	private String description;
	
	private String imageUrl;

}
