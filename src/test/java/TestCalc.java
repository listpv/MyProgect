import org.junit.*;

public class TestCalc
{
    Calculator calculator;

    @Before
    public void init() {
        System.out.println("init");
        calculator = new Calculator();
    }

    @Test
    public void test1() {
        Assert.assertEquals(1, calculator.add(1,2));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, calculator.add(2,2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(6, calculator.add(3,3));
    }

    @Test(expected = ArithmeticException.class, timeout = 2000)
    @Ignore(value = "Не хочу ждать 30 мин")
    public void testDiv1() {
        calculator.div(10,0);
    }

    @After
    public void shutdown() {
        System.out.println("end!");
    }
}
