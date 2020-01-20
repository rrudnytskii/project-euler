package Under10Percent.The10001stPrime;

import java.util.ArrayList;
import java.util.List;

//  Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-ое простое число - 13.
//  Какое число является 10001-ым простым числом?
public class App00 {
    public static void main(String[] args) {
        int maxPrimeNumberPosition = 1000000;
        long currentNumber = 1;
        long[] primeNumbersArray = new long[maxPrimeNumberPosition];
        int index = 0;
        primeNumbersArray[index] = 2;
        long start = System.currentTimeMillis();
        while (index < maxPrimeNumberPosition-1) {
            currentNumber +=  2;
            if (isPrimeNumber(currentNumber, primeNumbersArray)) {
                index++;
                primeNumbersArray[index] = currentNumber;
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("What is the 10 001st prime number? - " + currentNumber + " at time " + (end - start) / 1000 + "s");
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
