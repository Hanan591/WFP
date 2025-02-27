package stackqueue;
import java.util.*;

public class WFP {
    public static int wellFormedParExp(String exp) throws Exception {
        Ar_Stack<Character> stack = new Ar_Stack<Character>();
        int count = 0;

        for (char c : exp.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return -1; 
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return -1; 
                }
                count++;
            }
        }

        return stack.isEmpty() ? count : -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(wellFormedParExp("[Hello. ( How are ) you?]")); 
        System.out.println(wellFormedParExp("[ { ( [X] ) } ]")); 
        System.out.println(wellFormedParExp("Today is before tomorrow.")); 
        System.out.println(wellFormedParExp("(Good evening.")); 
        System.out.println(wellFormedParExp("[ ( ] )"));
    }
}