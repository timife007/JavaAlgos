package algoexpert;

public class ReverseWordsInString {


    public static String reverseWordsInString(String string) {
        // Write your code here.
        if(string.length() == 1) return string;

        int pointer = string.length() - 1;
        StringBuilder builder = new StringBuilder();
        while(pointer >= 0){
            int end = pointer + 1;

            while(pointer >= 0 && !String.valueOf(string.charAt(pointer)).isBlank()){
                pointer--;
            }
            builder.append(string, pointer + 1, end);
            while(pointer >= 0 && String.valueOf(string.charAt(pointer)).isBlank()){
                builder.append(" ");
                pointer--;
            }

        }
        return builder.toString();
    }

    public static void main(String[] args){
        String input = "Algoexpert is the best!";

        System.out.println(reverseWordsInString(input)); // "best! the is Algoexpert"
//        reverseWordsInString(input);
    }
}
