import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.lib.concurrent.Synchroniser;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import clase.InvalidGoalException;
import clase.IstoricProteine;
import clase.Notifier;
import clase.NotifiesStub;
import clase.RegimProteine;
import junit.framework.TestCase;

public class IstoricProteineTests extends TestCase {

	@BeforeClass
	public static void before() {
		System.out.println("Before class ");
	}

	@Test
	@Category(GoodTestCategory.class)
	public void test() {
		IstoricProteine istoric = new IstoricProteine(new NotifiesStub());
		assertEquals(" Totalul nu a fost egal cu  0", 0, istoric.getTotal());
	}

	@Test
	@Category({ GoodTestCategory.class })
	public void addProtein() {
		IstoricProteine service = new IstoricProteine(new NotifiesStub());
		service.adaugaProteine(10);
		assertEquals(" Nu a fost corect", 10, service.getTotal());
		assertThat(service.getTotal(), is(10));
		assertThat(service.getTotal(), allOf(is(10), instanceOf(Integer.class)));
	}

	@Before
	public void setUp() {

		System.out.println("Before");
	}

	@After
	public void tearDown() {
		System.out.println("After ");
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void ExceptionTest() throws InvalidGoalException {

		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage("Goal was less than zero");
		IstoricProteine service = new IstoricProteine(new NotifiesStub());
		service.setGoal(-5);
	}

	@SuppressWarnings("deprecation")
	@Rule
	public Timeout timeout = new Timeout(20000);

	@Test
	public void BadTest() {
		IstoricProteine service = new IstoricProteine(new NotifiesStub());
		for (int i = 0; i < 1000000; i++) {
			service.adaugaProteine(100);
		}
	}

	@Test
	public void WhenGoalIsMet() throws InvalidGoalException {
		IstoricProteine istoric;

		Mockery context = new Mockery() {
			{
				setThreadingPolicy(new Synchroniser());
			}
		};
		final Notifier mockNotifier = context.mock(Notifier.class);
		istoric = new IstoricProteine(mockNotifier);
		context.checking(new Expectations() {
			{
				oneOf(mockNotifier).send(" scopul a fost atins");
				will(returnValue(true));
			}
		});

		istoric.setGoal(5);
		istoric.adaugaProteine(6);
		RegimProteine rezultat = istoric.getIstoric().get(1);
		assertEquals("trimite: scop atins", rezultat.getOperatie());

		context.assertIsSatisfied();

	}

	@AfterClass
	public static void after() {
		System.out.println("After class ");

	}
}
