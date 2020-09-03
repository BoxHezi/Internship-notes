import org.junit.*;

import static org.junit.Assert.assertEquals;

public class JunitTest01 {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before this whole class is executed");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("After this whole class is executed");
    }

    @Before
    public void before() {
        System.out.println("Before a Test is executed");
    }

    @After
    public void after() {
        System.out.println("After a Test is executed");
    }

    @Test
    public void test1() {
        String myStr = "hello world";
        assertEquals(11, myStr.length());
    }

    @Test
    public void test2() {
        int a = 1, b = 2;
//        assertEquals(2, a + b);
        assertEquals(3, a + b);
    }
    
}
