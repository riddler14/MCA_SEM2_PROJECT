package com.example.bookstore.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class OrderDetails {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long OrderId;

private String transaction_id;
private String order_name;

private String address;
private String number;
private String alternateNumber;
private String product_name;
private int amount;





public OrderDetails() {
	super();
}





public OrderDetails(Long orderId, String transaction_id,String order_name, String address, String number, String alternateNumber,
		String product_name, int amount) {
	super();
	this.OrderId = orderId;
	this.transaction_id=transaction_id;
	this.order_name = order_name;
	this.address = address;
	this.number = number;
	this.alternateNumber = alternateNumber;
	this.product_name = product_name;
	this.amount = amount;
}










public String getTransaction_id() {
	return transaction_id;
}





public void setTransaction_id(String transaction_id) {
	this.transaction_id = transaction_id;
}





public Long getOrderId() {
	return OrderId;
}





public void setOrderId(Long orderId) {
	this.OrderId = orderId;
}





public String getOrder_name() {
	return order_name;
}





public void setOrder_name(String order_name) {
	this.order_name = order_name;
}





public String getAddress() {
	return address;
}





public void setAddress(String address) {
	this.address = address;
}





public String getNumber() {
	return number;
}





public void setNumber(String number) {
	this.number = number;
}





public String getAlternateNumber() {
	return alternateNumber;
}





public void setAlternateNumber(String alternateNumber) {
	this.alternateNumber = alternateNumber;
}





public String getProduct_name() {
	return product_name;
}





public void setProduct_name(String product_name) {
	this.product_name = product_name;
}





public int getAmount() {
	return amount;
}





public void setAmount(int amount) {
	this.amount = amount;
}

















}
