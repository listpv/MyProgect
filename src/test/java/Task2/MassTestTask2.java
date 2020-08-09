package Task2;

import Task2.ArrayOneOreFour;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MassTestTask2
{
    private ArrayOneOreFour arrayOneOreFour;
    private int[] mass;

    @Parameterized.Parameters
    public static Collection<int[]> data()
    {
        return Arrays.asList(new int[][]{
                (new int[]{1, 1, 1, 4, 1, 4, 4}),
                (new int[]{1, 2, 1, 4, 1, 4, 1}),
                (new int[]{1, 1, 1, 1, 1, 1, 1}),
                (new int[]{4, 4, 4, 4, 4, 4, 4}),
        });
    }

    public MassTestTask2(int... mass) {
        this.mass = mass;
    }

    @Before
    public void init()
    {
        arrayOneOreFour = new ArrayOneOreFour();
    }

    @Test
    public void test()
    {
            Assert.assertTrue(arrayOneOreFour.checkArray(mass));
    }
}
