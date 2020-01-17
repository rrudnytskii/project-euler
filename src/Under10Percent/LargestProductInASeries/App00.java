package Under10Percent.LargestProductInASeries;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//  Наибольшее произведение четырех последовательных цифр в нижеприведенном 1000-значном числе равно 9 × 9 × 8 × 9 = 5832.
//
//        73167176531330624919225119674426574742355349194934
//        96983520312774506326239578318016984801869478851843
//        85861560789112949495459501737958331952853208805511
//        12540698747158523863050715693290963295227443043557
//        66896648950445244523161731856403098711121722383113
//        62229893423380308135336276614282806444486645238749
//        30358907296290491560440772390713810515859307960866
//        70172427121883998797908792274921901699720888093776
//        65727333001053367881220235421809751254540594752243
//        52584907711670556013604839586446706324415722155397
//        53697817977846174064955149290862569321978468622482
//        83972241375657056057490261407972968652414535100474
//        82166370484403199890008895243450658541227588666881
//        16427171479924442928230863465674813919123162824586
//        17866458359124566529476545682848912883142607690042
//        24219022671055626321111109370544217506941658960408
//        07198403850962455444362981230987879927244284909188
//        84580156166097919133875499200524063689912560717606
//        05886116467109405077541002256983155200055935729725
//        71636269561882670428252483600823257530420752963450
//
//    Найдите наибольшее произведение тринадцати последовательных цифр в данном числе.
public class App00 {
    public static void main(String[] args) {
        String sequence = "73167176531330624919225119674426574742355349194934" +
                "96983520312774506326239578318016984801869478851843" +
                "85861560789112949495459501737958331952853208805511" +
                "12540698747158523863050715693290963295227443043557" +
                "66896648950445244523161731856403098711121722383113" +
                "62229893423380308135336276614282806444486645238749" +
                "30358907296290491560440772390713810515859307960866" +
                "70172427121883998797908792274921901699720888093776" +
                "65727333001053367881220235421809751254540594752243" +
                "52584907711670556013604839586446706324415722155397" +
                "53697817977846174064955149290862569321978468622482" +
                "83972241375657056057490261407972968652414535100474" +
                "82166370484403199890008895243450658541227588666881" +
                "16427171479924442928230863465674813919123162824586" +
                "17866458359124566529476545682848912883142607690042" +
                "24219022671055626321111109370544217506941658960408" +
                "07198403850962455444362981230987879927244284909188" +
                "84580156166097919133875499200524063689912560717606" +
                "05886116467109405077541002256983155200055935729725" +
                "71636269561882670428252483600823257530420752963450";
        int sequenceSize = 13;
        System.out.println("The value of the greatest product:"+findBiggestProduct(getSequenceWithoutZeroProductParts(sequence,sequenceSize),sequenceSize));

    }

    private static String getSequenceWithoutZeroProductParts(String sequence, int sequenceSize){
        int countFor13DigitSequence = 0;
        List<Character> stringAsCharList = sequence
                .chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toList());
        List<Character> resultAsChars = new ArrayList<>();
        List<Character> temporaryArray = new ArrayList<>();
        for(Character character : stringAsCharList){
            temporaryArray.add(character);
            countFor13DigitSequence++;
            if(character.equals('0')){
                if(countFor13DigitSequence > sequenceSize) {
                    resultAsChars.addAll(temporaryArray);
                }
                temporaryArray.clear();
                countFor13DigitSequence = 0;
            }
        }
        return resultAsChars.toString()
                .substring(1, 3 * resultAsChars.size() - 1)
                .replaceAll(", ", "");
    }

    private static long findBiggestProduct(String sequence,int sequenceSize){
        long maxProduct = 0;
        List<String> stringBetweenZeros = new ArrayList<>();
        char[] chars = sequence.toCharArray();
        int beginPosition = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '0'){
                stringBetweenZeros.add(sequence.substring(beginPosition,i));
                beginPosition = i+1;
            }
        }
        char[] chars1;
        for (String subSequence: stringBetweenZeros) {
           chars1 = subSequence.toCharArray();
            long product = 1;
           if(chars1.length == sequenceSize){
               for(int i = 0; i < chars1.length; i++){
                   product *=  Long.parseLong(Character.toString(chars1[i]));
               }
               if(product > maxProduct){
                   maxProduct = product;
               }
           }else{
               for(int i = 0; i <= chars1.length-sequenceSize;i++){
                   for(int j = i; j < sequenceSize+i;j++){
                       product *=  Long.parseLong(Character.toString(chars1[j]));
                   }
                   if(product > maxProduct){
                       maxProduct = product;
                   }
                   product = 1;
               }
           }
        }
        return maxProduct;
    }
}
