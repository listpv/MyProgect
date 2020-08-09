package Task2;

import Task2.ArrayOneOreFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestTask2
{
    ArrayOneOreFour arrayOneOreFour;

    @Before
    public void init()
    {
        arrayOneOreFour = new ArrayOneOreFour();
    }

    @Test
    public void test()
    {
        Assert.assertTrue(arrayOneOreFour.checkArray(new int[]{1, 4, 1, 4}));
    }
}
