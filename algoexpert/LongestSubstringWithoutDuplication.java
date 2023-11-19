package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestSubstringWithoutDuplication {

    public static String longestSubstringWithoutDuplication(String str) {
        // Write your code here
//        if(str.length() == 1) return str;
        int start = 0;
        String result = "";
        Map<Character, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for(int end = 0; end < str.length(); end++){
            char current = str.charAt(end);
            while(map.containsKey(current)){
                char currentStart = str.charAt(start);
                map.put(currentStart, map.get(currentStart) - 1);
                if(map.get(currentStart) == 0) map.remove(currentStart);
                start++;
            }
            String substring = str.substring(start ,end + 1);
            if(substring.length() > max){
                max = substring.length();
                result = substring;
            }

            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        return result;
    }

    public static void main(String[] args){
        String input = "a";
        System.out.println(longestSubstringWithoutDuplication(input));
    }
}
