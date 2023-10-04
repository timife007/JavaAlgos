package stack;

import java.util.Stack;

public class DelimiterMatching {
    String input;

    DelimiterMatching(String input) {
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
                case '}', ']', ')':
                    if (!stackX.isEmpty()) {
                        char charx = stackX.pop();
                        if (character == '}' && charx != '{' ||
                                character == ')' && charx != '(' ||
                                character == ']' && charx != '['
                        ) {
                            System.out.println("error at position :" + i + "with wrong delimiter" + charx);
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
