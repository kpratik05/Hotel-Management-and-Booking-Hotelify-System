package com.app.entities;

import javax.persistence.*;

@Embeddable
public enum Role {
	RECEPTIONIST,MANAGER,ROOMSERVICE,COOK,CLEANING
}
