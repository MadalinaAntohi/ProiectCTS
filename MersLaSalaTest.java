import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clase.MersLaSala;
import clase.Sala;
import junit.framework.TestCase;
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.containsString;

public class MersLaSalaTest extends TestCase{

	MersLaSala sala = new MersLaSala(true, 30, 30);
	@Test
	public void test(){
		
		assertEquals(sala.megeLaSala(true),  31);
	}
	
	@Test
	public void test2(){
		
		Assert.assertThat(sala.verifica(3), containsString(" ati mers destul"));
	}
	
	
	@Test
	public void test3()
	{
		Sala s = new Sala(20 , "bicicleta");
		assertTrue(sala.lucreazaAparat(s));
		
	}
	@Before
	public void setUp(){
		System.out.println(" Set Up");
	}
	
	@Test
	public void test4(){
		MersLaSala mersLaSala = new MersLaSala(true, 20, 20);
		assertEquals(mersLaSala.getNrOrePeSapt(), 20);
	}
	
	public void test5(){
		assertEquals(sala.getNrZilePeSapt(), 30);
	}
}
