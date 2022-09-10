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
	@Column(name="cat_id")
	private int catId;
	@Column(length=20,name="cat_name")
	private String catName;
	@Column(length=50,name="cat_desc")
	private String catDesc;
}
