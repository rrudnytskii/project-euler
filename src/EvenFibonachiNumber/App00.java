package EvenFibonachiNumber;

import java.util.ArrayList;
import java.util.List;

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
