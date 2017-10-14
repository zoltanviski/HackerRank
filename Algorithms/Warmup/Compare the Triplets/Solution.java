/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/compare-the-triplets
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[] solve(int a0, int a1, int a2, int b0, int b1, int b2){
        int[] points = new int[2];
        int[] aRates = {a0, a1, a2};
        int[] bRates = {b0, b1, b2};
        int aPoint = 0;
        int bPoint = 0;
        int n = 3;
        
        for (int i = 0; i < n; i++) {
            if (aRates[i] > bRates[i]) aPoint++;
            if (bRates[i] > aRates[i]) bPoint++;
        }
        
        points[0] = aPoint;
        points[1] = bPoint;
        
        return points;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        int[] result = solve(a0, a1, a2, b0, b1, b2);
		
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
		
        System.out.println("");
    }
}
