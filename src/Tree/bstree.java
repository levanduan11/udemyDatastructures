package Tree;

import java.util.*;

public class bstree<K extends Comparable<K>, V> {
    node<K, V> root;
    int size;

    public bstree() {
        this.size = 0;
    }

    static class node<K, V> {
        node left;
        node right;

        K k;
        V v;

        public node(K k, V v) {
            this.k = k;
            this.v = v;

        }
    }

    public int size() {
        return this.size;
    }

    boolean isEmpty() {
        return this.size() == 0;
    }

    public void insert1(K k, V v) {
        size++;
        this.root = insert1(root, k, v);
    }

    private node insert1(node x, K key, V val) {
        if (x == null) return new node(key, val);
        int i = key.compareTo((K) x.k);
        if (i > 0) {
            x.right = insert1(x.right, key, val);
        } else if (i < 0) {
            x.left = insert1(x.left, key, val);
        } else {
            //truong hop trung key thay the value
            x.v = val;

        }
        return x;
    }

    public node search(K k) {
        node r = root;
        if (r == null) throw new NullPointerException("gia tri rong");
        while (r != null) {
            int c = k.compareTo((K) r.k);
            if (c == 0) {
                return r;
            } else if (c > 0) {
                r = r.right;
            } else {
                r = r.left;
            }
        }
        return null;
    }

    public V get1(K k) {
        node s = search(k);
        if (s == null) {
            throw new NullPointerException("gia tri key khong hop le");
        }
        return (V) s.v;
    }

    public void insert(K k, V v) {
        node n = new node(k, v);
        if (this.root == null) {
            root = n;
            this.size++;
            return;
        }
        node p = null;
        node r = root;
        while (r != null) {
            p = r;
            int c = k.compareTo((K) r.k);
            if (c > 0) {
                r = r.right;
            } else if (c < 0) {
                r = r.left;
            } else {
                r.v = v;
                return;
            }
        }
        int c = k.compareTo((K) p.k);
        if (c > 0) {
            p.right = n;
        } else {
            p.left = n;
        }
        this.size++;
    }

    public node remvove(K key) {
        root = remove(key, root);
        this.size--;
        return root;
    }

    private node remove(K key, node r) {
        int d = key.compareTo((K) r.k);
        if (d > 0) {
            r.right = remove(key, r.right);
        } else if (d < 0) {
            r.left = remove(key, r.left);
        } else {
            if (r.left == null) return r.right;
            if (r.right == null) return r.left;
            node tmp = r;
            boolean check = heigh(tmp.right) > heigh(tmp.left);
            if (check) {
                r = findMin(tmp.right);
                r.right = deRightmin(tmp.right);
                r.left = tmp.left;
            } else {
                r = findMax(tmp.left);
                r.left = deLeftmax(tmp.left);
                r.right = tmp.right;
            }


        }
        return r;
    }

    private node deRightmin(node r) {
        if (r.left == null)
            return r.right;
        r.left = deRightmin(r.left);
        return r;
    }

    private node deLeftmax(node r) {
        if (r.right == null) return r.left;
        r.right = deLeftmax(r.right);
        return r;

    }

    private node findMin(node r) {
        if (r.left == null) return r;
        return findMin(r.left);
    }

    private node findMax(node r) {
        if (r.right == null) return r;
        return findMax(r.right);
    }

    public void print() {
        print(root);
    }

    private void print(node r) {
        if (r == null) return;
        print(r.left);
        System.out.println(r.v);
        print(r.right);
    }

    public int heigh() {
        return heigh(root);
    }

    private int heigh(node r) {
        if (r == null) return -1;
        return Math.max(heigh(r.right), heigh(r.left)) + 1;
    }

    public int coutNode() {
        return coutNode(root);
    }

    private int coutNode(node r) {
        if (r == null) return 0;
        return coutNode(r.left) + coutNode(r.right) + 1;
    }

    public boolean contaikey(K key) {
        return contaniskey(root, key);
    }

    public ArrayList level() {
        if (root == null) {
            throw new NullPointerException("cay rong");
        }
        node v = root;
        Queue<node> q = new LinkedList<>();
        q.add(v);
        ArrayList<ArrayList<V>> t = new ArrayList<>();
        ArrayList<V> oo = new ArrayList<>();
        oo.add((V) root);
        t.add(oo);
        while (!q.isEmpty()) {
            ArrayList<V> o = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                node s = q.poll();
                o.add((V) s.v);
                if (s.left != null) {
                    q.add(s.left);
                }
                if (s.right != null) {
                    q.add(s.right);
                }
            }
            t.add(o);
        }
        return t;
    }

    private boolean contaniskey(node r, K key) {

        if (r == null) return false;
        int k = key.compareTo((K) r.k);
        if (k > 0) {
            return contaniskey(r.right, key);
        } else if (k < 0) {
            return contaniskey(r.left, key);
        } else {
            return true;
        }
    }

    public V get(K k) {
        node res = get(k, root);
        if (res == null) {
            throw new ArrayIndexOutOfBoundsException("gia tri khong hop le");
        }
        return (V) res.v;
    }

    public node get(K k, node r) {
        if (r == null) return null;
        int f = k.compareTo((K) r.k);
        if (f > 0) {
            return get(k, r.right);
        } else if (f < 0) {
            return get(k, r.left);
        } else {
            return r;
        }
    }

    public K floor(K k) {
        node res = floor(root, k);
        return (K) res.k;
    }

    private node floor(node r, K k) {
        if (r == null) return null;
        int t = k.compareTo((K) r.k);
        if (t < 0) {
            return floor(r.left, k);
        }
        node a = floor(r.right, k);
        if (a != null) return a;
        else {
            return r;
        }
    }
public K ceiling(K k){
        node r=root;
        return (K) ceiling(r,k).k;
}
    private node ceiling(node r, K k) {
        if (r == null) return null;
        int h = k.compareTo((K) r.k);
        if (h < 0) {
            node t = ceiling(r.left, k);
            if (t != null) {
                return t;
            } else {
                return r;
            }
        }
        node s=ceiling(r.right,k);
        return s;
    }

    public void postorder() {
        Stack<node> s = new Stack<>();
        Stack<node> s2 = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            node t = s.pop();
            s2.push(t);
            if (t.left != null) {
                s.add(t.left);
            }
            if (t.right != null) {
                s.add(t.right);
            }
        }
        while (!s2.isEmpty()) {
            node t = s2.pop();
            System.out.println(t.v);
        }

    }

    private int coutleaf(node r) {
        if (r == null) return 0;
        if (r.right != null && r.left != null) {
            return coutleaf(r.right) + coutleaf(r.left) + 1;
        } else {
            return coutleaf(r.left) + coutleaf(r.right);
        }
    }

    public int coutleaf() {
        node k = root;
        return coutleaf(k);
    }

    public void preorder() {
        Stack<node> s = new Stack<>();
        node r = this.root;

        while (r != null || !s.isEmpty()) {
            if (r != null) {
//                System.out.println(r.v);
//                s.add(r);
//                r = r.left;
                //-----------
                s.add(r);
                r = r.left;


            } else {
//                r = s.pop();
//                r=r.right;
                //------------
                r = s.pop();
                System.out.println(r.v);
                r = r.right;


            }
        }
    }

    public void leveorder() {
        Queue<node> t = new LinkedList<>();
        node r = root;
        t.add(r);
        while (!t.isEmpty()) {
            node da = t.poll();
            System.out.println(da.v);
            if (da.left != null) {
                t.add(da.left);
            }
            if (da.right != null) {
                t.add(da.right);
            }
        }
    }

    public Queue<K> keyss() {
        //in order
        node r = root;
        Stack<node> s = new Stack<>();
        Queue<K> q = new LinkedList<>();
        while (!s.isEmpty() || r != null) {
            if (r != null) {
                s.add(r);
                r = r.left;

            } else {
                r = s.pop();
                q.add((K) r.k);
                r = r.right;
            }
        }
        return q;
    }

    public ArrayList<K> keys() {
        //in order
        node r = root;
        Stack<node> s = new Stack<>();
        ArrayList<K> q = new ArrayList<>();
        while (!s.isEmpty() || r != null) {
            if (r != null) {
                s.add(r);
                r = r.left;

            } else {
                r = s.pop();
                q.add((K) r.k);
                r = r.right;
            }
        }
        return q;
    }
int diff(K k){
        node z=search(k);

        return heigh(z.left)-heigh(z.right);

}

    public static void main(String[] args) {
        bstree<Integer, Integer> b = new bstree<>();
        b.insert(8, 8);
      b.insert(4,4);
      b.insert(12,12);
      b.insert(5,5);
      b.insert(3,3);
      b.insert(6,6);
      b.insert(1,1);
      b.insert(9,9);

      b.insert(13,13);
        System.out.println(b.ceiling(10));



    }
}
