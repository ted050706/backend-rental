// L25-14: 建立 ResourceNotFoundException 類別，用於自訂資源未找到異常，繼承 RuntimeException，並提供建構子以傳入異常訊息。
package com.example.demo.rental.exception;

public class ResourceNotFoundException extends RuntimeException {
	public ResourceNotFoundException(String message) {
		super(message);
	}
}