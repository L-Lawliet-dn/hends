import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitAnnotationOrderTest {

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("@BeforeClass - Runs once before all test methods");
    }

    @Before
    public void beforeEachTest() {
        System.out.println("@Before - Runs before each test method");
    }

    @Test
    public void firstTest() {
        System.out.println("@Test - First test method");
    }

    @Test
    public void secondTest() {
        System.out.println("@Test - Second test method");
    }

    @After
    public void afterEachTest() {
        System.out.println("@After - Runs after each test method");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("@AfterClass - Runs once after all test methods");
    }
}