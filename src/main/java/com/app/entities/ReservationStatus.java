package com.app.entities;

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

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="reservation_status")
@Getter
@Setter
@ToString
public class ReservationStatus {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="res_id")
	private int resId;
	@Column(name="check_in_date")
	private LocalDate checkInDate;
	@Column(name="check_out_date")
	private LocalDate checkOutDate;
	private Status status;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private RoomCategory roomCategory;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	private Room room;
}
