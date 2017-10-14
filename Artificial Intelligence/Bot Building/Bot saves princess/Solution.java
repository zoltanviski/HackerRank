/**
 * @author 	Zoltan Viski (vizoli)
 * 			vizoli.hu
 * 			github.com/zoltanviski
 * 			hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/saveprincess
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;

public class Solution {
    static char princess = 'p';
    
    static Point getPrincessPosition(int m, char [][] grid) {
        if (grid[0][0] == princess) return new Point(0, 0);
        if (grid[0][m-1] == princess) return new Point(0, m-1);
        if (grid[m-1][0] == princess) return new Point(m-1, 0);
        
        return new Point(m-1, m-1);
    } 
    
    static void displayPathtoPrincess(int m, char [][] grid){
        Point pricessPos = getPrincessPosition(m, grid);
        int princessRow = (int)pricessPos.getX();
        int princessColumn = (int)pricessPos.getY();
        int robotRow = m / 2;
        int robotColumn = robotRow;
        
        for (int i = 0; i < robotRow; i++) {
            if (robotRow > princessRow) {
                robotRow--;
				
                System.out.println("UP");
            } else {
                robotRow++;
				
                System.out.println("DOWN");
            }
            
            if (robotColumn > princessColumn) {
                robotColumn--;
				
                System.out.println("LEFT");
            } else {
                robotColumn++;
				
                System.out.println("RIGHT");
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m;
        m = in.nextInt();
        char grid[][] = new char[m][m];
        for(int row = 0; row < m; row++) {
            String line = in.next();
            for(int column = 0; column < m; column++) {
                grid[row][column] = line.charAt(column);
            }    
        }

        displayPathtoPrincess(m,grid);
    }
}
