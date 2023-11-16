package algoexpert;

import java.util.*;

public class CommonCharacters {
    public static String[] commonCharacters(String[] strings) {
        // Write your code here.
        Map<Character, Boolean> map = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(int i = 0; i < strings[0].length(); i++){
            map.put(strings[0].charAt(i), true);
        }


        for(Character item: map.keySet() ){
            int pointer = 1;
            while(pointer < strings.length && strings[pointer].contains(item.toString())){
                pointer++;
            }
            if(pointer == strings.length){
                result.add(item.toString());
            }
        }
        return result.toArray(new String[0]);
    }

    public static void main(String[] args){
        String[] input = new String[]{"abc", "bcd", "cbad"};
        System.out.println(Arrays.toString(commonCharacters(input)));
    }
}
