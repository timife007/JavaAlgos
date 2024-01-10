package algoexpert;

import java.util.Arrays;

public class ACTSecond {

    //Using sorting and sliding window technique
    //Sorting takes time complexity of O(nlogn), while loop takes O(n - k) where
    //n is the number parked cars, and k is the least number of cars to be roofed.
    //Overall time complexity will be O(nlogn + (n - k)) => O(nlogn)
    //Space complexity will be O(1)
    public static int carParkingRoof(int[] cars, int n, int k){
        if(cars.length == 0) return 0;
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

    public static void main(String[] args){
        int[] cars = new int[]{6,2,12,7};
        int n = 4;
        int k = 3;
        System.out.println(carParkingRoof(cars, n, k));
    }
}
