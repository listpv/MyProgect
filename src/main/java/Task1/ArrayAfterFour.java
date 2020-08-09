package Task1;

import java.util.Arrays;

public class ArrayAfterFour
{

    public void arrayTo(int... mass)
    {
        int var = -1;
        for (int i = 0; i < mass.length; i++)
        {
            if (mass[i] == 4)
            {
                var = i;
            }
        }
        if(var == -1)
        {
//            System.out.println("End");
            throw new RuntimeException("End of All");
        }

                int[] array = new int[mass.length - var - 1];
                for (int i = 0; i < array.length; i++)
                {
                    array[i] = mass[i + var + 1];
                }
                System.out.println(Arrays.toString(array));
    }

}
