// L25-1: 建立 LoginRequest DTO 類別，用於封裝使用者登入請求的帳號和密碼資訊，並使用 Jakarta Bean Validation 註解進行欄位驗證，確保帳號和密碼不可為空白。
package com.example.demo.rental.model.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {
	
	@NotBlank(message = "帳號不可空白")
	private String username;
	
	@NotBlank(message = "密碼不可空白")
	private String password;

}
