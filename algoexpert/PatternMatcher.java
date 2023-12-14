package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PatternMatcher {
    public static String[] patternMatcher(String pattern, String str) {
        // Write your code here.
        if(pattern.length() > str.length()) return new String[]{};

        char[] newPattern = getNewPattern(pattern);
        boolean didSwitch = newPattern[0] != pattern.charAt(0);
        int[] counts = getPatternCounts(pattern);
        int firstYPos = getFirstYPos(pattern);
        //if count of y != 0, meaning there's a y
        if(counts[1] != 0){
            for(int lenOfX = 1; lenOfX <= str.length(); lenOfX++){
                int lenOfY = (str.length() - (lenOfX * counts[0])) / counts[1];
                //if length of y is < than or = 0 or length of y is a decimal
                if(lenOfY <= 0 || lenOfY % 1 != 0){
                    continue;
                }
                int yIdx = firstYPos * lenOfX;

            }
        }
        return new String[0];
    }

    public static char[] getNewPattern(String pattern){
        char[] newPattern = pattern.toCharArray();
        if(pattern.charAt(0) == 'x'){
            return newPattern;
        }else{
            for(int j = 0; j < newPattern.length; j++){
                if(newPattern[j] == 'x'){
                    newPattern[j] = 'y';
                }else if(newPattern[j] == 'y'){
                    newPattern[j] = 'x';
                }
            }
        }
        return newPattern;
    }

    public static int getFirstYPos(String pattern){
        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'y'){
                return i;
            }
        }
        return -1;
    }

    public static int[] getPatternCounts(String pattern){
        int x = 0;
        int y = 0;

        for(int i = 0; i < pattern.length(); i++){
            if(pattern.charAt(i) == 'x'){
                x++;
            }else if(pattern.charAt(i) == 'y'){
                y++;
            }
        }
        return new int[]{x,y};
    }
    public static int checkOccurrences(String word, String substring){
        int count = 0;
        int index;
        int start = 0;
        while(start < word.length()){
            index = word.indexOf(substring, start);
            start = index + substring.length();
            if(index == -1){
                break;
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args){
        String pattern = "xxyxxy";
        String str= "gogopowerrangergogopowerranger";
        System.out.println(checkOccurrences(str, "powerrangerd"));


    }

}


/**
 * If they don't match, i.e if both valid i.e pattern contains xs and ys, then return empty array
 * If the pattern doesn't contain xs and ys, return an array, of empty strings, with the respective
 * letters in the normal string should be seen as an empty string.
 * ELSE
 * return the substrings in the normal string that can replace the pattern and equal the normal string.
 *
 */
/**
 * Get no of xs and no of ys, check for the occurrences of each that match the no of xs or ys in the pattern,
 * Use that to get the string that matches each pattern item, check if they are in order by following the
 * positions of each word in the string and iterate the pattern concurrently.
 *
 */