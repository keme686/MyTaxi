package com.awudima.mytaxi.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the favorites database table.
 * 
 */
@Entity
@Table(name="favorites")
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
@XmlRootElement
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String favoriteValue;

	private String favoriteWhat;

	//bi-directional many-to-one association to Passenger
	@ManyToOne
	@JoinColumn(name="passengerPhone")
	private Passenger passenger;

	public Favorite() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFavoriteValue() {
		return this.favoriteValue;
	}

	public void setFavoriteValue(String favoriteValue) {
		this.favoriteValue = favoriteValue;
	}

	public String getFavoriteWhat() {
		return this.favoriteWhat;
	}

	public void setFavoriteWhat(String favoriteWhat) {
		this.favoriteWhat = favoriteWhat;
	}

	public Passenger getPassenger() {
		return this.passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

}