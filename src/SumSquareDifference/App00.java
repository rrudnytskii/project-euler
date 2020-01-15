package SumSquareDifference;

//        Сумма квадратов первых десяти натуральных чисел равна
//
//        12 + 22 + ... + 102 = 385
//        Квадрат суммы первых десяти натуральных чисел равен
//
//        (1 + 2 + ... + 10)2 = 552 = 3025
//        Следовательно, разность между суммой квадратов и квадратом суммы первых десяти натуральных чисел составляет 3025 − 385 = 2640.
//        Найдите разность между суммой квадратов и квадратом суммы первых ста натуральных чисел.
public class App00 {
    public static void main(String[] args) {
        int number = 100;
        System.out.println("The difference between the sum of the squares of the first "+number+" natural numbers and the square of the sum is :"+getSumSquareDifferenceOfNumber(number));
    }

    private static long getSumSquareDifferenceOfNumber(int number){
        long sumOfSquares = 0;
        long squaredSum = 0;
        for(int i = 1; i <= number; i++){
            sumOfSquares += i;
            squaredSum += i*i;
        }
        return  sumOfSquares*sumOfSquares - squaredSum;
    }
}
