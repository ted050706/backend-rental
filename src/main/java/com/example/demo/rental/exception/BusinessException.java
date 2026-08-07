// L25-13: 建立 BusinessException 類別，用於自訂業務邏輯異常，繼承 RuntimeException，並提供建構子以傳入異常訊息
package com.example.demo.rental.exception;

public class BusinessException extends RuntimeException {
	public BusinessException(String message) {
		super(message);
	}
}

