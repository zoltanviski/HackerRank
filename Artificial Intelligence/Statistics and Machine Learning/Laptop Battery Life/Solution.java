/**
 * @author  Zoltan Viski (vizoli)
 *          vizoli.hu
 *          github.com/zoltanviski
 *          hackerrank.com/zoltanviski
 * 
 * Problem: https://www.hackerrank.com/challenges/battery
 */

import java.util.*;

public class Solution {
    private static final double multiplier = 2.00;
    private static final double chargedTimeUpperThreshold = 4.00;
    private static final double maxLastedTime = 8.00;
    
    private static double getLastedTime(final double chargedTime) {
        double result = 0.00;
        
        if (chargedTime >= chargedTimeUpperThreshold) {
            result = maxLastedTime;
        } else {
            result = chargedTime * multiplier;
        }
            
        return result;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double timeCharged = in.nextDouble();
        
        double calculatedLastedTime = getLastedTime(timeCharged);
        System.out.println(calculatedLastedTime);
    }
}
