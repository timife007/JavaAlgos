package linkedlist.recursion;

public class Palindrome {

    static Boolean isPalindrome(String data){
        if(data.isEmpty() || data.length() == 1) return true;

        if(data.charAt(0) != data.charAt(data.length() - 1)) return false;
        return isPalindrome(data.substring(1,data.length() - 1));
    }
    //OR

    static Boolean isPalindrome2(String data) {
        if (data.isEmpty() || data.length() == 1) return true;
        if(data.charAt(0) == data.charAt(data.length() - 1)){
            return isPalindrome(data.substring(1, data.length() - 1));
        }
        return false;
    }

    static String decimalToBinary(int num, String res){
        if(num == 0) return res;
        int rem = num % 2;
        res = res + rem;
        return decimalToBinary(num/2, res);
    }



    public static void main(String[] args){
        System.out.println(isPalindrome("kayak"));
        System.out.println(isPalindrome2("kayak"));
        System.out.println(decimalToBinary(32,""));
    }
}
