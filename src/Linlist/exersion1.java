package Linlist;

import java.util.*;
//lien ket don
public class exersion1<E> {
    node<E> head;
    int size;
    Object[] elem;
    static boolean c = true;

    exersion1(E[] ele) {

        createList(ele);
        this.size = ele.length;
        node c = this.head;
        this.elem = toArray();

    }

    public exersion1() {
    }

    E getElearray(int index) {
        if (index < 0 || index >= size) throw new ArrayIndexOutOfBoundsException("vi tri khong hop le");
        return (E) this.elem[index];
    }

    void sort() {
        Arrays.sort(this.elem);
    }

    void showsort() {
        sort();
        for (Object s : this.elem
        ) {
            System.out.println(s);
        }
    }

    class node<E> implements Comparator<E> {
        node next;
        E data;


        node(E data) {
            this.data = data;
            this.next = null;
        }


        @Override
        public int compare(E a, E b) {
            return (int) a - (int) b;
        }
    }

    void createList(E[] element) {

        head = new node<>(element[0]);
        head.next = null;
        node last = head;

        for (int i = 1; i < element.length; i++) {
            node n = new node(element[i]);
            n.next = null;
            last.next = n;
            last = n;
        }


    }

    void reverList(node l) {
        if (l.next.next != null) {
            reverList(l.next);
        }
        if (l.next.next == null && c) {
            c = false;
            this.head = l.next;
        }

        node t = l.next;
        t.next = l;
        l.next = null;


    }

    node addr(E data) {
        node n = head;
        size++;
        head=addR(head,data);
        return head;
    }

    node addR(node head, E data) {
        if (head == null) {
            node n = new node(data);
            return n;
        }
        head.next = addR(head.next, data);
        return head;

    }

    node removeR() {
        node n = this.head;
        return remveR(n);
    }

    node remveR(node head) {
        if (this.head == null) {
            return null;
        } else if (head.next == null) {
            size--;
            if (size == 0) {
                this.head = null;
            }
            return null;
        } else {
            head.next = remveR(head.next);
            return head;
        }

    }

    void rever() {
        //node a=null;
        node b = this.head;
        rever(b, b.next);
    }

    void rever(node a, node b) {

        if (b.next == null) {
            this.head = b;
            a.next = null;
            b.next = a;

            return;
        }
        rever(a.next, b.next);
        a.next = null;
        b.next = a;

    }

    void printRecusion(node head) {

        if (head == null) return;
        System.out.println(head.data);
        printRecusion(head.next);
    }


    void print() {
        node c = head;
        while (c != null) {
            System.out.println(c.data);
            c = c.next;
        }
    }

    void set(E data, int index) {
        if (index < 0 || index >= size) return;
        node n = this.head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        n.data = data;
    }

    int cout() {
        node n = head;
        return coutNode(n);
    }

    int coutNode(node head) {
        if (head == null) return 0;
        else {
            return coutNode(head.next) + 1;
        }
    }

    int sum() {
        node n = head;
        return sum(n);
    }

    int sum(node head, int s) {
        if (head == null) return s;
        int a = (int) head.data;
        return sum(head.next, s = s + a);
    }

    int sum(node head) {
        if (head == null) return 0;
        return sum(head.next) + (int) head.data;
    }

    int max(int a, int b) {
        return a > b ? a : b;
    }

    int rmax() {
        node n = this.head.next;
        int m = (int) this.head.data;
        return max(n, m);
    }

    int max(node head, int m) {
        if (head == null) return m;

        return max(head.next, m = max(m, (int) head.data));

    }

    int datamax() {
        int max = (int) head.data;
        for (node i = head.next; i != null; i = i.next) {
            max = max(max, (Integer) i.data);
        }

        return max;
    }

    public Object[] torArray(Object[] ele, node head, int cusor) {
        if (head == null) return ele;
        ele[cusor] = head.data;
        return torArray(ele, head.next, cusor = cusor + 1);

    }

    public Object[] toArray() {
        Object[] ele = new Object[this.size];
        node n = this.head;
        return torArray(ele, n, 0);
    }

    int max1(node head) {
        int x = 0;
        if (head.next == null) return (int) head.data;
        else {
            x = max1(head.next);
            if (x > (int) head.data) {
                return x;
            } else {
                return (int) head.data;
            }
        }
    }

    int max2(node head) {
        int x;
        if (head == null) return Integer.MIN_VALUE;
        x = max2(head.next);
        // return (int)max2(head.next)>(int)head.data?(int)max2(head.next): (int) head.data;
        return x > (int) head.data ? x : (int) head.data;

    }

    int max1() {
        node n = this.head;
        return max1(n);
    }

    void sort(Object[] ele) {

        Arrays.sort(ele);

    }

    int searchImprove(E data) {
        node n = this.head;
        return searchIprove(n, data);
    }

    int searchIprove(node head, E data) {
        node q = null;
        int index = 0;
        while (head != null) {
            if ((int) head.data == (int) data) {
                q.next = head.next;
                head.next = this.head;
                this.head = head;
                return index;
            } else {
                q = head;
                head = head.next;
                index++;
            }
        }
        return -1;
    }

    int search(int data) {
        node n = this.head;
        return searchHelper(n, data, 0);
    }

    int searchHelper(node head, int data, int found) {
        if (head == null) return -1;
        else if ((int) head.data == data) return found;
        else {
            return searchHelper(head.next, data, found = found + 1);
        }
    }

    boolean checksoterd(node a, node b) {
        if (b == null) return true;
        if (b != null) {
            if ((int) a.data > (int) b.data) return false;
        }
        return checksoterd(b, b.next);
    }

    boolean checksorted() {
        node a = this.head;
        return checksoterd(a, a.next);
    }

    void remvodup() {
        node a = this.head;
        removedup(a, a.next);
    }

    void removedup(node a, node b) {
        if (b == null) return;
        else if (a.data == b.data) {
            a.next = b.next;
            b.next = null;
            b = a.next;
            this.size--;
        } else {
            removedup(b, b.next);
        }

    }

    void rdup() {
        node a = this.head;
        node b = a.next;
        while (b != null) {
            if (a.data == b.data) {
                a.next = b.next;
                b.next = null;
                b = a.next;
                this.size--;
            } else {
                a = b;
                b = b.next;
            }
        }
    }

    void reverloop() {
        node a = null;
        node b = null;
        node c = this.head;
        while (c != null) {
            a = b;
            b = c;
            c = c.next;
            b.next = a;
        }
        this.head = b;
    }

    void rr() {
        node a = this.head;
        rr(null, a);
        //rr(a,a.next);
    }

    void rr(node a, node b) {
        if (b != null) {
            rr(b, b.next);
            b.next = a;
        } else {
            this.head = a;
        }
    }

    node findlast(exersion1<E> l1) {
        node n = l1.head;
        while (n.next != null) {
            n = n.next;
        }
        return n;
    }

    exersion1<E> concat(exersion1<E> l1, exersion1<E> l2) {
        node last = findlast(l1);
        node n = l2.head;
        last.next = n;
        l1.size += l2.size;
        return l1;
    }

    exersion1<E> merge(exersion1<E> l1, exersion1<E> l2) {
        boolean ch = (int) l1.head.data < (int) l2.head.data;
        node fist = ch ? l1.head : l2.head;
        node last = fist;
        node a = ch ? l1.head.next : l1.head;
        node b = !ch ? l2.head.next : l2.head;
        int size=l1.size+l2.size;
        last.next=null;
//        for (int i = 0; i < size; i++) {
//            //ch = (int) a.data > (int) b.data;
//            if(a==null&&b!=null){
//                last.next = b;
//                last = b;
//                b = b.next;
//            }
//            else if(b==null&&a!=null){
//                last.next = a;
//                last = a;
//                a = a.next;
//            }
//            else if((int) a.data > (int) b.data){
//                last.next = b;
//                last = b;
//                b = b.next;
//                last.next = null;
//            }else {
//                last.next = a;
//                last = a;
//                a = a.next;
//                last.next = null;
//            }
//        }
        while (a != null && b != null) {
            ch = (int) a.data > (int) b.data;
            if (ch) {
                last.next = b;
                last = b;
                b = b.next;
                last.next = null;
            } else {
                last.next = a;
                last = a;
                a = a.next;
                last.next = null;
            }
        }
        while (a != null) {
            last.next = a;
            last = a;
            a = a.next;
        }
        while (b != null) {
            last.next = b;
            last = b;
            b = b.next;
        }
        exersion1<E> res = new exersion1<>();
        res.head = fist;
        res.size=size;
        return res;
    }


    public static void main(String[] args) {
        Integer[] f = {1,2,3,4};
        Integer[] f2 = {3, 10,11, 12,55,700,900};
        //  String k[] = {"nguyen van a", "nguyen van b", "nguyen van c", "nguyen van d"};
        exersion1<Integer> p = new exersion1<>(f);
//        exersion1<Integer> p2 = new exersion1<>(f2);
//        exersion1<Integer> r = p.merge(p, p2);
        p.addr(5);
        p.addr(6);
        p.addr(7);
        p.print();

    }

}
