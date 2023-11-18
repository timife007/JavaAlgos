package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidIpAddress {
    public static ArrayList<String> validIPAddresses(String string) {
        // Write your code here.
        //Iterate to a max of three digits; to the min of length and 4 to
        //avoid index out of bound error.
        ArrayList<String> result = new ArrayList<>();
        for(int i = 1; i < Math.min(4, string.length()); i++){
            String[] current = new String[4];
            StringBuilder builder = new StringBuilder();
            current[0] = string.substring(0, i);
            if (!isValid(current[0])){
                continue;
            }
            for (int j = i + 1; j < i + Math.min(4, string.length() - i); j++){
                 current[1] = string.substring(i, j);
                 if(!isValid(current[1])){
                     continue;
                 }
                 for(int k = j + 1; k < j + Math.min(4, string.length() - j); k++){
                     current[2] = string.substring(j, k);
                     current[3] = string.substring(k);
                     if(isValid(current[2]) && isValid(current[3])){
                         for(int p = 0; p < current.length; p++){
                             if(p == 0){
                                 builder.append(current[p]);
                                 continue;
                             }
                             builder.append(".").append(current[p]);
                         }
                         result.add(builder.toString());
                         builder = new StringBuilder();
                     }
                 }
            }

        }
        return result;
    }

    public static boolean isValid(String string){
        int value = Integer.parseInt(string);
        if(value > 255){
            return false;
        }
        return String.valueOf(value).length() == string.length();
    }

    public static void main(String[] args){
        String input = "1921680";
        System.out.println(validIPAddresses(input));
    }
}
