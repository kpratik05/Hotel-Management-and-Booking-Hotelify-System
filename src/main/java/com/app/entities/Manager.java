package com.app.entities;

import javax.persistence.*;
import lombok.*;

@Entity
@Table(name="manager")
@Getter
@Setter
@ToString
public class Manager extends Employee {
	
}	
