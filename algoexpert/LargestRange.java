package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    //Time complexity O(nlogn), space O(n)
    public static int[] largestRange(int[] array){
        Arrays.sort(array);
        if(array.length == 1) return new int[]{array[0], array[0]};
        int pointer = 1;
        int start = array[0];
        Map<Integer, int[]> map = new HashMap<>();

        while(pointer < array.length){
            while(pointer < array.length && (array[pointer] == array[pointer - 1] + 1 || array[pointer] == array[pointer - 1])){
                pointer++;
            }

            int end = array[pointer - 1];
            int diff = end - start;
            map.put(diff, new int[]{start, end});
            if(pointer < array.length){
                pointer++;
                start = array[pointer - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int item: map.keySet()){
            if(item > max){
                max = item;
            }
        }
        return map.get(max);
    }

    public static int[] largeRangeOptimized(int[] array){
        Map<Integer, Boolean> map = new HashMap<>();
        Map<Integer, int[]> result = new HashMap<>();

        for(int item: array){
            map.put(item, true);
        }

        for(int item: array){
            int pointer = item;
            if(map.get(pointer)){
                while(map.containsKey(pointer)){
                    map.put(pointer, false);
                    pointer--;
                }
                int start = pointer + 1;
                pointer = item + 1;
                while(map.containsKey(pointer)){
                    map.put(pointer, false);
                    pointer++;
                }
                int end = pointer - 1;
                result.put(end - start, new int[]{start, end});
            }
        }
        int max = Integer.MIN_VALUE;
        for(int item: result.keySet()){
            max = Math.max(max, item);
        }

        return result.get(max);
    }

    public static void main(String[] args){
        int[] input = new int[]{0,2,3,4,8,9,10,11,12};
        int[] input2 = new int[]{1};
        System.out.println(Arrays.toString(largeRangeOptimized(input2)));
    }
}
