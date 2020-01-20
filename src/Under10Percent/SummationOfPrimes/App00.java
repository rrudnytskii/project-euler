package Under10Percent.SummationOfPrimes;

import java.util.ArrayList;
import java.util.List;

//    Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
//
//    Найдите сумму всех простых чисел меньше двух миллионов.
public class App00 {
    public static void main(String[] args) {
        int arraylength = 200000;
        long currentNumber = 1;
        long[] primeNumbersArray = new long[arraylength];
        int index = 0;
        long resultSum = 2;
        primeNumbersArray[index] = 2;
        long start = System.currentTimeMillis();
        boolean isWorking = true;
        while (isWorking) {
            currentNumber += 2;
            if(currentNumber < 2000000) {
                if (isPrimeNumber(currentNumber, primeNumbersArray)) {
                    index++;
                    primeNumbersArray[index] = currentNumber;
                    resultSum += currentNumber;
                }
            }else{
                isWorking = false;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("the sum of all the primes below two million - "+resultSum+" at time " + (end - start) / 1000 + "s");
    }
    private static boolean isPrimeNumber(long number, long[] primeNumbersArray) {
        for (int i = 0; i < primeNumbersArray.length; i++) {
            if (primeNumbersArray[i] != 0 && Math.sqrt(number)+1 >= primeNumbersArray[i] && number % primeNumbersArray[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
