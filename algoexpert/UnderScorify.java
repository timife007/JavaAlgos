package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UnderScorify {

    public static String underscorifySubstring(String str, String substring) {
        List<int[]> points = points(str, substring);
        int strIdx = 0;
        StringBuilder builder = new StringBuilder();

        if(!points.isEmpty()){
            for (int[] point : points) {
                while (strIdx < point[0]) {
                    builder.append(str.charAt(strIdx));
                    strIdx++;
                }
                builder.append("_").append(str, point[0], point[1]).append("_");
                strIdx = point[1];
            }
        }else {
            return str;
        }
        if(strIdx < str.length()){
            builder.append(str.substring(strIdx));
        }
        return builder.toString();
    }

    public static List<int[]> points(String word, String substring) {
        int start = 0;
        List<int[]> locations = new ArrayList<>();
        while(start < word.length()){
            int[] currentRange = new int[2];
            int nextIdx = word.indexOf(substring, start);
            if(nextIdx == -1){
                break;
            }else{
                currentRange[0] = nextIdx;
                currentRange[1] = nextIdx + substring.length();
                locations.add(currentRange);
                start = nextIdx + 1;
            }
        }
        return mergePoints(locations);
    }

    public static List<int[]> mergePoints(List<int[]> points){
        if(points.isEmpty()) return Collections.emptyList();
        List<int[]> merged = new ArrayList<>();
        int pointer = 1;
        merged.add(points.get(0));
        int[] prev = merged.get(0);
        while(pointer < points.size()){
            int[] current = points.get(pointer);
            if(current[0] <= prev[1]){
                prev[1] = current[1];
            }else{
                merged.add(current);
                prev = current;
            }
            pointer++;
        }
        return merged;
    }

    public static void main(String[] args) {
        String word = "test";
        List<int[]> locations = List.of(new int[]{1, 2}, new int[]{2,4}, new int[]{4,6});
        for(int[] item: points(word,"test")){
            System.out.println(Arrays.toString(item));
        }

        System.out.println(underscorifySubstring(word, "test"));
    }
}
