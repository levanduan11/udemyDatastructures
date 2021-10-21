package Linlist;

public class stack<T> {
    int size;
    testLinklist<T> t;

    stack() {
        this.size = 0;
        t = new testLinklist<>();
    }

    public T pop() {
        size--;
        return t.removeLast();
    }

    public void put(T data) {
        size++;
        t.add(data);
    }

    public T peek() {
        return t.findLast().data;
    }

    public void print() {

        while (!isEmpty()) {
            System.out.print(pop() + "  ");
        }
    }

    boolean isEmpty() {
        return size == 0;
    }

    int size() {
        return size;

    }

    public static void main(String[] args) {
        stack<Integer> t = new stack<>();
        t.put(1);
        t.put(2);
        t.put(3);
        int k=t.peek();
        System.out.println(k);
        t.print();


    }
}
