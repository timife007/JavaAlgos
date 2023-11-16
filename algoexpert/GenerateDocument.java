package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < characters.length(); i++){
            String current = String.valueOf(characters.charAt(i));
            map.put(current, map.getOrDefault(current, 0) + 1);
        }
        for(int j = 0; j < document.length(); j++){
            String current = String.valueOf(document.charAt(j));
            if(map.containsKey(current)){
                map.put(current, map.get(current) - 1);
                if(map.get(current) == 0) {
                    map.remove(current);
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String characters = "A";
        String document = "a";
        System.out.println(generateDocument(characters, document));
//        String item = "Bo!@ ";
//        System.out.println(item.charAt(4));
    }
}
