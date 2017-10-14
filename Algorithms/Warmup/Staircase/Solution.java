/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/staircase
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static void drawStairs(int n) {
        for (int i = n; i >= 1; i--) {
            String level = "";
            
            for (int j = 1; j <= n; j++) {
                if (j < i) {
                    level += " ";
                } else {
                    level += "#";
                }
            }
            
            System.out.println(level);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        drawStairs(n);
    }
}
