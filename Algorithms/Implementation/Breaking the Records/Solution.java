/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/breaking-best-and-worst-records
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    private static int[] getRecord(int[] s){
        int highBreak = 0;
        int lowBreak = 0;
        int highScore = s[0];
        int lowScore = highScore;
        
        int n = s.length;
        for (int i = 0; i < n; i++) {
            int actualScore = s[i];
            if (actualScore > highScore) {
                highScore = actualScore;
                highBreak++;
            } else if (actualScore < lowScore) {
                lowScore = actualScore;
                lowBreak++;
            }
        }
        
        int[] result = { highBreak, lowBreak };
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] s = new int[n];
		
        for(int s_i=0; s_i < n; s_i++){
            s[s_i] = in.nextInt();
        }
		
        int[] result = getRecord(s);
        String separator = "", delimiter = " ";
        for (Integer val : result) {
            System.out.print(separator + val);
            separator = delimiter;
        }
		
        System.out.println("");
    }
}
