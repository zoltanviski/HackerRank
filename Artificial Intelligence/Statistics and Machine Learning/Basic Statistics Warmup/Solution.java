/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/stat-warmup
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.awt.Point;

public class Solution {
	
    private static double getMean(int count, int n) {
        double result = (double)(count) / n;
        
        return result;
    }
    
    private static double getMedian(int n, int[] arr) {
        double result = 0.0;
        
        if (n % 2 == 0)
        {
            result = (double)(arr[n/2] + arr[(n/2)-1]) / 2;
        } else {
            result = arr[n/2];
        }
        
        return result;
    }
    
    private static int getMode(Map<Integer,Integer> frequencies) {
        int result = 0;
        int modeCount = 0;
        
        for (Integer key : frequencies.keySet()) {
            Integer value = frequencies.get(key);
            
            if (value >= modeCount) {
                if (key < result || value > modeCount || result == 0) {
                    modeCount = value;
                    
                    result = key;
                }
            }
        }
        
        return result;
    }
    
    private static double getStandardDeviation(int n, int[] arr, double mean) {
        double result = 0.0;
        double countSquare = 0.0;
        
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            countSquare += (element-mean) * (element-mean);
        }
        
        result = (double)Math.sqrt((double)(countSquare/n));
        
        return result;
    }
    
    private static double getConfidenceIntervalsLow(int n, double mean, double standardDeviation) {
        double result = (mean - 1.96 * standardDeviation / Math.sqrt(n));
        
        return result;
    }
    
    private static double getConfidenceIntervalsHigh(int n, double mean, double standardDeviation) {
        double result = (mean + 1.96 * standardDeviation / Math.sqrt(n));
        
        return result;
    }
    
    private static void calculateResults(int n, int[] arr) {
        int count = 0;
        Map<Integer,Integer> frequencies = new HashMap<Integer,Integer>();
        
        for (int i = 0; i < n; i++) {
            int element = arr[i];
            count += element;  
            
            if (frequencies.containsKey(element))
            {
                frequencies.put(element, (frequencies.get(element) + 1));
            } else {
                frequencies.put(element, 1);
            }
        }
        
        double mean = getMean(count, n);
        double median = getMedian(n, arr);    
        int mode = getMode(frequencies);
        double standardDeviation = getStandardDeviation(n, arr, mean);
        double confidenceIntervalsLow = getConfidenceIntervalsLow(n, mean, standardDeviation);
        double confidenceIntervalsHigh = getConfidenceIntervalsHigh(n, mean, standardDeviation);
        
        System.out.println(mean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(standardDeviation);
        System.out.println(confidenceIntervalsLow + " " + confidenceIntervalsHigh);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        Arrays.sort(arr);
        
        calculateResults(n, arr);
    }
}