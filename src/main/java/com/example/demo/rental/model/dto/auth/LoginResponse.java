// L25-2: 建立 LoginResponse DTO 類別，用於封裝使用者登入成功後的回應資訊，包含 token、tokenType 和 user 欄位，並使用 Lombok 註解自動生成建構子和 getter/setter 方法。
package com.example.demo.rental.model.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {
	
	private String token;
	private String tokenType;
	private UserProfileDto user;  /* 需另外建立 UserProfileDto 類別 */
	
}
