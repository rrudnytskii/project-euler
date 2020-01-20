package Under10Percent.SmallestMultiple;

/*  2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
    Какое самое маленькое число делится нацело на все числа от 1 до 20?*/
public class App00 {
    public static void main(String[] args) {
        int maxvalue = 20;
        System.out.println("The smallest positive number that is evenly divisible by all of the numbers from 1 to "+maxvalue+": "+smallestMultiple(maxvalue));
    }

    private static long smallestMultiple(int maxNumberOfInterval){
        boolean isWorking = true;
        int resultNumber = maxNumberOfInterval;
        while(isWorking) {
            for (int i = maxNumberOfInterval; i > 1; i--) {
                if (resultNumber % i != 0){
                    resultNumber++;
                    break;
                }else if(i == 2){
                    isWorking = false;
                }
            }
        }
        return resultNumber;
    }
}
