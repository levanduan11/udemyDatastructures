package Linlist;

import java.util.LinkedList;
import java.util.Objects;

public class testLinklist<T> {
    node<T> head;
    int size;

    testLinklist() {
        size = 0;
    }

    static class node<T> {
        node next;
        T data;


        public node(T data) {
            this.next = null;
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            // if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            node<?> node = (node<?>) o;
            return this.data == ((node<?>) o).data;
        }

        @Override
        public int hashCode() {
            return Objects.hash(next, data);
        }

    }

    void swap(node a, node b) {
        T t = (T) a.data;
        a.data = b.data;
        b.data = t;
    }

    void addfist(T data) {
        if (head == null) {
            head = new node<>(data);

        } else {
            node n = new node(data);
            n.next = head;
            head = n;
        }
        size++;
    }

    void swa() {
        node c = head.next.next;
        swap(this.head, c);
    }

    T get(int index) {
        if (index == 0)
            return head.data;
        else
            return (T) finIndex(index).data;
    }

    node<T> findLast() {
        node c = head;
        while (c.next != null) {
            c = c.next;
        }
        return c;
    }

    node finIndex(int index) {
        node c = head;
        for (int i = 0; i < index; i++) {
            c = c.next;
        }
        return c;
    }

    void clear() {
        //    head.next=null;
        head = null;
        size = 0;
    }

    void reverser() {

        node nhead = findLast();

        for (int j = this.size - 1; j > 0; j--) {
            node l = finIndex(j);
            node y = finIndex(j - 1);
            l.next = y;
            y.next = null;
        }
        head = nhead;


    }

    void add(T data) {
        if (this.head == null) {
            this.head = new node(data);
            size++;
            return;
        }
        node n = head;
        while (n.next != null) {
            n = n.next;
        }
        n.next = new node(data);
        size++;

    }

    private boolean contains(T n, node head) {
        if (head == null) return false;
        if (n.equals(head.data)) return true;
        return contains(n, head = head.next);
    }

    boolean contains(T n) {
        node c = head;
        return contains(n, c);
    }

    boolean isEmpty() {
        return size == 0;
    }

    T removeFist() {
        if (head.next == null) {
            T y = head.data;
            head = null;
            return y;
        }
        node tmp = head;
        head = head.next;
        size--;
        return (T) tmp.data;
    }

    //T removeLast(){
//    node t = head;
//    while (t.next.next != null) {
//        t = t.next;
//    }
//    T e = (T) t.next.data;
//    t.next = null;
//    size--;
//    return e;
//}
    T removeLast() {
        node k = head;
        if (k.next == null) {
            T y = (T) k.data;
            head = null;
            size--;
            return y;

        }
        for (int i = 0; i < size - 2; i++) {
            k = k.next;
        }
        T o = (T) k.next.data;
        k.next = null;
        size--;
        return o;

    }

    T remove(int index) {
        if (index < 0 || index >= size) throw new NullPointerException("VỊ trí xóa không hợp lệ ");
        if (index == 0) {

            return removeFist();
        } else if (index == size - 1) {
            return removeLast();
        }
        node t = head;
        int cout=0;
        for (int i = 0; i < index - 1; i++) {
            t = t.next;
            cout++;
        }
        System.out.println(cout);
        node v = t.next;
        t.next = t.next.next;
        v.next=null;
        size--;
        return (T) v.data;
    }

    int size() {
        return this.size;
    }
void diplay(){
        node n=this.head;
        node k=null;
    for (int i = 0; i < 4-1; i++) {
k=n;
        n=n.next;
    }
    System.out.println(k.data);
    System.out.println(n.data);
}
    void print() {

        for (node i = head; i != null; i = i.next) {
            System.out.print(i.data + "  ");
        }
    }

    public static void main(String[] args) {
        testLinklist<Integer> g = new testLinklist<>();

        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.add(5);
        g.add(6);
g.diplay();
    }


}
