package com.app.dto;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomDTO {
	@JsonProperty("id")
	private int roomId;
	@NotBlank(message="Check in date should be mentioned")
	private String roomNum;
	@NotBlank(message="Floor number should be mentioned")
	private int floorNum;
	@NotBlank(message="Unit price should be mentioned")
	private double unitPrice;
	@NotBlank(message="room category should be mentioned")
	private String roomCategory;
}
