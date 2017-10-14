/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/insertionsort1
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void insertIntoSorted(int[] ar) {
        int arLength = ar.length;
        int toInsert = ar[arLength-1];
        
        for (int i = arLength - 1; i >= 0; i--) {
            ar[i] = (i == 0) ? ar[i] : ar[i-1];
            
            if (ar[i] < toInsert || i == 0) {
                ar[i] = toInsert;
                
                printArray(ar);
                
                break;
            }
            
            printArray(ar);
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
		
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
        }
		
        insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
		
        System.out.println("");
    }
}
 
