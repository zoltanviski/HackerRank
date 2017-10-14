/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/recursive-digit-sum
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static long getSuperDigit(String digits, int k) {
        int digitsSize = digits.length();
        if (digitsSize == 1) {
            System.out.println(digits.charAt(0));
            return 0;
        }
        
        long digitSum = 0;
        for (int i = 0; i < digitsSize; i++) {
            digitSum += Integer.parseInt(String.valueOf(digits.charAt(i)));
        }
        
        digitSum *= k;
        
        String digitString = String.valueOf(digitSum);
        
        return getSuperDigit(digitString, 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int k = scanner.nextInt();
        
        getSuperDigit(n, k);
    }
}