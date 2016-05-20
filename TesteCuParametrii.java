import static org.junit.Assert.*;

import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import clase.IstoricProteine;
import clase.NotifiesStub;

@RunWith(Parameterized.class)
public class TesteCuParametrii {

	private static IstoricProteine istoric = new IstoricProteine(new NotifiesStub());
	private int input;
	private int expected;
	
	@Parameters
	 public static List<Object[]> data(){
		 return Arrays.asList(new Object[][]{
			 {5,5},
			 {5,10},
			 {-12,0},
			 {50, 50},
			 {1,51}
		 });
	 }
	 
	 
	 
	public TesteCuParametrii(int input, int expected) {
		super();
		this.input = input;
		this.expected = expected;
	}



	@Test
	public void test() {
		
		if(input >= 0)
			 istoric.adaugaProteine(input);
	 else istoric.sterge(-input); 
	 
	 assertEquals(expected, istoric.getTotal());
}
	
	}


