package LargestPrimeFactor;

//    Простые делители числа 13195 - это 5, 7, 13 и 29.
//    Каков самый большой делитель числа 600851475143, являющийся простым числом?
public class App00 {
    public static void main(String[] args) {
        long number = 600851475143l;
        System.out.println("Largest Prime Divisor of "+ number+" is "+largestPrimeDivisor(number));
    }

    private static long largestPrimeDivisor(long number){
        long currentDivisor = 0;
        boolean isProcessing = true;
        while(isProcessing) {
            currentDivisor = 2;
            while(number % currentDivisor != 0){
                currentDivisor++;
            }
            if(currentDivisor != number) {
                number = number / currentDivisor;
            }else{
                isProcessing = false;
            }
        }
        return currentDivisor;
    }
}
