/**
 * 
 */
package com.awudima.mytaxi.service.test;

import static org.junit.Assert.*;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.awudima.mytaxi.model.Passenger;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author kemele
 *
 */
public class PassengerDataTest {

	WebResource service;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    service = client.resource(UriBuilder.fromUri("http://localhost:5900/").build());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.PassengerData#addPassenger(com.awudima.mytaxi.model.Passenger)}.
	 */
	@Test
	public void testAddPassenger() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.PassengerData#updatePassenger(com.awudima.mytaxi.model.Passenger)}.
	 */
	@Test
	public void testUpdatePassenger() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.PassengerData#deletePassenger(java.lang.String)}.
	 */
	@Test
	public void testDeletePassenger() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.PassengerData#getPassenger(java.lang.String)}.
	 */
	@Test
	public void testGetPassenger() {
		Passenger p = service.path("passenger").path("%2B33626076455").accept(MediaType.APPLICATION_JSON).get(Passenger.class);
		assertNotNull(p);
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.PassengerData#getAll()}.
	 */
	@Test
	public void testGetAll() {
		fail("Not yet implemented");
	}

}
