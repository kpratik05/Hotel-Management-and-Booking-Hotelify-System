package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="room_category")
@Getter
@Setter
@ToString
public class RoomCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cat_id;
	@Column(length=20)
	private String cat_name;
	@Column(length=50)
	private String cat_desc;
}
