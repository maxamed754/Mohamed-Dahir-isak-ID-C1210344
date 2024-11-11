import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> {
    // Variables
    private static final int DEFAULT_CAPACITY = 3;
    private int top;
    private T[] stack;

    // Constructors
    public ArrayStack(int size) {
        top = 0;
        stack = (T[]) new Object[size];
    }

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    // Stack operations
    int size() {
        return top;
    }

    boolean isEmpty() {
        return top == 0;
    }

    boolean isFull() {
        return top == stack.length;
    }

    void push(T element) {
        if (isFull())
            expandCapacity();
        stack[top] = element;
        top++;
    }

    private void expandCapacity() {
        stack = Arrays.copyOf(stack, stack.length * 2);
    }

    T peek() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        return stack[top - 1];
    }

    T pop() throws EmptyStackException {
        if (isEmpty())
            throw new EmptyStackException();
        top--;
        T removedElement = stack[top];
        stack[top] = null;
        return removedElement;
    }

    @Override
    public String toString() {
        return "ArrayStack{" + "top=" + top + ", stack=" + Arrays.toString(stack) + '}';
    }

    public int getLength() {
        return stack.length;
    }

    public void display() {
        for (int i = top - 1; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }


    public ArrayStack<T> merge(ArrayStack<T> list1, ArrayStack<T> list2) {
        ArrayStack<T> mergedStack = new ArrayStack<>(list1.size() + list2.size());
        for (int i = 0; i < list1.size(); i++) {
            T element = list1.stack[i];
            if (!mergedStack.contains(element)) {
                mergedStack.push(element);
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            T element = list2.stack[i];
            if (!mergedStack.contains(element)) {
                mergedStack.push(element);
            }
        }

        return mergedStack;
    }


    private boolean contains(T element) {

        for (int i = 0; i < top; i++) {
            if (stack[i].equals(element)) {
                return true;
            }
        }
        return false;
    }



    public static void main(String[] args) {
        ArrayStack<Integer> list1 = new ArrayStack<>();
        ArrayStack<Integer> list2 = new ArrayStack<>();
        ArrayStack<Integer> list3 = new ArrayStack<>();

        list1.push(100);
        list1.push(200);
        list1.push(100);
        list1.push(900);

        list2.push(300);
        list2.push(900);
        list2.push(400);
        list2.push(200);


        System.out.println("no duplicates: "+list3.merge(list1,list2));
//        mergedList.display();
    }
}
