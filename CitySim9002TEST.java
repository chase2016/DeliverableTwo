import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class CitySim9002TEST {
			
	@Mock
	Visitor mockedVisitor = Mockito.mock(Visitor.class);
	CitySim9002 mockedCitySim = Mockito.mock(CitySim9002.class);
	
	@Before
	public void setUp() throws Exception {
		// If you use @Mock, you need to do this
		MockitoAnnotations.initMocks(mockedVisitor);
		MockitoAnnotations.initMocks(mockedCitySim);
		
	}

	@After
	public void tearDown() throws Exception {
		// any necessary teardown - none needed here
	}	
	
	// test checkArgument 
		//is the method true
		@Test
		public void testCheckArgument1() {
			String a="1";
			CitySim9002 input=new CitySim9002();
			assertTrue(input.checkArgument(a));
		}
	
		// test checkArgument 
		//is the method not an int 
		@Test
		public void testCheckArgument2() {
			String a="a";
			CitySim9002 input=new CitySim9002();
			assertFalse(input.checkArgument(a));
		}

		// test checkArgument
		//this is for multiple ints
		@Test
		public void testCheckArgument3() {
			String a="2 4";
			CitySim9002 input=new CitySim9002();
			assertFalse(input.checkArgument(a));
		}
		
		// test checkArgument
				//this for negative int
				@Test
				public void testCheckArgument4() {
					String a="-2";
					CitySim9002 input=new CitySim9002();
					assertFalse(input.checkArgument(a));
				}
				
				// test checkArgument
				//this is for fake int
				@Test
				public void testCheckArgument5() {
					String a="0";
					CitySim9002 input=new CitySim9002();
					assertFalse(input.checkArgument(a));
				}
				
				// test checkArgument
				//this is fake objects
				@Test
				public void testCheckArgument6() {
					String a=" ";
					CitySim9002 input=new CitySim9002();
					assertFalse(input.checkArgument(a));
				}
		
}

