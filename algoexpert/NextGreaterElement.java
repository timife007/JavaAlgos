package algoexpert;

import java.util.Arrays;

public class NextGreaterElement {
    public static int[] nextGreaterElement(int[] array){
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++){
            int count = (i + 1) % array.length;
            while(array[count] <= array[i] && count != i){
                count = (count + 1) % array.length;
            }
            if(array[count] > array[i]){
                result[i] = array[count];
            }else{
                result[i] = -1;
            }
        }
        return result;
    }

    public static void main(String[] args){
        int[] input = new int[]{2,5,-3,-4,6,7,2};
        System.out.println(Arrays.toString(nextGreaterElement(input)));
    }
}
