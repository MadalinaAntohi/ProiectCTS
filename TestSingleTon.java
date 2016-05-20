import org.junit.Before;
import org.junit.Test;

import clase.Persoana;
import junit.framework.TestCase;

public class TestSingleTon extends TestCase{

	Persoana persoanaSingleton; 
	
	@Before
	public void setUp(){
		persoanaSingleton = Persoana.getInstance();
	}
	
	@Test
	public void test(){
		Persoana persoana =Persoana.getInstance();
		assertEquals(persoanaSingleton, persoana);
	}
}
