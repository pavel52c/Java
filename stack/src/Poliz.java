public class Poliz {

    public static boolean brackets(String str) throws Exception {
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

    public static int priority(char chr) {
        return switch (chr) {
            case '(' -> 0;
            case ')' -> 1;
            case '+', '-' -> 2;
            case '*', '/' -> 3;
            case '^' -> 4;
            default -> -1;
        };
    }

    public static String rePolNat(String str) throws Exception {
        String result = "";
        int size = str.length();
        Stack<Character> s = new Stack<>(new Character[size]);
        int prioritet;

        char c;
        for (int i = 0; i < size; i++) {
            c = str.charAt(i);
            if (c == ' ') continue;
            prioritet = priority(c);
            switch (prioritet) {
                case -1 -> result += c;
                case 0 -> s.push(c);
                case 1 -> {
                    result += ' ';
                    while (priority(s.peek()) > 0)
                        result += s.pop();
                    s.pop();
                }
                default -> {
                    result += ' ';
                    while (!s.isEmpty() && priority(s.peek()) >= prioritet)
                        result += s.pop();
                    s.push(c);
                }
            }
        }
        while (!s.isEmpty()) result += s.pop();
        return result;
    }

    public static double solve(String str) throws Exception {
        if (!brackets(str)) throw new Exception("Wrong brakets sequence");
        str = rePolNat(str);
        int size = str.length();
        Stack<Double> s = new Stack<>(new Double[size]);
        Stack<Character> d = new Stack<>(new Character[size]);
        double k = 0;
        int j = 0;
        boolean dot = false;

        char c;
        for (int i = 0; i < size; i++) {
            c = str.charAt(i);
            if (c - '0' >= 0 && c - '0' <= 9 || c == '.') {
                d.push(c);
                if (dot) j++;
                if (c == '.') dot = true;
            } else {
                if (c != '+' && c != '-' && c != '*' && c != '/' && c != '^'
                        && c != ' ') throw new Exception("Wrong symbol");
                if (!d.isEmpty()) {
                    if (dot) {
                        while (d.peek() != '.') {
                            k += (d.pop() - '0') * Math.pow(10, -j);
                            j--;
                        }
                        dot = false;
                        d.pop();
                    }
                    j = 0;
                    while (!d.isEmpty()) {
                        k += (d.pop() - '0') * Math.pow(10, j++);
                    }
                    j = 0;
                    s.push(k);
                    k = 0;
                }
                switch (c) {
                    case '+' -> s.push(s.pop() + s.pop());
                    case '-' -> {
                        k = s.pop();
                        s.push(-k + (s.isEmpty() ? 0 : s.pop()));
                        k = 0;
                    }
                    case '*' -> s.push(s.pop() * s.pop());
                    case '/' -> {
                        double x = s.pop();
                        double y = s.pop();
                        if (Math.abs(x) < 0.000000001) throw new Exception("Division by zero");
                        s.push(y / x);
                        k = 0;
                    }
                    case '^' -> {
                        double deg = s.pop();
                        s.push(Math.pow(s.pop(), deg));
                    }
                    default -> {
                    }
                }
            }
        }
        return s.pop();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(rePolNat("a-b + c"));
        try {
            System.out.println(solve("((1+2)*(3-4)^2)/(5-4)"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
