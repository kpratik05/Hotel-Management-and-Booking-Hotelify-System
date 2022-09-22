package com.app.dto;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceOrders {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	@Column(name="order_date")
	@NotNull
	private LocalDate orderDate;
	@Column(name="order_time")
	@NotNull
	private Time orderTime;
	@Column(name="order_amount")
	@NotNull
	private double orderAmount;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="map_id")
	@NotNull
	private BookingMap bookingMap;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="service_id")
	@NotNull
	private Services service;
}
