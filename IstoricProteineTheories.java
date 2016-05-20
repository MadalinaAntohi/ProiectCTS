import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.junit.Assume;

import clase.IstoricProteine;
import clase.NotifiesStub;

@RunWith(Theories.class)
public class IstoricProteineTheories {

	@DataPoints
	public static int[] data(){
		return new int[]{
				1, 5 ,10, 15 , 20 , 50, -4
		};
	}
	
	@Theory
	public void valoriPozitive(int val){
		IstoricProteine istoric = new IstoricProteine(new NotifiesStub());
	    istoric.adaugaProteine(val);
	    Assume.assumeTrue(val > 0);
	    assertTrue(istoric.getTotal()>0);
	}
}
