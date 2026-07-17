// L25-9: 建立 ApiResponse DTO 所需欄位，用於封裝 API 回應 的資訊，並提供成功、創建和錯誤的靜態方法。
package com.example.demo.rental.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	private int status;
	private String message;
	private T data;
	
	public static <T> ApiResponse<T> success(String message, T data) {
		return new ApiResponse<>(200, message, data);
	}
	
	public static <T> ApiResponse<T> created(String message, T data) {
		return new ApiResponse<>(201, message, data);
	}
	
	public static <T> ApiResponse<T> error(int status, String message) {
		return new ApiResponse<>(status, message, null);
	}
}