package algoexpert;

public class MinRewards {

    public static int minRewards(int[] scores){
        int pointer = 1;
        int sum = 0;

        while(pointer < scores.length){
            int current = scores[pointer];
            int tracker = pointer;
            if(current < scores[pointer - 1] && current < scores[pointer + 1]){
                int count = 1;
                while(pointer > 0 && scores[pointer] < scores[pointer - 1]){
                    pointer--;
                    count++;
                    sum += count;
                }
                count  = 1;
                pointer = tracker;
                while(pointer < scores.length - 1 && scores[pointer]  < scores[pointer + 1]){
                    pointer++;
                    count++;
                    sum += count;
                }
                //The lowest pointer that was not added.
                sum += 1;
            }
            if(pointer == scores.length - 1){
                int count = 1;
                while(pointer > 0 && scores[pointer] < scores[pointer - 1]){
                    pointer--;
                    count++;
                    sum += count;
                }
                sum += 1;
            }
            pointer++;
        }
        return sum;
    }


    public static void main(String[] args){
        System.out.println(minRewards(new int[]{8, 4, 2, 1, 3, 6, 7, 9, 5,4,3,7,8,9}));
    }
}
