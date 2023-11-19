package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class MinimumCharactersForWords {

    //Time complexity O(n * l), space O(c), n is the number of words
    //l is the length of the longest word, c is the number of unique characters.
    public static char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        Map<Character, Integer> map = new HashMap<>();

        for (String currentWord : words) {
            Map<Character, Integer> innerMap = new HashMap<>();
            for (int j = 0; j < currentWord.length(); j++) {
                char currentChar = currentWord.charAt(j);
                innerMap.put(currentChar, innerMap.getOrDefault(currentChar, 0) + 1);
            }
            for (Character item : innerMap.keySet()) {
                int currentValue = innerMap.get(item);
                if (map.containsKey(item)) {
                    map.put(item, Math.max(currentValue, map.get(item)));
                } else {
                    map.put(item, currentValue);
                }
            }
        }
        int size = 0;
        for(Character item: map.keySet()){
            int currentValue = map.get(item);
            size += currentValue;
        }
        char[] result = new char[size];
        int pointer = 0;

        for(Character item: map.keySet()){
            for(int i = 0; i < map.get(item); i++){
                result[pointer] = item;
                pointer++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] input = new String[]{"this", "that", "did", "deed", "them!", "a"};
        System.out.println(minimumCharactersForWords(input));
    }
}
