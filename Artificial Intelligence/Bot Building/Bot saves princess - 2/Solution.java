/**
 * @author 	Zoltan Viski (vizoli)
 * 			vizoli.hu
 * 			github.com/zoltanviski
 * 			hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/saveprincess2
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;

public class Solution {
    static char princess = 'p';
    static int princessRow = 0;
    static int princessColumn = 0;
    
    static void getPrincessPosition(int n, String[] grid) {
        boolean found = false;
        
        for (int row = 0; row < n; row++) {
            for (int column = 0; column < n; column++) {
                if (grid[row].charAt(column) == princess) {
                    princessRow = row;
                    princessColumn = column;
                    found = true;
                    
                    break;
                }
            }
            
            if (found) break;
        }
    }
    
    static void nextMove(int n, int r, int c, String [] grid){
        if (r < princessRow) {
            System.out.println("DOWN");
            
            return;
        } else if (r > princessRow) {
            System.out.println("UP");
            
            return;
        }
        
        if (c < princessColumn) {
            System.out.println("RIGHT");
            
            return;
        } else if (c > princessColumn) {
            System.out.println("LEFT");
            
            return;
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n,r,c;
        n = in.nextInt();
        r = in.nextInt();
        c = in.nextInt();
        in.useDelimiter("\n");
        String grid[] = new String[n];

        for(int i = 0; i < n; i++) {
            grid[i] = in.next();
        }
        
        getPrincessPosition(n, grid);

        nextMove(n,r,c,grid);
    }
}
