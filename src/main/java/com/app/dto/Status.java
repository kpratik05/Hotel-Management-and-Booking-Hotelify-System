package com.app.dto;
import javax.persistence.Embeddable;

@Embeddable
public enum Status {
	BOOKED,CANCELLED,EXTENDED
}
