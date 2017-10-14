/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/plus-minus
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static float[] getFractions(int n, int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }
        
        float[] fractions = {((float)positiveCount/n), ((float)negativeCount/n), ((float)zeroCount/n)};
        
        return fractions;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        float[] fractions = getFractions(n, arr);
        
        System.out.println(fractions[0]);
        System.out.println(fractions[1]);
        System.out.println(fractions[2]);
    }
}
