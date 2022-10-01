package com.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CustomerDTO extends PersonDTO {
	@JsonProperty("customerId")
	private int customerId;
}
