package Under10Percent.EvenFibonachiNumber;

import java.util.ArrayList;
import java.util.List;

//    Каждый следующий элемент ряда Фибоначчи получается при сложении двух предыдущих. Начиная с 1 и 2, первые 10 элементов будут:
//     1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//    Найдите сумму всех четных элементов ряда Фибоначчи, которые не превышают четыре миллиона.
public class App00 {
    public static void main(String[] args) {
        List resultList = fibonachiNumbers();
        int resultSum = 0;
        for (int i = 0;i < resultList.size(); i++){
            if((int)resultList.get(i) % 2 == 0){
                resultSum += (int)resultList.get(i);
            }
        }
        System.out.println("Your result is: "+resultSum);
    }
     private static ArrayList fibonachiNumbers(){
        ArrayList newList = new ArrayList();
        newList.add(1);
        newList.add(2);
        int beginIndex = 0;
        boolean isWorks = true;
         while(isWorks){
             if((int)newList.get(beginIndex+1) < 4000000) {
                 newList.add((int) newList.get(beginIndex) + (int) newList.get(beginIndex + 1));
                 beginIndex++;
             }else{
                 isWorks = false;
             }
         }
        return newList;
     }
}
