package com.awudima.mytaxi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the taxi database table.
 * 
 */
@Entity
@NamedQuery(name="Taxi.findAll", query="SELECT t FROM Taxi t")

@XmlRootElement
public class Taxi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int passengerCapacity;

	private String plateNum;

	private String taxiType;

	@Lob
	private String workingTimeFrom;

	@Lob
	private String workingTimeTo;

	
	public Taxi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}

	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}

	public String getPlateNum() {
		return this.plateNum;
	}

	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}

	public String getTaxiType() {
		return this.taxiType;
	}

	public void setTaxiType(String taxiType) {
		this.taxiType = taxiType;
	}

	public String getWorkingTimeFrom() {
		return this.workingTimeFrom;
	}

	public void setWorkingTimeFrom(String workingTimeFrom) {
		this.workingTimeFrom = workingTimeFrom;
	}

	public String getWorkingTimeTo() {
		return this.workingTimeTo;
	}

	public void setWorkingTimeTo(String workingTimeTo) {
		this.workingTimeTo = workingTimeTo;
	}
}