import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*; 

import java.util.*;

public class CitySim900Test {
	
	@SuppressWarnings("unchecked")
	
	@Mock
	Location mockLocation = Mockito.mock(Location.class);
	driver mockdriver = Mockito.mock(driver.class);


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(mockLocation);
		MockitoAnnotations.initMocks(mockdriver);
	}

	@After 
	public void tearDown() throws Exception {
		//Any necessary tear downs go here.
	}
	
	/*********************Location.class*********************************/
	
	@Test
	//Tests that if a Location is instantiated and no outStreets are
	//specified, the outStreet1 is null
	public void LocationStreet1Null(){
		Location noStreet = new Location();
		assertNull(noStreet.outStreet1);
	}
	
	@Test
	//Tests that if a Location is instantiated and no outStreets are
	//specified, the outStreet2 is null
	public void LocationStreet2Null(){
		Location noStreet = new Location();
		assertNull(noStreet.outStreet2);
	}
	
	@Test
	//Tests that is a location is instantiated and no name is specified,
	//the location name is null
	public void LocationNameNull(){
		Location noName = new Location();
		assertNull(noName.name);
	}
	
	@Test
	//Tests that is a location is instantiated and no options are specified,
	//option1 is null
	public void LocationOption1Null(){
		Location noName = new Location();
		assertNull(noName.option1);
	}
	
	@Test
	//Tests that is a location is instantiated and no options are specified,
	//option1 is null
	public void LocationOption2Null(){
		Location noName = new Location();
		assertNull(noName.option2);
	}
	
	@Test
	//Tests that when a location "Outside City" is passed 
	//the Location.leave() method returns true
	public void LocationOutsideLeave(){
		Location loc = new Location();
		loc.name = "Outside City";
		
		driver mockDrv = Mockito.mock(driver.class);
		
		Boolean response = loc.leave(mockDrv);
		assertTrue(response);
	}
	
	@Test
	//Tests that when a location other than "Outside City" is passed 
	//the Location.leave() method returns false
	public void LocationNotOutsideLeave(){
		Location loc = new Location();
		loc.name = "Mall";
		
		driver mockDrv = Mockito.mock(driver.class);
		
		Boolean response = loc.leave(mockDrv);
		assertFalse(response);
	}

	@Test
	//Tests that when a null driver is passed to the printOutput method 
	//of a null location, it returns a null pointer exception
	public void LocationPrintOutputNull(){
		Location loc = new Location();
		driver drv = Mockito.mock(driver.class);
		try{
			String response = loc.printOutput(drv);
			fail();
		}
		catch (Exception e){
			
		}
	}
	
	//Tests that with given input, printOutput method
	//returns expected output
	@Test
	public void LocationPrintOutput(){
		Location start = new Location();
		Location option1 = new Location();
		Location option2 = new Location();
		Location next = new Location();
		driver drv = new driver();
		
		next.name = "University";
		start.name = "Outside City";
		start.option1 = option1;
		start.option2 = option2;
		start.option1.name = "Universiy";
		start.option2.name = "Mall";
		start.outStreet2 = "Fifth Ave.";
		start.outStreet1  = "Fourth Ave.";
		
		drv.start = start;
		drv.id = 1;
		
		String response = next.printOutput(drv);
		assertEquals(response, "Driver 1 heading from Outside City to University via Fifth Ave.");
				
	}
	
	/**********************driver.class**************************/
	
	@Test
	//Tests that when a driver is instantiated, id is 0
	public void DriverIDNull(){
		driver drv = new driver();
		assertEquals(drv.id, 0);
	}
	
	@Test
	//Tests that when a driver is instantiated, start is null
	public void DriverStartNull(){
		driver drv = new driver();
		assertNull(drv.start);
	}
	
	@Test
	//Tests that when a driver is instantiated, start is null
	public void DriverNextNull(){
		driver drv = new driver();
		assertNull(drv.next);
	}
	
	@Test
	//Tests that when a driver is given next,
	//method move() sets start to next
	public void DriverMove(){
		driver drv = new driver();
		drv.next = new Location();
		drv.next.name = "Mall";
		drv.move();
		assertEquals(drv.start.name, "Mall");
	}
	
	@Test
	//Tests that when a driver has known seed, next move is predictable
	public void DriverNextKnown(){
		driver drv = new driver();
		drv.start = new Location();
		drv.start.name = "Outside";
		drv.start.option1 = new Location();
		drv.start.option1.name = "Mall";
		drv.start.option2 = new Location();
		drv.start.option2.name = "University";

		
		Random mockRand = Mockito.mock(Random.class);
		Mockito.when((mockRand.nextInt())).thenReturn(1);

		Location pick = drv.PickMove(mockRand.nextInt());
		assertEquals(pick.name, "University");
	}
	
	/**********************map.class*****************************/
	@Test
	//Tests that the populate method returns the output
	//That is not null
	public void mapPopulateNull(){
		 	
	 	map test = new map();
	 	ArrayList<Location> testlist = test.populate();
	 	
	 	assertNotNull(testlist);
	}
	
	@Test
	//Tests that when a Location has known seed, the PickStart
	//method returns a predictable value
	public void PickStartKnown(){
		map test = new map();
		test.populate();
		
		Random mockRand = Mockito.mock(Random.class);
		Mockito.when((mockRand.nextInt())).thenReturn(1);

		Location pick = test.PickStart(mockRand.nextInt());
		assertEquals(pick.name, "Mall");
	
	}
}
