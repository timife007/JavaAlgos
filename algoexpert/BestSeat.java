package algoexpert;

import java.util.ArrayList;
import java.util.List;

public class BestSeat {

    public static int getBestSeat(int[] seats){

        if(seats.length == 1 && seats[0] == 0) return 0;
        int pointer = 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int result = -1;
        List<Integer> counts = new ArrayList<>();
        while(pointer < seats.length){
            while(seats[pointer] == 0){
                count++;
                pointer++;
            }
            if(count > max){
                max = count;
                result = pointer - 1 - count/2;
            }

            count = 0;
            pointer++;
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(getBestSeat(new int[]{1, 0, 0, 1, 0, 0, 0,1, 1,0,0,0,0,0,1}));
        System.out.println(getBestSeat(new int[]{1, 1, 0, 1, 0, 0, 0,1, 1,0,1,0,0,0,1}));
        System.out.println(getBestSeat(new int[]{1, 1, 1, 1, 1, 1, 1,1, 1,1,1,1,1,1,1}));
        System.out.println(getBestSeat(new int[]{0}));

    }
}
