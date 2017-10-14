/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/mini-max-sum
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static long[] getMinAndMaxSum(int[] arr) {
        long minSum = Long.MAX_VALUE;
        long maxSum = 0;
		long tempSum = 0;
               
        int n = 5;  
        for (int i = 0; i < n; i++) {
            tempSum += arr[i];
        }
        
        long originalTempSum = tempSum;
        for (int j = 0; j < n; j++) {
            tempSum -= arr[j];
            
            if (tempSum < minSum) minSum = tempSum;
            if (tempSum > maxSum) maxSum = tempSum;
            
            tempSum = originalTempSum;
        }
        
        long[] minAndMaxSum = {minSum, maxSum};
        
        return minAndMaxSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        
        long[] minAndMaxSum = getMinAndMaxSum(arr);
        System.out.println(minAndMaxSum[0] + " " + minAndMaxSum[1]);
    }
}
