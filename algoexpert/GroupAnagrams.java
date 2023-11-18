package algoexpert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(List<String> words){
        List<List<String>> result = new ArrayList<>();
        Map<String, Boolean> mark = new HashMap<>();
        for(int k = 0; k < words.size(); k++){
            List<String> currentList = new ArrayList<>();
            String current = words.get(k);
            if(!mark.containsKey(current)){
                currentList.add(current);
                mark.put(current, false);
            }
            for(int l = k + 1; l < words.size(); l++){
                String lItem = words.get(l);
                if(isAnagram(current, lItem) && !mark.containsKey(lItem)){
                    currentList.add(lItem);
                    mark.put(lItem, false);
                }
            }
            if(!currentList.isEmpty()){
                result.add(currentList);
            }

        }
        return result;
    }

    public static boolean isAnagram(String main, String check){
        Map<Character, Integer> map = new HashMap<>();
        if(main.length() != check.length()) return false;

        for(int i =0; i < main.length(); i++){
            map.put(main.charAt(i), map.getOrDefault(main.charAt(i), 0) + 1);
        }

        for(int j = 0; j < check.length(); j++){
            char current = check.charAt(j);
            if(!map.containsKey(current)){
                return false;
            }
            map.put(current, map.get(current) - 1);
            if(map.get(current) <= 0){
                map.remove(current);
            }
        }
        return true;
    }

    public static void main(String[] args){
        List<String> input = List.of("cinema", "a", "flop", "iceman", "meacyne", "lofp", "olfp");
        System.out.println(groupAnagrams(input));
    }
}
