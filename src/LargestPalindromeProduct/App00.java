package LargestPalindromeProduct;

//  Число-палиндром с обеих сторон (справа налево и слева направо) читается одинаково. Самое большое число-палиндром, полученное умножением двух двузначных чисел – 9009 = 91 × 99.
//  Найдите самый большой палиндром, полученный умножением двух трехзначных чисел.
public class App00 {
    public static void main(String[] args) {
        char[] digits = { '0' , '1', '2' ,'3', '4', '5', '6', '7', '8', '9'};
        System.out.println("The largest palindrome made from the product of two 3-digit numbers: "+largestPalindrome(digits));
    }

    private static int largestPalindrome(char[] digits){
        int result = -1;
        for (int i = digits.length -1; i >= 0; i-- ){
            for (int j = digits.length -1; j >= 0; j-- ){
                for (int k = digits.length -1; k >= 0; k-- ){
                    char[] numberAsCharArray = {digits[i],digits[j],digits[k],digits[k],digits[j],digits[i]};
                    String stringNumber = new String(numberAsCharArray);
                    int number = Integer.parseInt(stringNumber);
                    for(int m = 999;m >= 100;m--){
                        if(number % m == 0){
                            int tempResult = number / m;
                            if(String.valueOf(tempResult).length() == 3){
                                return number;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}
