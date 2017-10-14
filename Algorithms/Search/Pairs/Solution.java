/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/pairs
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static int pairs(int[] a,int k) {
        int result = 0;
        int n = a.length;
        Map<Integer,Boolean> pairs = new HashMap<Integer,Boolean>();
        
        for (int i = 0; i < n; i++) {
            int num = a[i];
            if (num < k) continue;
            
            pairs.put(num-k, true);
        }
        
        for (int j = 0; j < n; j++) {
            if (pairs.get(a[j]) != null) result++;
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        
        String n = in.nextLine();
        String[] n_split = n.split(" ");
        
        int _a_size = Integer.parseInt(n_split[0]);
        int _k = Integer.parseInt(n_split[1]);
        
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");
        
        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }
        
        res = pairs(_a,_k);
		
        System.out.println(res);
    }
}
