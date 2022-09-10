package com.app.entities;
import javax.persistence.Embeddable;

@Embeddable
public enum Status {
	BOOKED,CANCELLED,EXTENDED
}
