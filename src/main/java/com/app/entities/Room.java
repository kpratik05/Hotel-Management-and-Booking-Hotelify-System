package com.app.entities;
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
@Table(name="room")
@Getter
@Setter
@ToString

public class Room {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int room_id;
	private int floor_num;
	private double unitPrice;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cat_id")
	private RoomCategory roomCategory;
}
