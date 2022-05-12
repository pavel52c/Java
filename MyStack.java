package task3;


public class MyStack<T> {
    private int maxSize;
    private T[] array;
    private int top;
    
    public MyStack(T[] array) {
        this.maxSize = array.length;
        this.array = array.clone();
        top = -1;
    }
	
    public void push(T element) throws Exception {
        if (top == maxSize) throw new Exception("Stack is already full");
        array[++top] = element;
    }
    
    public T pop() throws Exception {
        if (top < 0) throw new Exception("No such element");
        return array[top--];
    }
    
    public boolean isEmpty() {
        return top < 0;
    }
    
    public boolean isFull() {
        return top == maxSize - 1;
    }
    
    public T peek() {
        return array[top];
    }
    
    public class MyIter {
        private int position;
        
        public MyIter() {
            position = top + 1;
        }
        
        public boolean hasNext() {
            return position - 1 > 0;
        }
        
        public T next() throws IndexOutOfBoundsException {
            if (position - 1 < 0) throw new IndexOutOfBoundsException("End of stack.");
            position--;
            return array[position];
        }
    }
}
