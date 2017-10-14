/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/diagonal-difference
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    private static int getAbsDiffSumsOfDiagonals(int n, int a[][]) {
        int sum = 0;
        int primDiagonalSum = 0;
        int secondDiagonalSum = 0;
        
        for (int row = 0; row < n; row++) {
            primDiagonalSum += a[row][row];
            secondDiagonalSum += a[row][n-row-1];
        }
        
        sum = Math.abs(secondDiagonalSum - primDiagonalSum);
        
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][n];
        
        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                a[a_i][a_j] = in.nextInt();
            }
        }
        
        System.out.println(getAbsDiffSumsOfDiagonals(n, a));
    }
}
