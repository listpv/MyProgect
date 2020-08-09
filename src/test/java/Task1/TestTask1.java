package Task1;

import Task1.ArrayAfterFour;
import org.junit.*;

public class TestTask1
{
    ArrayAfterFour arrayAfterFour;

    @Before
    public void init()
    {
        arrayAfterFour = new ArrayAfterFour();
    }

    @Test(expected = RuntimeException.class)
    public void test()
    {
        int[] mass = {1, 2, 9, 7, 4, 3, 7, 1, 2};
        arrayAfterFour.arrayTo(mass);
    }



}
