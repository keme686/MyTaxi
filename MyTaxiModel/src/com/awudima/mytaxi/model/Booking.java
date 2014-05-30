package com.awudima.mytaxi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the booking database table.
 * 
 */
@Entity
@NamedQuery(name="Booking.findAll", query="SELECT b FROM Booking b")
@XmlRootElement
public class Booking implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String bfrom;

	private String bto;

	private String carPlateNumber;

	private String noteToDriver;

	private String pickupLocation;

	private Timestamp pickuptime;

	private String pricing;

	private String privacy;

	private String status;

	private Timestamp statusUpdateTime;

	//bi-directional many-to-one association to Driver
	@ManyToOne
	@JoinColumn(name="driverPhone")
	private Driver driver;

	//bi-directional many-to-one association to Passenger
	@ManyToOne
	@JoinColumn(name="passengerPhone")
	private Passenger passenger;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="booking")
	private List<Feedback> feedbacks;

	public Booking() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBfrom() {
		return this.bfrom;
	}

	public void setBfrom(String bfrom) {
		this.bfrom = bfrom;
	}

	public String getBto() {
		return this.bto;
	}

	public void setBto(String bto) {
		this.bto = bto;
	}

	public String getCarPlateNumber() {
		return this.carPlateNumber;
	}

	public void setCarPlateNumber(String carPlateNumber) {
		this.carPlateNumber = carPlateNumber;
	}

	public String getNoteToDriver() {
		return this.noteToDriver;
	}

	public void setNoteToDriver(String noteToDriver) {
		this.noteToDriver = noteToDriver;
	}

	public String getPickupLocation() {
		return this.pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public Timestamp getPickuptime() {
		return this.pickuptime;
	}

	public void setPickuptime(Timestamp pickuptime) {
		this.pickuptime = pickuptime;
	}

	public String getPricing() {
		return this.pricing;
	}

	public void setPricing(String pricing) {
		this.pricing = pricing;
	}

	public String getPrivacy() {
		return this.privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getStatusUpdateTime() {
		return this.statusUpdateTime;
	}

	public void setStatusUpdateTime(Timestamp statusUpdateTime) {
		this.statusUpdateTime = statusUpdateTime;
	}

	public Driver getDriver() {
		return this.driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setBooking(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setBooking(null);

		return feedback;
	}

}