package com.bookstore.entity;
// Generated 25 Jan, 2020 4:13:21 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * BookOrderDetail generated by hbm2java
 */
@Entity
@Table(name = "book_order_detail", catalog = "boobkstore")
public class BookOrderDetail implements java.io.Serializable {

	private Integer bookOrderDetailId;
	private Book book;
	private BookOrder bookOrder;
	private Integer bookOrderDetailQuantity;
	private Integer bookOrderDetailSubTotal;

	public BookOrderDetail() {
	}

	public BookOrderDetail(Book book, BookOrder bookOrder, Integer bookOrderDetailQuantity,
			Integer bookOrderDetailSubTotal) {
		this.book = book;
		this.bookOrder = bookOrder;
		this.bookOrderDetailQuantity = bookOrderDetailQuantity;
		this.bookOrderDetailSubTotal = bookOrderDetailSubTotal;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "BOOK_ORDER_DETAIL_ID", unique = true, nullable = false)
	public Integer getBookOrderDetailId() {
		return this.bookOrderDetailId;
	}

	public void setBookOrderDetailId(Integer bookOrderDetailId) {
		this.bookOrderDetailId = bookOrderDetailId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ORDER_DETAIL_BOOK_ID")
	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BOOK_ORDER_DETAIL_ORDER_ID")
	public BookOrder getBookOrder() {
		return this.bookOrder;
	}

	public void setBookOrder(BookOrder bookOrder) {
		this.bookOrder = bookOrder;
	}

	@Column(name = "BOOK_ORDER_DETAIL_QUANTITY")
	public Integer getBookOrderDetailQuantity() {
		return this.bookOrderDetailQuantity;
	}

	public void setBookOrderDetailQuantity(Integer bookOrderDetailQuantity) {
		this.bookOrderDetailQuantity = bookOrderDetailQuantity;
	}

	@Column(name = "BOOK_ORDER_DETAIL_SUB_TOTAL")
	public Integer getBookOrderDetailSubTotal() {
		return this.bookOrderDetailSubTotal;
	}

	public void setBookOrderDetailSubTotal(Integer bookOrderDetailSubTotal) {
		this.bookOrderDetailSubTotal = bookOrderDetailSubTotal;
	}

}
