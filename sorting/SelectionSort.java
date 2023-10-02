package sorting;

import java.util.Arrays;

import static sorting.BubbleSort.swap;



//time complexity = O(N2)
public class SelectionSort {

    public static int[] input = {7,6,5,4,3,2,1};

    public static void selectionSort(){
        if(input.length == 0) System.out.println(Arrays.toString(input));
        for(int i = 0; i < input.length; i++){
            int lowest = i;

            for(int j = i; j < input.length; j++){
                if(input[j] < input[lowest]){
                    lowest = j;
                }
            }
            swap(lowest, i);
        }
        System.out.println(Arrays.toString(input));
    }

    public static void swap(int current, int prev){
        int temp = input[current];
        input[current] = input[prev];
        input[prev] = temp;
    }

    public static void main(String[] args){
        selectionSort();
    }
}
