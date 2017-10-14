/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/fibonacci-modified
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    static Map<Integer,BigInteger> fibs = new HashMap<Integer,BigInteger>();
    static int t1, t2;
    
    private static BigInteger getFib(int n) {
        if (n == 1) return BigInteger.valueOf(t1);
        if (n == 2) return BigInteger.valueOf(t2);
        
        BigInteger result = getFib(n-2).add((getFib(n-1).multiply(getFib(n-1))));
        BigInteger fibsN = fibs.get(n);
        
        if (fibsN != null) {
            return fibsN;
        } else {
            fibs.put(n, result);
        }
        
        return result;
        
    }
    
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        t1 = scanner.nextInt();
        t2 = scanner.nextInt();
        int n = scanner.nextInt();
        
        System.out.println(getFib(n));
    }
}
