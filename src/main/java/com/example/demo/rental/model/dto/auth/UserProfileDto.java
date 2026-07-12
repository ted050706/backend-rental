// L25-3: 連帶建立 UserProfileDto 資料傳輸物件類別，用於封裝 使用者個人資料 資訊，並使用 Lombok 註解自動生成建構子和 getter/setter 方法。
package com.example.demo.rental.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserProfileDto {
	
	private Long id;
	private String username;
	private String fullName;
	private String phone;
	private String role;
}
