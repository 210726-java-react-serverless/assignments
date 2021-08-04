package Services;

import com.Revature.Jamaal_Smith_P0_Project.Services.ScreenRouter;
import org.junit.*;

public class ScreenRouterTestCase {

    ScreenRouter sut;

    @BeforeClass
    public static void setUpSuite() {
        System.out.println("just seeing if this works");

    }

    @AfterClass
    public static void tearDownSuite() {
        System.out.println("looks like it works");

    }

    @Before
    public void beforeEachTest() {
        sut = new ScreenRouter();

    }

    @After
    public void afterEachTest() {
        sut = null;

    }

    @Test
    public void isScreenRouterFine_WhenRealScreenIsGiven() {

    }
}


