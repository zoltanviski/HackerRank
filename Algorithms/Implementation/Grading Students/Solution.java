/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/grading
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[] solve(int[] grades){
        int n = grades.length;
        int[] result = new int[n];
        int multiplier = 5;
        int minLimit = 38;
        int threshold = 3;
        
        for (int i = 0; i < n; i++) {
            int grad = grades[i];
            int newGrad = grad;
            
            if (grades[i] >= minLimit ) {
                if ((multiplier - grad % multiplier) < threshold) {
                    newGrad = grad + (multiplier - grad % multiplier);
                }
            }
            
            result[i] = newGrad;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] grades = new int[n];
		
        for(int grades_i=0; grades_i < n; grades_i++){
            grades[grades_i] = in.nextInt();
        }
		
        int[] result = solve(grades);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
        }
		
        System.out.println("");
    }
}
