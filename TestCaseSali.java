import org.junit.Test;
import static org.junit.Assert.assertThat;

import org.junit.Assert;

import static org.hamcrest.CoreMatchers.containsString;

import clase.Bazin;
import clase.SalaAerobic;
import clase.SalaFitness;
import junit.framework.TestCase;

public class TestCaseSali extends TestCase {

	@Test
	public void testSalaAerobic(){
		
		SalaAerobic sala= new SalaAerobic();
		Assert.assertThat( sala.verifica(12),containsString(" Sunt locuri "));
		
	}
	
	@Test
	public void testSalaFitness(){
		SalaFitness sala = new SalaFitness();
		Assert.assertThat( sala.verifica(19),containsString(" Sunt locuri "));
	}
	
	@Test
	public void testBazin()
	{
		Bazin bazin = new Bazin();
		Assert.assertThat( bazin.verifica(22),containsString(" Sunt locuri "));
	}
}
