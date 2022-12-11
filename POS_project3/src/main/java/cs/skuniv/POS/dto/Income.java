package cs.skuniv.POS.dto;

import java.time.LocalDate;

public class Income {
	
	private String code;
	private int stock;
	private int price;
	private LocalDate date;
	
	public Income(String code, int stock, int price, LocalDate date) {		
		this.code = code;
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
