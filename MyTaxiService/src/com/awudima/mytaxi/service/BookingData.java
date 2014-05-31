/**
 * 
 */
package com.awudima.mytaxi.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.awudima.mytaxi.dao.BookingDAO;
import com.awudima.mytaxi.model.Booking;

/**
 * @author kemele
 *
 */
@Path("/booking")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_XML})
public class BookingData {

	BookingDAO bookingDAO = new BookingDAO();
	
	@GET
	public Booking book(Booking book){
		try{
			return bookingDAO.addBooking(book);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@PUT
	public Booking updateBooking(Booking book){
		try{
			return bookingDAO.update(book);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@DELETE
	@Path("{id}")
	public String delete(@PathParam("id")int id){
		try{
			return "" + bookingDAO.delete(id);
		}catch(Exception e){
			e.printStackTrace();
			return false+"";
		}

	}
	
	@GET
	@Path("{id}")
	public Booking getBooking(@PathParam("id")int id){
		try{
			return bookingDAO.getBooking(id);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}

	}
	
	
	/**
	 * All Bookings 
	 */
	@GET
	@Path("all")
	public List<Booking> getAll(){
		try{
			return bookingDAO.getAll();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@GET
	@Path("all/{usertype}/{status}")
	public List<Booking> getBookings(@PathParam("status")int status, @PathParam("usertype")int userType ,@QueryParam("phone")String phone){
		try{
			return bookingDAO.getAll(status, phone, userType);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@GET
	@Path("all/{usertype}")
	public List<Booking> getBookings(@PathParam("usertype")int userType, @QueryParam("phone")String phone){
		try{
			return bookingDAO.getAll(phone, userType);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
