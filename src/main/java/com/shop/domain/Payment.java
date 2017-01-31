package com.shop.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Payment {
	@Id
	@GeneratedValue
	private int paymentId;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;
	@NotBlank
	@Pattern(regexp = "\\d{4}[-]\\d{4}[-]\\d{4}[-]\\d{4}", message = "Invalid  card number")
	private String cardNumber;
	@NotBlank
	@Pattern(regexp = "\\d{2}[/]\\d{4}", message = "Invalid  card expiry day")
	private String expiryDate;
	@NotBlank
	@Pattern(regexp = "\\d{3}", message = "Invalid  security code")
	private String securityCode;
	private String paymentDate;
	private double paymentAmount;

	@OneToMany( cascade = CascadeType.ALL)
	private List<OrderInvoice> listInvoice;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public List<OrderInvoice> getListInvoice() {
		return listInvoice;
	}

	public void setListInvoice(List<OrderInvoice> listInvoice) {
		this.listInvoice = listInvoice;
	}

}
