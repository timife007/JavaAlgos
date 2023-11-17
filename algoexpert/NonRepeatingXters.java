package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class NonRepeatingXters {

    public static int firstNonRepeatingCharacter(String string) {
        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++){
            String current = String.valueOf(string.charAt(i));
            map.put(current, map.getOrDefault(current, 0) + 1);
        }

        for(int i = 0; i < string.length(); i++){
            String current = String.valueOf(string.charAt(i));
            if(map.get(current) == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        String input = "abcdcaf";
        System.out.println(firstNonRepeatingCharacter(input));
    }
}
