package com.boot;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

public class ShipwreckControllerTest {
	
	@InjectMocks
	private ShipwreckController sc;
	
	@Mock
	private ShipwreckRepository shipwreckRepository;
	
	@Before
	public void init(){	
		System.out.println("init called");
		MockitoAnnotations.initMocks(this);	
		System.out.println("sc value:"+sc);
		System.out.println("shipwreckRepository is:"+ shipwreckRepository);
	}
	
	@Test
	public void testShipwreckGet() { // goal is to get a shipwreck by its id
		
		System.out.println("testShipwreckGet method");
		Shipwreck sw = new Shipwreck();
		sw.setId(1L);
		when(shipwreckRepository.findOne(1L)).thenReturn(sw);
		System.out.println("id:"+sw.getId());
		
		Shipwreck wreck = sc.get(1L);
		System.out.println(wreck);
		
		System.out.println("verifying:"+ verify(shipwreckRepository).findOne(1L));
		// assertEquals(1L, wreck.getId().longValue()); - for Mockito
		
		assertThat(wreck.getId(), is(1L)); // for Hamcrest testing
		
	}
	
}
