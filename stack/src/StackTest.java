import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class StackTest {

    @Test
    void isEmpty() {
        Stack<String> stack = new Stack<>(new String[10]);
        Assertions.assertTrue(stack.isEmpty());
    }

    @Test
    void isEmpty1() {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; ++i)
            arr[i] = i;
        Stack<Integer> stack = new Stack<>(arr);
        Assertions.assertFalse(stack.isEmpty());
    }

    @Test
    void peek() throws Exception {
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 10; ++i)
            arr[i] = i;
        Stack<Integer> stack = new Stack<>(arr);
        Assertions.assertEquals(9, stack.peek());
    }

    @Test
    public void peekException()  {
        Integer[] arr = new Integer[10];
        Stack<Integer> stack = new Stack<>(arr);
        Assertions.assertThrows(Exception.class, () -> {
            stack.peek();
        });
    }

    @Test
    public void push() throws Exception{
        Integer[] arr = new Integer[10];
        Stack<Integer> stack = new Stack<>(arr);
        stack.push(1);
        stack.push(3);
        Assertions.assertEquals(3,stack.peek());
    }

    @Test
    public void pop() throws Exception{
        Integer[] arr = new Integer[10];
        Stack<Integer> stack = new Stack<>(arr);
        stack.push(0);
        stack.push(5);
        Assertions.assertEquals(5,stack.pop());
        Assertions.assertEquals(0,stack.peek());
    }

    @Test
    public void popException(){
        Integer[] arr = new Integer[10];
        Stack<Integer> stack = new Stack<>(arr);
        Assertions.assertThrows(Exception.class,()->{
            stack.pop();
        });
    }
}