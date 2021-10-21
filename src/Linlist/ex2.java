package Linlist;
//lien ket vong
public class ex2 {
    node head;
    node tail;
    int size;
    static boolean ch = true;

    public ex2() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    static class node {
        node next;
        int data;

        public node(int data) {

            this.next = null;
            this.data = data;
        }
    }

    void add(int data) {
        node n = new node(data);
        if (head == null) {

            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
            tail.next = head;
        }
        this.size++;
    }

    node ad(int data) {
        node n = this.head;
        this.size++;
        head = add(n, this.size - 1, data);
        return head;
    }

    node add(node h, int n, int data) {
        if (n == 0) {
            node f = new node(data);
            f.next = h;
            this.tail = f;
            return f;
        }
        h.next = add(h.next, n = n - 1, data);
        return h;

    }

    int remove() {
        node n = this.head;
        if (head == null) {
            throw new NullPointerException("danh sach rong");
        }
        if (this.size == 1) {
            head = tail = null;
            this.size--;
            return n.data;
        }
        node de = this.tail;

        for (int i = 0; i < this.size - 2; i++) {
            n = n.next;
        }
        n.next = null;
        n.next = this.head;
        this.tail = n;
        this.size--;
        return de.data;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    void print() {
        node n = this.head;
        for (int i = 0; i < this.size; i++) {
            System.out.println(n.data);
            n = n.next;
        }
    }

    void p() {
        node n = this.head;
        print(n);
    }

    int removeAt(int index) {
        node d;
        node k = null;

        if (size == 0 || index >= size) {
            throw new NullPointerException("xoa khong hop le");
        }
        if (head.next == head) {
            d = head;
            head = tail = null;
        } else if (index == 0) {

            d = head.next;
            head = null;
            tail.next = d;
            head = d;

        } else {
            d = this.head;
            for (int i = 0; i < index; i++) {
                k = d;
                d = d.next;
            }
            k.next = d.next;
            d.next = null;
            if (index == size - 1) {
                this.tail = k;
            }
        }
        this.size--;
        return d.data;
    }

    void addAt(int index, int data) {
        if (index < 0 || index > size) {
            throw new NullPointerException("xin vui lòng chèn vào vị trí lớn hơn không \n và bé hơn hoặc bằng size");
        }
        node n = new node(data);
        if (index == 0) {
            if (this.head == null) {
                this.head = this.tail = n;
            } else {
                n.next = head;
                tail.next = n;
                head = n;
            }
        } else if (index == size) {
            n.next = head;
            tail.next = n;
            tail = n;
        } else {
            node c = this.head;
            for (int i = 0; i < index - 1; i++) {
                c = c.next;
            }
            n.next = c.next;
            c.next = n;
        }
        this.size++;
    }

    void print(node h) {
        if (h != this.head || ch) {
            ch = false;
            System.out.println(h.data);
            print(h.next);
        }

    }

    void check() {
        node n = this.head;
        int c = 0;
        for (int i = 0; i < 2; i++) {
            n = n.next;
            c++;
        }
        System.out.println(c);
        System.out.println(n);
        System.out.println(n.data);
    }

    public static void main(String[] args) {
        ex2 y = new ex2();
        y.add(1);
        y.add(2);
        y.add(3);
        y.add(4);
        y.add(5);
        y.check();
      //  y.print();



    }
}
