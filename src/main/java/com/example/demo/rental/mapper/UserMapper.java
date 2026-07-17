// L25-11: 建立 UserMapper 類別，用於將 AppUser 實體轉換為 UserProfileDto DTO，方便在 API 回應中使用。
package com.example.demo.rental.mapper;

import com.example.demo.rental.model.dto.auth.UserProfileDto;
import com.example.demo.rental.model.entity.AppUser;

public class UserMapper {
	
	public static UserProfileDto toProfileDto(AppUser user) {
		return new UserProfileDto(
				user.getId(), 
				user.getUsername(), 
				user.getFullName(), 
				user.getPhone(), 
				user.getRole().name());
	}
	
}