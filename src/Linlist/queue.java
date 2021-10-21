package Linlist;

import java.util.LinkedList;
import java.util.Queue;

public class queue<T> {
    int size;
    testLinklist<T> t;

    public queue() {
        this.size = 0;
        this.t = new testLinklist<>();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(T data) {
        t.add(data);
        size++;
    }

    public T poll() {
        size--;
        return t.removeFist();
    }

    public T peek() {
        return t.head.data;
    }

    public void print() {
        while (!isEmpty()) {
            System.out.print(poll() + " ");
        }
    }

    public static void main(String[] args) {
        queue<Integer> q = new queue<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.poll();
        System.out.println(q.size);
        q.print();

    }
}
