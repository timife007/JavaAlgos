package algoexpert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            int[] subArray = Arrays.copyOfRange(array, i + 1, array.length);
            List<Integer[]> threeSum = threeNumberSum(subArray, targetSum - array[i]);
            if(!threeSum.isEmpty()){
                for(Integer[] item: threeSum){
                    item[3] = array[i];
                }
                result.addAll(threeSum);
            }
        }
        return result;
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        Integer[] group = new Integer[4];

        for (int i = 0; i < array.length; i++) {
            int x = i + 1;
            int y = array.length - 1;
            while (x < y) {
                int sum = array[i] + array[x] + array[y];
                if (sum < targetSum) {
                    x++;
                } else if (sum > targetSum) {
                    y--;
                } else {
                    group[0] = array[i];
                    group[1] = array[x];
                    group[2] = array[y];
                    result.add(group);
                    group = new Integer[3];
                    x++;
                    y--;
                }
            }

        }

        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{7, 6, 4, -1, 1, 2};
        for(Integer[] item: fourNumberSum(input, 16)){
            System.out.println(Arrays.toString(item));
        }

    }
}
