package algoexpert;


import java.util.*;

public class FourNumberSum {

     //Three number sum approach
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


    //HashMap approach
    public static Map<Integer, Integer[]> fourNumberSumHash(int[] array, int targetSum){
        Map< Integer, Integer[]> sumap = new HashMap<>();
//        Arrays.sort(array);
        List<Integer[]> sol = new ArrayList<>();

        for(int i = 0; i < array.length; i++){
            int pointer = array.length - 1;
            while(pointer > i){
                int sum = array[i] + array[pointer];
                sumap.put(sum, new Integer[]{array[i], array[pointer]});
                pointer--;
            }
        }
//        var mapItems = sumap.keySet().stream().toList();
//        Integer[] group = new Integer[4];
//        for(int j = 0; j < mapItems.size(); j++){
//            int x = mapItems.size() - 1;
//            while (x > j){
//                if((mapItems.get(j) + mapItems.get(x)) == targetSum){
//                    group[0] = sumap.get(mapItems.get(j))[0];
//                    group[1] = sumap.get(mapItems.get(j))[1];
//                    group[2] = sumap.get(mapItems.get(x))[0];
//                    group[3] = sumap.get(mapItems.get(x))[1];
//                    sol.add(group);
//                    group = new Integer[4];
//                }
//                x--;
//            }
//        }

        return sumap;
    }

    public static void main(String[] args){
        int[] input = new int[]{7, 6, 4, -1, 1, 2};
        for(Integer[] item: fourNumberSum(input, 16)){
            System.out.println(Arrays.toString(item));
        }
        int[] input2 = new int[]{7, 6, 4, -1, 1, 2};
        System.out.println("***********");
        for( Integer[] item: fourNumberSumHash(input2, 16).values()){
            System.out.println(Arrays.toString(item));
        }
    }
}
