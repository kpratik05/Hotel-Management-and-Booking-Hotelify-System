package com.app.entities;
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
@Table(name="booking_map")
@Getter
@Setter
@ToString
public class BookingMap {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mapId;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	@NotNull
	private RoomCategory roomCategory;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="room_id")
	@NotNull
	private Room room;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="booking_id")
	@NotNull
	private Booking booking;
}
