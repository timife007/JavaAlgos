package algoexpert;
//Solution to the second test question on parking dilemma.

import java.util.Arrays;

public class ParkingDilemma {

    //Time complexity is O(nlogn)
    //Space complexity will be O(1)
    public static int carParkingRoof(int[] cars, int k){
        int min = Integer.MAX_VALUE;
        Arrays.sort(cars);
        int end = k - 1;
        int start = 0;
        while(end < cars.length){
            int current = cars[end] - cars[start] + 1;
            min = Math.min(current, min);
            start++;
            end++;
        }
        return min;
    }
}


//Note:Sorting takes time complexity of O(nlogn), the while loop takes O(n - k) time
//where n is the number of parked cars, and k is the least number of cars to be roofed.
//Overall time complexity will be O(nlogn + (n - k)) => O(nlogn).
