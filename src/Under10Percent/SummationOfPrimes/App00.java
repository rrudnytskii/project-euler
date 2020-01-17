package Under10Percent.SummationOfPrimes;

import java.util.ArrayList;
import java.util.List;

//    Сумма простых чисел меньше 10 равна 2 + 3 + 5 + 7 = 17.
//
//    Найдите сумму всех простых чисел меньше двух миллионов.
public class App00 {
    public static void main(String[] args) {
        int maxPrimeIndex = 2000000;
        int resultSum = 1;
        long currentNumber = 1;
        List<Long> primeNumbersList = new ArrayList<>();
        long start = System.currentTimeMillis();
        while (primeNumbersList.size() < maxPrimeIndex) {
            currentNumber++;
            if (currentNumber >> 1 != 0) {
                if (primeNumbersList.size() != 0) {
                    if (!isNotPrimeNumber(currentNumber, primeNumbersList)) {
                        resultSum += currentNumber;
                        primeNumbersList.add(currentNumber);
                    }
                } else {
                    resultSum += currentNumber;
                    primeNumbersList.add(currentNumber);
                }
            }
        }
        System.out.println("the sum of all the primes below two million - "+resultSum);
    }
    private static boolean isNotPrimeNumber(long number,List<Long> primeNumberList){
        long sqrt = (long)Math.sqrt(number);
        return primeNumberList.stream()
                .anyMatch(divisor -> (number % divisor == 0) && (sqrt >= divisor) );
    }
}
