package housekeeping;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GardeningServiceTestConfig.class)
@DirtiesContext
public class GardeningServiceTest {
	@Autowired
	private GardeningService gardener;
	@Autowired
	private GardeningToolMock mock;

	@Test
	public void testDoJob() {
		gardener.garden();
		Assert.assertTrue(mock.isCalled());
	}
}
