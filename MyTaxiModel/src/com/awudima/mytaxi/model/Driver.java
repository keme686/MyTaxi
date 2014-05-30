package com.awudima.mytaxi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the driver database table.
 * 
 */
@Entity
@NamedQuery(name="Driver.findAll", query="SELECT d FROM Driver d")
@XmlRootElement
public class Driver implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String phoneNumber;

	private String city;

	private Timestamp created;

	private String currentLatitude;

	private String currentLocation;

	private String currentLongitude;

	private String name;

	private String photoUrl;

	private String woreda;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="driver")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Taxi
	@ManyToOne
	@JoinColumn(name="taxiId")
	private Taxi taxi;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="driver")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="driver")
	private List<Rating> ratings;

	public Driver() {
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getCurrentLatitude() {
		return this.currentLatitude;
	}

	public void setCurrentLatitude(String currentLatitude) {
		this.currentLatitude = currentLatitude;
	}

	public String getCurrentLocation() {
		return this.currentLocation;
	}

	public void setCurrentLocation(String currentLocation) {
		this.currentLocation = currentLocation;
	}

	public String getCurrentLongitude() {
		return this.currentLongitude;
	}

	public void setCurrentLongitude(String currentLongitude) {
		this.currentLongitude = currentLongitude;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhotoUrl() {
		return this.photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getWoreda() {
		return this.woreda;
	}

	public void setWoreda(String woreda) {
		this.woreda = woreda;
	}

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setDriver(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setDriver(null);

		return booking;
	}

	public Taxi getTaxi() {
		return this.taxi;
	}

	public void setTaxi(Taxi taxi) {
		this.taxi = taxi;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setDriver(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setDriver(null);

		return feedback;
	}

	public List<Rating> getRatings() {
		return this.ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public Rating addRating(Rating rating) {
		getRatings().add(rating);
		rating.setDriver(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setDriver(null);

		return rating;
	}

}