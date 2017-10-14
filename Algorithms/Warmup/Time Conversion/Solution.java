/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/time-conversion
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static String timeConversion(String s) {
        char dayPart = s.charAt(s.length() - 2);
        
        if (dayPart == 'A') {
            if (s.substring(0, 2).equals("12")) {
                return "00" + s.substring(2, s.length() - 2);
            }
            
            return s.substring(0, s.length() - 2);
        }
        
        if (s.substring(0, 2).equals("12")) {
            return s.substring(0, s.length() - 2);
        }
        
        String result = String.valueOf((Integer)(Integer.parseInt(s.substring(0, 2))+12)) + s.substring(2, s.length() - 2);
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
