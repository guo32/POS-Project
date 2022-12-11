package cs.skuniv.POS.dto;

import java.time.LocalDate;

public class Product {

	private String code; // 제품 코드
	private String name; // 제품 이름
	private int stock; // 재고
	private int price; // 가격
	private LocalDate date; // 입고 날짜
	
	public Product(String code, String name, int stock, int price, LocalDate date) {
		this.code = code;
		this.name = name;
		this.stock = stock;
		this.price = price;
		this.date = date;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public LocalDate getDate() {
		return date;
	}
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
}
