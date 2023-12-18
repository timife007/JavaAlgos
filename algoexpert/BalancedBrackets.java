package algoexpert;

import java.util.Stack;

public class BalancedBrackets {
    public static boolean balancedBrackets(String str) {
        // Write your code here.
        if(str.length() == 1) return false;
        int pointer = 0;
        Stack<Character> stack = new Stack<>();

        while(pointer < str.length()){
            char current = str.charAt(pointer);
            if(str.charAt(pointer) == '{' || str.charAt(pointer) == '(' || str.charAt(pointer) == '['){
                stack.push(str.charAt(pointer));
            }else{
                if(current == '}'){
                    if(stack.isEmpty() || stack.pop() != '{'){
                        return false;
                    }
                }else if(current == ']'){
                    if(stack.isEmpty() || stack.pop() != '['){
                        return false;
                    }
                }else if(current == ')'){
                    if(stack.isEmpty() || stack.pop() != '('){
                        return false;
                    }
                }
            }
            pointer += 1;
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        System.out.println(balancedBrackets("(){{"));
    }
}
