package algoexpert;

import java.util.Arrays;

public class SubArraySort {

    public static int[] subArraySort(int[] array){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(isOutOfOrder(i, array)){
                min = Math.min(array[i], min);
                max = Math.max(array[i], max);
            }
        }
        if(min == Integer.MAX_VALUE && max == Integer.MIN_VALUE){
            return new int[]{-1, -1};
        }
        int startIdx = 0;
        while(min > array[startIdx]){
            startIdx++;
        }
        int endIdx = array.length - 1;
        while(max < array[endIdx]){
            endIdx--;
        }

        return new int[]{startIdx, endIdx};
    }
    public static boolean isOutOfOrder(int idx, int[] array){
        if(idx == 0){
            return array[idx] > array[idx + 1];
        }

        if(idx == array.length - 1){
            return array[idx] < array[idx - 1];
        }
        return array[idx] > array[idx + 1] || array[idx] < array[idx - 1];
    }

    public static void main(String[] args){
        int[] input = new int[]{1, 2, 4, 7, 7, 7, 16, 18, 19};
        System.out.println(Arrays.toString(subArraySort(input)));
    }
}
