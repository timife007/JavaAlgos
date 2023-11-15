package algoexpert;

public class PalindromeString {
    public static Boolean isPalindrome(String str){
        if(str.length() <= 1) return true;
        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        String input = "abcdecba";
        System.out.println(isPalindrome(input));
    }
}
