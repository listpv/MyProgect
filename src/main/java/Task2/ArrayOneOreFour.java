package Task2;

public class ArrayOneOreFour
{
    public boolean checkArray(int... mass) {
        boolean one = false;
        boolean four = false;
        boolean another = false;

        for (int i = 0; i < mass.length; i++)
        {
            if (mass[i] == 1)
            {
                one = true;
            }
            else if (mass[i] == 4)
            {
                four = true;
            }
            else
                {
                    another = true;
                    break;
                }
        }
        if (another)
        {
            return false;
        }
        else if (one && four)
        {
            return true;
        }
        else
            {
                return false;
            }
    }
}
