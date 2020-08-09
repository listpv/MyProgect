package Task1;

import Task1.ArrayAfterFour;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class MassTestTask1
{
    private ArrayAfterFour arrayAfterFour;
    private int[] mass;

    @Parameterized.Parameters
    public static Collection<int[]> data()
    {
        return Arrays.asList(new int[][]{
                (new int[]{1, 2, 3, 4, 5, 6, 7}),
                (new int[]{1, 2, 3, 4, 5, 4, 7}),
                (new int[]{1, 2, 3, 8, 5, 6, 7}),
                (new int[]{1, 2, 3, 9, 5, 6, 7}),
        });
    }

    public MassTestTask1(int... mass) {
        this.mass = mass;
    }

    @Before
    public void init()
    {
        arrayAfterFour = new ArrayAfterFour();
    }

    @Test(expected = RuntimeException.class)
    public void test()
    {
        arrayAfterFour.arrayTo(mass);
    }
}
