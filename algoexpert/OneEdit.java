package algoexpert;

public class OneEdit {

    public static boolean oneEdit(String stringOne, String stringTwo) {
        if(Math.abs(stringOne.length() - stringTwo.length()) > 1){
            return false;
        }
        // Write your code here.
        int pointer1 = stringOne.length() - 1;
        int pointer2 = stringTwo.length() - 1;
        int count = 0;

        while(pointer1 >= 0 && pointer2 >= 0){
            if(stringOne.charAt(pointer1) == stringTwo.charAt(pointer2)){
                pointer2--;
                pointer1--;
                continue;
            }
            if(stringOne.charAt(pointer1) != stringTwo.charAt(pointer2)){
                if(stringOne.length() > stringTwo.length()){
                    pointer1--;
                }else if(stringOne.length() < stringTwo.length()){
                    pointer2--;
                }else{
                    pointer1--;
                    pointer2--;
                }
                count++;
            }
            if(count > 1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String input1 = "hello";
        String input2 = "hollo";
        System.out.println(oneEdit(input1, input2));

    }
}
