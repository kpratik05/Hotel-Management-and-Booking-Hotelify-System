package com.app.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CheckRoomDTO {
	private LocalDate checkInDate;
	private LocalDate checkOutDate;
	private int sort;
	private int roomType;
}
