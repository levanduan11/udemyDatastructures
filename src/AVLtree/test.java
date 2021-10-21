package AVLtree;

public class test<K extends Comparable<K>, V> {
    private node root;
    int size = 0;

    public test() {

    }

    static class node<K, V> {
        node l;
        node r;
        node p;
        K k;
        V v;


        public node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public void insert(K k, V v) {
        node t = root;
        this.root = insert(t, k, v);

        this.size++;
    }

    private node insert(node r, K k, V v) {
        if (r == null) {
            return new node(k, v);
        }
        int c = k.compareTo((K) r.k);
        if (c > 0) {
            r.r = insert(r.r, k, v);
            r.r.p = r;
        } else if (c < 0) {
            r.l = insert(r.l, k, v);
            r.l.p = r;
        } else {
            r.v = v;

        }
        return r;
    }

    private void r() {
        node r = root;
        r = rotateL(r);

    }

    private node rotateR(node root) {
        node t = root.l;
        node p = root.p;
        root.l = t.r;
        if (t.r != null) {
            t.r.p = root;
        }
        t.r = root;
        root.p = t;
        t.p = p;
        if (p != null) {
            if (p.l == root) {
                p.l = t;
            } else {
                p.r = t;
            }
        } else {
            this.root = t;
        }
        return t;
    }
    private node rotateL(node root) {
        node t = root.r;
        node p = root.p;
        root.r = t.l;
        if (t.l != null) {
            t.l.p = root;
        }
        t.l = root;
        root.p = t;
        t.p = p;
        if (p != null) {
            if (p.l == root) {
                p.l = t;
            } else {
                p.r = t;
            }
        } else {
            this.root = t;
        }
        return t;
    }


    public void print() {
        node r = root;
        print(r);

    }

    private void print(node r) {
        if (r == null) return;
        print(r.l);
        System.out.println(r.v);
        print(r.r);
    }

    public static void main(String[] args) {
        test<Integer, Integer> r = new test<>();
        r.insert(5, 5);
        r.insert(6, 6);
        r.insert(7, 7);
        r.r();
        r.print();
        System.out.println(r.root.v);
    }
}
