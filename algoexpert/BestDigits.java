package algoexpert;

import java.util.Stack;

public class BestDigits {
    public static String bestDigits(String number, int numDigits){
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            int current = Integer.parseInt(String.valueOf(number.charAt(i)));
            while(!stack.isEmpty() && numDigits > 0 && current > stack.peek()){
                stack.pop();
                numDigits -= 1;
            }
            stack.push(current);
        }
        while(numDigits > 0){
            stack.pop();
            numDigits -= 1;
        }
        for(int i : stack){
            result.append(i);
        }

        return result.toString();
    }

    public static void main(String[] args){
        System.out.println(bestDigits("462839", 2));
    }
}
