package com.app.dto;
import javax.validation.constraints.NotBlank;

import com.app.entities.RoomCategory;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomActualDTO {
	@JsonProperty("id")
	private int roomId;
	@NotBlank(message="Check in date should be mentioned")
	private String roomNum;
	@NotBlank(message="Floor number should be mentioned")
	private int floorNum;
	@NotBlank(message="Unit price should be mentioned")
	private double unitPrice;
	
	private RoomCategory roomCategory;
}
