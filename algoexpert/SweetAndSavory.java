package algoexpert;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SweetAndSavory {
    public static int[] findProfile(int[] dishes, int target){
        //Sort dishes to know number of savory and sweet available.
        Arrays.sort(dishes);
        int max = Integer.MIN_VALUE;

        int i = 0;
        while(i < dishes.length && dishes[i] < 0){
            i++;
        }
        //separate them into individual arrays.
        Integer[] sweet = new Integer[i];
        Integer[] savory = new Integer[dishes.length - i];
        int s = 0;
        int b = 0;

        for (int dish : dishes) {
            if (dish < 0) {
                sweet[s] = dish;
                s++;
            } else if (dish > 0) {
                savory[b] = dish;
                b++;
            }
        }
        Arrays.sort(sweet, (x, y) -> y - x);
        Arrays.sort(savory);
        if(sweet.length == 0 || savory.length == 0){
            return new int[2];
        }

        int pointer1 = 0;
        int pointer2 = 0;
        int[] result = new int[2];

        while(pointer1 < sweet.length && pointer2 < savory.length){
            int sum = sweet[pointer1] + savory[pointer2];
            if(sum < target){
//                max = Math.max(sum, max);
                if(sum > max){
                   max = sum;
                   result = new int[]{sweet[pointer1], savory[pointer2]};
                }
                pointer2++;
            }else if(sum > target){
                pointer1++;
            }else{
                return new int[]{sweet[pointer1], savory[pointer2]};
            }
        }
        return result;
    }
    public static void main(String[] args){
        int[] input = new int[]{2, 4, -4, -7, 12, 100, -25};
        System.out.println(Arrays.toString(findProfile(input, -1)));

    }
}
