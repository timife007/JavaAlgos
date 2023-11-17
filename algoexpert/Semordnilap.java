package algoexpert;

import java.util.*;

public class Semordnilap {

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
        ArrayList<ArrayList<String>> outer = new ArrayList<>();
        // Write your code here.
        for(int i = 0; i < words.length; i++){
            ArrayList<String> inner = new ArrayList<>();
            for(int j = i + 1; j < words.length; j++){
                if(isReverse(words[i], words[j])){
                    inner.add(words[i]);
                    inner.add(words[j]);
                    outer.add(inner);
                }
            }
        }

        return outer;
    }

    public static boolean isReverse(String word, String item){
        if(word.length() != item.length()) return false;

        int start= 0;
        int end = word.length() - 1;

        while(start <= end){
            if(word.charAt(start) != item.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


//    public ArrayList<ArrayList<String>> semordnilapOptimized(String[] words) {
//        // Write your code here.
//        List<String> list= Arrays.asList(words);
//        Set<String> set = new HashSet<>(Arrays.asList(words));
//        ArrayList<ArrayList<String>> outer = new ArrayList<>();
//        for(int j = 0; j < set.size(); j++){
////            String current = set.;
//            String reversed = reverse(current);
//            if(list.contains(reversed)){
//                ArrayList<String> inner = new ArrayList<>();
//                inner.add(list.get(j));
//                inner.add(reversed);
//                outer.add(inner);
//            }
//        }
//
//        return outer;
//    }

//    public static String reverse(String word){
//        StringBuilder builder = new StringBuilder();
//        for(int i = word.length() - 1; i >= 0; i--){
//            String current = String.valueOf(word.charAt(i));
//            builder.append(current);
//        }
//
//        return builder.toString();
//    }

    public static void main(String[] args){
        String[] input = new String[]{"dog", "hello", "god"};
        System.out.println(isReverse("dog", "god"));
        System.out.println(semordnilap(input));

    }
}
