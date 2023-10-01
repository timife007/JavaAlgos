package sorting;

import java.util.Arrays;

public class BubbleSort {

    static int[] testValues = {5,4,3,2,7,6,9,8};

    public static void bubbleSort(){
        for(int i = testValues.length - 1; i > 1; i--){
            for(int j = 1; j <= i; j++){
                if(testValues[j] < testValues[j-1]){
                    swap(j, j-1);
                }
            }
        }
        System.out.println(Arrays.toString(testValues));
    }

    public static void swap(int current, int prev){
        int temp = testValues[current];
        testValues[current] = testValues[prev];
        testValues[prev] = temp;
    }


    public static void main(String[] args) {
        bubbleSort();
    }
}


