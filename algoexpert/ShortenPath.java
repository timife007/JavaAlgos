package algoexpert;

import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class ShortenPath {

    public static String shortenPath(String path) {
        // Write your code here;
        boolean startsWithSlash = path.charAt(0) == '/';
        String[] split = path.split("/");
        var filtered = Arrays.stream(split).filter(item -> !item.isEmpty() && !item.equals(".")).toArray();
        Stack<String> stack = new Stack<>();
        if(startsWithSlash){
            stack.push("");
        }
        for(Object token: filtered){
            if(token.toString().equals("..")){
                //The case of having double dots at the top of the stack only happens in a
                //relative path when we're at the beginning or near it in the relative path,
                //so in that case, we add the paths.
                if(stack.isEmpty() || stack.peek().equals("..")){
                    stack.push(token.toString());
                }else if(!stack.peek().isEmpty()){
                    stack.pop();
                }
            }else{
                stack.push(token.toString());
            }
        }
        if(stack.size() == 1 && startsWithSlash){
            return "/";
        }

        return String.join("/", stack);
    }

    public static void main(String[] args){
        String input = "../../../this////one/./../../is/../../going/../../to/be/./././../../../just/eight/double/dots/../../../../../../foo";
//        System.out.print(shortenPath(input));
        String[] split = input.split("/");
        var filtered = Arrays.stream(split).filter(item -> !item.isEmpty() && !item.equals(".")).toArray();
        System.out.println(Arrays.toString(filtered));
        System.out.println(shortenPath(input));
    }
}
