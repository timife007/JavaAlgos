package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class ZeroSumSubArray {

    public static boolean zeroSumSubarray(int[] nums) {
        // Write your code here.
        List<Integer> passedSums = new ArrayList<Integer>();
        int currentSum = 0;
        for (int num : nums) {
            currentSum += num;
            if (num == 0 || currentSum == 0) return true;
            if (passedSums.contains(currentSum)) {
                return true;
            }
            passedSums.add(currentSum);
        }
        return false;
    }

    public static void main(String[] args){
        int[] input = {1,-1};
        System.out.println(zeroSumSubarray(input));
    }
}
