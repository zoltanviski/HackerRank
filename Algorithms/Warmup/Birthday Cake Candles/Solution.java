/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/birthday-cake-candles
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int birthdayCakeCandles(int n, int[] ar) {
        int count = 0;
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            int actual = ar[i];
            if (actual > max) {
                max = actual;
                count = 1;
            } else if (actual == max) {
                count++;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
		
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
		
        int result = birthdayCakeCandles(n, ar);
		
        System.out.println(result);
    }
}
