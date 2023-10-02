package sorting;

import java.util.Arrays;

/**
 * Starting from index 1, compare with integers in the previous indices until and swap
 * if less than it, continue swapping until you get to the index whose value is less
 * than the current value.
 */
public class InsertionSort {
    static int[] values = {3,45,3,4,5,6,-1,45,3,2,34,3,4,90,6,7,8,9,3,2,1,0,0,9,8};

    public static void insertionSort(){

        for(int i = 1; i < values.length; i++){
            int currentIndex = i;
            int prevIndex = currentIndex - 1;

            while(prevIndex >=0 && values[currentIndex] < values[prevIndex]){
                swap(currentIndex, prevIndex);
                currentIndex--;
                prevIndex--;
            }
        }
        System.out.println(Arrays.toString(values));
    }

    static void swap(int current, int prev){
        int temp = values[prev];
        values[prev] = values[current];
        values[current] = temp;
    }

    public static void main(String[] args){
        insertionSort();
    }
}
