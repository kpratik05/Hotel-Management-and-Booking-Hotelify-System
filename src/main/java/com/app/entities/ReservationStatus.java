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
import javax.validation.constraints.NotNull;

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
	@NotNull
	private LocalDate checkInDate;
	@Column(name="check_out_date")
	@NotNull
	private LocalDate checkOutDate;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status")
	private Status status;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	@NotNull
	private RoomCategory roomCategory;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	@NotNull
	private Room room;
}
