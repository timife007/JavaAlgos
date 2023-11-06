package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals){
        // Write your code here.
        int min = intervals[0][0];
        int max = intervals[0][1];
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> temp = new ArrayList<>();
        int[] individual = new int[2];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] <= max){
                max = Math.max(intervals[i][1], max);
            }else{
                individual[0] = min;
                individual[1] = max;
                temp.add(individual);
                individual = new int[2];
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        individual[0] = min;
        individual[1] = max;
        temp.add(individual);
        int[][] result = new int[temp.size()][2];

        for(int i = 0; i < temp.size(); i++ ){
            result[i] = temp.get(i);
        }
        return result;
    }

     public static void main(String[] args){
        int[][] input = {{89,90},{-10, 20},{-50, 0},{70,90},{90,91},{90, 95}};
        Arrays.sort(input, (a,b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(input));
        System.out.println(Arrays.deepToString(mergeIntervals(input)));
    }
}
