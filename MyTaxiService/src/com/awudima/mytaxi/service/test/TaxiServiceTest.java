/**
 * 
 */
package com.awudima.mytaxi.service.test;

import static org.junit.Assert.*;

import java.net.URI;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.awudima.mytaxi.dao.TaxiDAO;
import com.awudima.mytaxi.model.Taxi;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * @author kemele
 *
 */
public class TaxiServiceTest {

	WebResource service;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ClientConfig config = new DefaultClientConfig();
	    Client client = Client.create(config);
	    service = client.resource(getBaseURI());
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		removeTaxi();
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.TaxiData#addTaxi(com.awudima.mytaxi.model.Taxi)}.
	 */
	@Test
	public void testAddTaxi() {
		Taxi u = insertTaxi();
		 assertNotNull(u);
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.TaxiData#update(com.awudima.mytaxi.model.Taxi)}.
	 */
	@Test
	public void testUpdate() throws Exception{
		Taxi t = TaxiDAO.getInstance().getTaxi(4);
		t.setPlateNum("ET0089");
		Taxi u= service.path("taxi").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).put(Taxi.class, t);
		assertNotNull(u);
		assertTrue(u.getPlateNum().equals("ET0089"));
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.TaxiData#getTaxi(int)}.
	 */
	@Test
	public void testGetTaxi() {
		Taxi u = service.path("taxi").path("1").accept(MediaType.APPLICATION_JSON).get(Taxi.class);
		assertNotNull(u);
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.TaxiData#delete(int)}.
	 */
	@Test
	public void testDelete() throws Exception{
		insertTaxi();
		String bs= service.path("taxi").path("4").accept(MediaType.APPLICATION_JSON).delete(String.class);
		boolean b = Boolean.parseBoolean(bs);
		assertTrue(b);
	}

	/**
	 * Test method for {@link com.awudima.mytaxi.service.TaxiData#getAll()}.
	 */
	@Test
	public void testGetAll() {
		GenericType<List<Taxi>> genericListType =  new GenericType<List<Taxi>>() {};	                
		List<Taxi> u = service.path("taxi").path("all").accept(MediaType.APPLICATION_JSON).get(genericListType);
		
		assertNotNull(u);
		assertNotEquals(0, u.size());
	}

	private Taxi insertTaxi(){
		Taxi t = new Taxi();
		t.setPassengerCapacity(6);
		t.setPlateNum("ET837232");
		t.setTaxiType("Minibus");
		
		return service.path("taxi").path("add").type(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).post(Taxi.class, t);
	}
	
	private boolean removeTaxi() throws Exception{
		List<Taxi> ts = TaxiDAO.getInstance().getAll();
		//int id =0;
		for(Taxi t: ts){
			if(t.getId() > 4)
				TaxiDAO.getInstance().delete(t.getId());
		}
		return true;
	}
	
	/**
	 * 
	 * @return uri - for local service end 
	 */
	private static URI getBaseURI() {
	    return UriBuilder.fromUri("http://localhost:5900/").build();
	}
}
