import java.util.*;

class Stack<T> {
    private int size;
    private T[] stack;
    private int current = 0;

    Stack(T[] stack) {
        this.stack = stack;
        for (T t : stack) {
            if (t != null) {
                current++;
                size++;
            } else
                break;
        }
    }

    boolean isEmpty() {
        return  size==0;
    }

    int getSize() {
        return size;
    }

    void push(T el) {
        if (current < stack.length) {
            stack[current] = el;
            current++;
        } else {
            T[] stack1 = (T[]) (new Object[stack.length * 2]);
            stack1 = Arrays.copyOf(stack, size - 1);
            stack1[size - 1] = el;
            stack = stack1;
        }
        size++;
    }

    T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Пустой стек");
        --current;
        --size;
        return stack[current];
    }

    T peek() throws Exception {
        if (isEmpty())
            throw new NullPointerException("Пустой стек");
        return stack[current - 1];
    }

    void printStack() {
        for (T t : stack) {
            if (t != null)
                System.out.print(t + " ");
            else
                break;
        }
    }
}
