package com.hibernate.guigu.n21.model;

public class Customer {
	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;

	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	private Integer customerId;
	private String customerName;

}
