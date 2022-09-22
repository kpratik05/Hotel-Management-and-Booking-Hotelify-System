package com.app.dto;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RoomCategoryDTO {
	@JsonProperty("id")
	private int catId;
	@NotBlank(message="category name can not b blank")
	private String catName;
	@NotBlank(message="category description can not b blank")
	private String catDesc;
}
