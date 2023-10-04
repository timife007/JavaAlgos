package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import static stack.ReverseApp.getString;

public class BracketChecker {
    String input;

    BracketChecker(String input) {
        this.input = input;
    }

    public void check() {
        int size = input.length();
        StackX stackX = new StackX(size);

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            switch (character) {
                case '{', '[', '(':
                    stackX.push(character);
                    break;
                case '}', ']', ')':
                    if (!stackX.isEmpty()) {
                        char charx = stackX.pop();
                        if (character == '}' && charx != '{' ||
                                character == ')' && charx != '(' ||
                                character == ']' && charx != '['
                        ) {
                            System.out.println("error at position: " + i + " with wrong delimiter " + character);
                        }
                    } else {
                        //Should not be empty at this point, it's premature
                        System.out.println("Error: Stack empty prematurely");
                    }
                    break;
                default:
                    //break if the character is not a delimiter.
                    break;
            }
        }
        if (!stackX.isEmpty()) {
            System.out.println("Error: missing right delimiter, stack should be empty at this point");
        }
    }
}

class BracketsApp {
    public static void main(String[] args) throws IOException {
        String input;
        while(true){
            System.out.println("Enter string containing delimiters: ");
            System.out.flush();
            input = getString();
            if(input.isEmpty())
                break;

            //Check if valid.
            BracketChecker bracketChecker = new BracketChecker(input);
            bracketChecker.check();
        }
    }
    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }
}
