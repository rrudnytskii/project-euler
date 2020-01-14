package MultipleOf3And5;

import java.util.Arrays;

/*Если выписать все натуральные числа меньше 10, кратные 3 или 5, то получим 3, 5, 6 и 9. Сумма этих чисел равна 23.
    Найдите сумму всех чисел меньше 1000, кратных 3 или 5*/
public class App00 {
    public static void main(String[] args) {
        System.out.println("Your result is " + calculate());
        System.out.println(Arrays.toString(foldArray(new int[]{1, 2, 3, 4, 5}, 2)));
    }

    private static int calculate() {
        int result = 0;
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = i;
            if (arr[i] % 3 == 0 || arr[i] % 5 == 0) {
                result += arr[i];
            }
        }
        return result;
    }

    public static int[] foldArray(int[] array, int runs) {
        int[] result = array;
        int count = 0;
        do {
            int begin;
            int end;
            int[] temp;
            if (result.length % 2 != 0) {
                temp = new int[result.length / 2 + 1];
                begin = 0;
                end = result.length - 1;
                for (int i = 0; i < temp.length; i++) {
                    if (begin != end) {
                        temp[i] = result[begin] + result[end];
                        begin++;
                        end--;
                    } else {
                        temp[i] = result[begin];
                    }
                }
            } else {
                temp = new int[result.length / 2];
                begin = 0;
                end = result.length - 1;
                for (int i = 0; i < temp.length; i++) {
                    temp[i] = result[begin] + result[end];
                    begin++;
                    end--;
                }
            }
            result = temp;
            count++;
        } while (count != runs);
        return result;
    }
}
