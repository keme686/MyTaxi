package com.awudima.mytaxi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the passenger database table.
 * 
 */
@Entity
@NamedQuery(name="Passenger.findAll", query="SELECT p FROM Passenger p")
@XmlRootElement
public class Passenger implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String phoneNumber;

	private String address;

	private Timestamp created;

	private String name;

	private String photoUrl;

	//bi-directional many-to-one association to Booking
	@OneToMany(mappedBy="passenger")
	private List<Booking> bookings;

	//bi-directional many-to-one association to Favorite
	@OneToMany(mappedBy="passenger")
	private List<Favorite> favorites;

	//bi-directional many-to-one association to Feedback
	@OneToMany(mappedBy="passenger")
	private List<Feedback> feedbacks;

	//bi-directional many-to-one association to Rating
	@OneToMany(mappedBy="passenger")
	private List<Rating> ratings;

	public Passenger() {
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
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

	public List<Booking> getBookings() {
		return this.bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public Booking addBooking(Booking booking) {
		getBookings().add(booking);
		booking.setPassenger(this);

		return booking;
	}

	public Booking removeBooking(Booking booking) {
		getBookings().remove(booking);
		booking.setPassenger(null);

		return booking;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setPassenger(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setPassenger(null);

		return favorite;
	}

	public List<Feedback> getFeedbacks() {
		return this.feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Feedback addFeedback(Feedback feedback) {
		getFeedbacks().add(feedback);
		feedback.setPassenger(this);

		return feedback;
	}

	public Feedback removeFeedback(Feedback feedback) {
		getFeedbacks().remove(feedback);
		feedback.setPassenger(null);

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
		rating.setPassenger(this);

		return rating;
	}

	public Rating removeRating(Rating rating) {
		getRatings().remove(rating);
		rating.setPassenger(null);

		return rating;
	}

}