package algoexpert;

public class LongestPalindromicSubstring {

    //Time complexity O(N3), space O(N)
    public static String longestPalindromicSubstring(String str) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        String result = "";
        for(int i = 0; i < str.length(); i++){
            for(int j = str.length(); j > i; j--){
                String substring = str.substring(i, j);
                if(isPalindrome(substring)){
                    int diff = j - 1 - i;
                    if(diff > max){
                        result = substring;
                        max = diff;
                    }
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String word){
        if(word.length() == 1) return true;
        int start = 0;
        int end = word.length() - 1;

        while(start <= end){
            if(word.charAt(start) != word.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    public static String optimizedLPS(String str){
        int max = Integer.MIN_VALUE;
        String result = "";
        for(int i = 0; i < str.length(); i++){
            int back = i;

            String current = palindrome(str, i, back);
            if(current.length() > max){
                result = current;
                max = current.length();
            }
            back  = i - 1;

            String current2 = palindrome(str, i, back);
            if(current2.length() > max){
                result = current2;
                max = current2.length();
            }
        }

        return result;
    }

    public static String palindrome(String word, int front, int back){
        int x = front;
        int y = back;
        while((x < word.length() && y >= 0) && word.charAt(x) == word.charAt(y)){
            x++;
            y--;
        }
        return word.substring(y + 1, x);
    }

    public static void main(String[] args){
        String input = "abaxyzzyxf";
        System.out.println(optimizedLPS(input));
    }
}
