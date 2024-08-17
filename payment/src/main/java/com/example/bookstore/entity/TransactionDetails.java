package com.example.bookstore.entity;


public class TransactionDetails {

	private String orderId;
	private String currency;
	private int amount;
	private String Key;
	public TransactionDetails() {
		super();
	}
	
	
	


	public TransactionDetails(String orderId, String currency, int amount, String key) {
		super();
		this.orderId = orderId;
		this.currency = currency;
		this.amount = amount;
		this.Key = key;
	}





	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}





	public String getKey() {
		return Key;
	}





	public void setKey(String key) {
		this.Key = key;
	}
	
	
	
}
