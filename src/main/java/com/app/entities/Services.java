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
@Table(name="services")
@Getter
@Setter
@ToString
public class Services {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="service_id")
	private int serivecId;
	@Column(length=20,name="service_name")
	private String serviceName;
	@Column(length=50,name="service_name")
	private String serviceDesc;
	@Column(name="service_unit_price")
	private double serviceUnitPrice;
}
