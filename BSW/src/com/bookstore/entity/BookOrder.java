package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BookOrder generated by hbm2java
 */
@Entity
@Table(name = "book_order", catalog = "boobkstore")
public class BookOrder implements java.io.Serializable {

	private Integer bookOrderId;
	private Customer customer;
	private Date bookOrderDate;
	private Float bookOrderTotal;
	private String bookOrderStatus;
	private String bookOrderShippingAddress;
	private String bookOrderPaymentMethod;
	private String bookOrderReciptName;
	private String bookOrderReciptPhone;
	private Set<BookOrderDetail> bookOrderDetails = new HashSet<BookOrderDetail>(0);

	public BookOrder() {
	}

	public BookOrder(Date bookOrderDate) {
		this.bookOrderDate = bookOrderDate;
	}

	public BookOrder(Customer customer, Date bookOrderDate, Float bookOrderTotal, String bookOrderStatus,
			String bookOrderShippingAddress, String bookOrderPaymentMethod, String bookOrderReciptName,
			String bookOrderReciptPhone, Set<BookOrderDetail> bookOrderDetails) {
		this.customer = customer;
		this.bookOrderDate = bookOrderDate;
		this.bookOrderTotal = bookOrderTotal;
		this.bookOrderStatus = bookOrderStatus;
		this.bookOrderShippingAddress = bookOrderShippingAddress;
		this.bookOrderPaymentMethod = bookOrderPaymentMethod;
		this.bookOrderReciptName = bookOrderReciptName;
		this.bookOrderReciptPhone = bookOrderReciptPhone;
		this.bookOrderDetails = bookOrderDetails;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "BOOK_ORDER_ID", unique = true, nullable = false)
	public Integer getBookOrderId() {
		return this.bookOrderId;
	}

	public void setBookOrderId(Integer bookOrderId) {
		this.bookOrderId = bookOrderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ORDER_CUSTOMER_ID")
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "BOOK_ORDER_DATE", nullable = false, length = 19)
	public Date getBookOrderDate() {
		return this.bookOrderDate;
	}

	public void setBookOrderDate(Date bookOrderDate) {
		this.bookOrderDate = bookOrderDate;
	}

	@Column(name = "BOOK_ORDER_TOTAL", precision = 12, scale = 0)
	public Float getBookOrderTotal() {
		return this.bookOrderTotal;
	}

	public void setBookOrderTotal(Float bookOrderTotal) {
		this.bookOrderTotal = bookOrderTotal;
	}

	@Column(name = "BOOK_ORDER_STATUS", length = 20)
	public String getBookOrderStatus() {
		return this.bookOrderStatus;
	}

	public void setBookOrderStatus(String bookOrderStatus) {
		this.bookOrderStatus = bookOrderStatus;
	}

	@Column(name = "BOOK_ORDER_SHIPPING_ADDRESS", length = 256)
	public String getBookOrderShippingAddress() {
		return this.bookOrderShippingAddress;
	}

	public void setBookOrderShippingAddress(String bookOrderShippingAddress) {
		this.bookOrderShippingAddress = bookOrderShippingAddress;
	}

	@Column(name = "BOOK_ORDER_PAYMENT_METHOD", length = 20)
	public String getBookOrderPaymentMethod() {
		return this.bookOrderPaymentMethod;
	}

	public void setBookOrderPaymentMethod(String bookOrderPaymentMethod) {
		this.bookOrderPaymentMethod = bookOrderPaymentMethod;
	}

	@Column(name = "BOOK_ORDER_RECIPT_NAME", length = 30)
	public String getBookOrderReciptName() {
		return this.bookOrderReciptName;
	}

	public void setBookOrderReciptName(String bookOrderReciptName) {
		this.bookOrderReciptName = bookOrderReciptName;
	}

	@Column(name = "BOOK_ORDER_RECIPT_PHONE", length = 10)
	public String getBookOrderReciptPhone() {
		return this.bookOrderReciptPhone;
	}

	public void setBookOrderReciptPhone(String bookOrderReciptPhone) {
		this.bookOrderReciptPhone = bookOrderReciptPhone;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bookOrder")
	public Set<BookOrderDetail> getBookOrderDetails() {
		return this.bookOrderDetails;
	}

	public void setBookOrderDetails(Set<BookOrderDetail> bookOrderDetails) {
		this.bookOrderDetails = bookOrderDetails;
	}

}
