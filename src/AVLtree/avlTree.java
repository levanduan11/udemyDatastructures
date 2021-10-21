package AVLtree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.TreeSet;

public class avlTree<K extends Comparable<K>, V> {
    node<K, V> root;
    int size;


    public avlTree() {
        this.size = 0;

    }

    static class node<K, V> {
        node left;
        node right;
        K k;
        V v;
        int h;//chieu cao cua nut
        int bf;//do can bang nut

        public node(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    public int hight() {
        return (root == null) ? 0 : root.h;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void insert(K k, V v) {
        node r = this.root;
        root = insert(r, k, v);
        this.size++;
    }

    private node insert(node r, K k, V v) {
        if (r == null) {
            return new node(k, v);
        }
        int c = k.compareTo((K) r.k);
        if (c > 0) {
            r.right = insert(r.right, k, v);
        } else if (c < 0) {
            r.left = insert(r.left, k, v);
        } else {
            //swap value;
            r.v = v;
        }
        update(r);
        return balnce(r);
    }

    public void remove(K k) {
        if (!contains(k)) {
            throw new NullPointerException("khoa khong hop le vui long nhap lai khoa");
        }
        node r = this.root;
        root = remove(r, k);
        this.size--;
    }

    private node remove(node r, K k) {
        if (r == null) return null;
        int c = k.compareTo((K) r.k);
        if (c > 0) {
            r.right = remove(r.right, k);
        } else if (c < 0) {
            r.left = remove(r.left, k);
        } else {
            if (r.left == null) return r.right;
            else if (r.right == null) return r.left;
            else {
                boolean o = r.left.h - r.right.h > 0;
                if (o) {
                    node t = r;
                    r = findMax(t.left);
                    r.left = deMax(t.left);
                    r.right = t.right;
                } else {
                    node t = r;
                    r = findMin(r.right);
                    r.right = deMin(r.right);
                    r.left = t.left;
                }
            }
        }
        update(r);
        return balnce(r);
    }

    public boolean contains(K k) {
        node r = this.root;
        while (r != null) {
            int c = k.compareTo((K) r.k);
            if (c > 0) {
                r = r.right;
            } else if (c < 0) {
                r = r.left;
            } else {
                return true;
            }
        }
        return false;

    }

    public ArrayList keys() {
        Stack<node> t = new Stack<>();
        ArrayList<K> res = new ArrayList<>();
        node r = root;
        while (r != null || !t.isEmpty()) {
            if (r != null) {
                t.add(r);
                r = r.left;
            } else {
                r = t.pop();
                res.add((K) r.k);
                r = r.right;
            }
        }
        return res;
    }

    public V get(K k) {
        if (!contains(k)) {
            throw new NullPointerException("khoa khong ton tai nhap lai khoa");
        }
        node r = this.root;
        while (r != null) {
            int c = k.compareTo((K) r.k);
            if (c == 0) {
                return (V) r.v;
            } else if (c > 0) {
                r = r.right;
            } else {
                r = r.left;
            }
        }
        return null;
    }

    private node findMin(node n) {
        if (n == null) return null;
        if (n.left == null) return n;
        return findMin(n.left);
    }

    private node deMin(node n) {
        if (n == null) return null;
        if (n.left == null) return n.right;
        n.left = deMin(n.left);
        return n;

    }

    private node findMax(node n) {
        if (n == null) return null;
        if (n.right == null) return n;
        return findMax(n.right);
    }

    private node deMax(node n) {
        if (n == null) return null;
        if (n.right == null) return n.left;
        n.right = deMax(n.right);
        return n;
    }

    private void update(node n) {
        int hl = (n.left == null) ? -1 : n.left.h;
        int hr = (n.right == null) ? -1 : n.right.h;
        n.h = Math.max(hl, hr) + 1;
        n.bf = hr - hl;

    }

    private node balnce(node p) {
        //ll
        if (p.bf == -2) {
            //l-r
            if (p.left.bf >= 0) {
                return lr(p);
            }
            //l-l
            else {
                return ll(p);
            }
        }
        //r-r
        else if (p.bf == +2) {
            if (p.right.bf <= 0) {
                return rl(p);
            } else {
                return rr(p);
            }
        }
        return p;
    }

    private node rotateR(node p) {

        node r = p.left;
        p.left = r.right;
        r.right = p;
        update(p);
        update(r);

        return r;
    }

    private node rotateL(node p) {

        node r = p.right;
        p.right = r.left;
        r.left = p;
        update(p);
        update(r);


        return r;
    }

    private node ll(node p) {
        return rotateR(p);
    }

    private node lr(node p) {
        p.left = rotateL(p.left);
        return ll(p);
    }

    private node rr(node p) {
        return rotateL(p);
    }

    private node rl(node p) {
        p.right = rotateR(p.right);
        return rr(p);
    }

    public void print() {
        node r = this.root;
        hprint(r);
    }

    private void hprint(node r) {
        if (r == null) return;
        hprint(r.left);
        System.out.println(r.v);
        hprint(r.right);
    }

    public void addperson() {

        avlTree<String, peson> t = new avlTree<>();
        peson a = new peson("a", 1);
        peson b = new peson("b", 2);
        peson c = new peson("c", 3);
        peson d = new peson("d", 4);
        peson e = new peson("e", 5);
        peson f = new peson("f", 6);
        t.insert(a.getName(), a);
        t.insert(b.getName(), b);
        t.insert(c.getName(), c);
        t.insert(d.getName(), d);
        t.insert(e.getName(), e);
        t.insert(f.getName(), f);
        ArrayList<String> o = t.keys();
        ;

        for (String r : o) {
            System.out.println(t.get(r).toString());
        }
    }

    public static void main(String[] args) {
        //TreeSet
        //HashMap
        avlTree<Integer, Integer> t = new avlTree<>();
        t.insert(5, 5);
        t.insert(7, 7);
        t.insert(4, 77);
        t.insert(3, 3);
        t.insert(2, 2);
        t.insert(1, 1);
        System.out.println(t.size());
    }
}
