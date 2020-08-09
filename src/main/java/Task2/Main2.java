package Task2;

//        2. Написать метод, который проверяет состав массива из чисел 1 и 4.
//        Если в нем нет хоть одной четверки или единицы, то метод вернет false;
//        Написать набор тестов для этого метода (по 3-4 варианта входных данных).
public class Main2
{
    public static void main(String[] args)
    {
        // write your code here

        ArrayOneOreFour arrayOneOreFour = new ArrayOneOreFour();
        System.out.println(arrayOneOreFour.checkArray(new int[]{4, 5, 1, 4}));
        System.out.println(arrayOneOreFour.checkArray(new int[]{4, 1, 1, 4}));
        System.out.println(arrayOneOreFour.checkArray(new int[]{4, 4, 4, 4}));
        System.out.println(arrayOneOreFour.checkArray(new int[]{1, 1, 1, 1}));

    }
}
