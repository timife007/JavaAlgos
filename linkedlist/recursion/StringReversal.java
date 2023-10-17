package linkedlist.recursion;

public class StringReversal {


    static String reverseString(String word){
        if(word.isEmpty()) return word;

        return reverseString(word.substring(1)) + word.charAt(0);
    }


    public static void main(String[] args){
        System.out.println(reverseString("timife"));

    }
}
