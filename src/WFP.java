
public class WFP {
    public static int wellFormedParExp(String exp) {
        Ar_Stack<Character> stack = new Ar_Stack<>();
        int matchedCount = 0;

        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return -1; // Unmatched closing parenthesis
                }
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return -1; // Mismatched parenthesis
                }
                matchedCount++;
            }
        }

        return stack.isEmpty() ? matchedCount : -1; // Ensure no unmatched opening parenthesis
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        System.out.println(wellFormedParExp("[Hello. ( How are ) you?]")); // 2
        System.out.println(wellFormedParExp("[ { ( [X] ) } ]")); // 4
        System.out.println(wellFormedParExp("Today is before tomorrow.")); // 0
        System.out.println(wellFormedParExp("(Good evening.")); // -1
        System.out.println(wellFormedParExp("[ ( ] )")); // -1
    }
}
