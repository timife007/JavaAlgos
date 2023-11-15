package algoexpert;

import java.util.HashMap;
import java.util.Map;

public class CipherEncryptor {

    public static String optimized (String str, int key){
        Map<Character, Integer> xters = new HashMap<>();

        String items = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < items.length(); i++ ){
            xters.put(items.charAt(i), i + 1);
        }
        for(int j = 0; j < str.length(); j++){
            char item = str.charAt(j);
            int newIdx = (xters.get(item) + key) % 26;
            if(newIdx != 0){
                result.append(items.charAt(newIdx - 1));
            }else{
                result.append(items.charAt(25));
            }
        }
        return result.toString();
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // Write your code here.

        String alph = "#abcdefghijklmnopqrstuvwxyz";
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char item = str.charAt(i);
            int index = (alph.indexOf(item) + key) % 26;
            if(index != 0){
                result.append(alph.charAt(index));
            }else{
                result.append(alph.charAt(26));
            }
        }
        return result.toString();
    }

    public static void main(String[] args){
        String input = "xyz";
        System.out.println(optimized(input, 2));
        int unicode = 'A';
        System.out.println(unicode);
    }
}
