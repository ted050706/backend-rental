// L25-10: 建立 RentalItemMapper 類別，用於將 RentalItem 實體與 DTO 之間進行轉換，提供 toResponse 方法將實體轉換為回應 DTO，以及 copyToEntity 方法將請求 DTO 的資料複製到實體中。
package com.example.demo.rental.mapper;

import com.example.demo.rental.model.dto.item.RentalItemRequest;
import com.example.demo.rental.model.dto.item.RentalItemResponse;
import com.example.demo.rental.model.entity.RentalItem;

public class RentalItemMapper {
	
	// entity:RentalItem 轉 dto:RentalItemResponse
	public static RentalItemResponse toResponse(RentalItem item) {
		return new RentalItemResponse(
				item.getId(), 
				item.getName(), 
				item.getType(), 
				item.getLocation(), 
				item.getPricePerHour(), 
				item.getStatus().name(), 
				item.getImageUrl(),
				item.getDescription()
		);
	}
	
	// 將 dto:RentalItemRequest 複製到 entity:RentalItem
	public static void copyToEntity(RentalItemRequest request, RentalItem item) {
		item.setName(request.getName());
		item.setType(request.getType());
		item.setLocation(request.getLocation());
		item.setPricePerHour(request.getPricePerHour());
		item.setStatus(request.getStatus());
		item.setDescription(request.getDescription());
		item.setImageUrl(request.getImageUrl());
	}
	
}