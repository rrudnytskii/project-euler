package The10001stPrime;

import java.util.ArrayList;
import java.util.List;

//  Выписав первые шесть простых чисел, получим 2, 3, 5, 7, 11 и 13. Очевидно, что 6-ое простое число - 13.
//  Какое число является 10001-ым простым числом?
public class App00 {
    public static void main(String[] args) {
        int maxPrimeNumberPosition = 10001;
        long currentNumber = 1;
        List<Long> primeNumbersList = new ArrayList<>();
        long start = System.currentTimeMillis();
        while(primeNumbersList.size() < maxPrimeNumberPosition){
            currentNumber++;
            if(currentNumber >> 1 != 0) {
                if (primeNumbersList.size() != 0) {
                    if (!isNotPrimeNumber(currentNumber, primeNumbersList)) {
                        primeNumbersList.add(currentNumber);
                    }
                } else {
                    primeNumbersList.add(currentNumber);
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("What is the 10 001st prime number? - "+currentNumber+" at time "+(end - start)/1000+"s");
    }

    private static boolean isNotPrimeNumber(long number,List<Long> primeNumberList){
        return primeNumberList.stream()
                .anyMatch(divisor -> number % divisor == 0);
    }
}
