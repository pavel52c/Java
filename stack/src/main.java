public class main {
    public static void main(String[] args) {
        String str = "(()([{}]){})";
        System.out.println("String: " + str);
        try {
            System.out.println("String is rightBrackets? " + rightBrackets(str));
        }catch (Exception error) {
            System.out.println(error.getMessage());
        }
    }

    public static boolean rightBrackets(String str) throws Exception {
        if (str.length() % 2 != 0)
            return false;
        Character[] chars = new Character[10];
        Stack<Character> stack = new Stack<>(chars);
        char c;

        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == '}' || c == ')' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top;
                    top = stack.peek();

                    if (top == '{' && c == '}' || top == '(' && c == ')' || top == '[' && c == ']') {
                        try {
                            stack.pop();
                        } catch (Exception error) {
                            System.out.println(error.getMessage());
                            return false;
                        }
                    } else
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
