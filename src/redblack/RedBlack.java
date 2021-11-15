package redblack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.TreeMap;

public class RedBlack<K extends Comparable<K>, V> {
    node<K, V> root;
    int size;


    public RedBlack() {
        this.size = 0;

    }

    private final static boolean BLACK = true;
    private final static boolean RED = false;

    static class node<K, V> {
        node left;
        node right;
        node parent;
        boolean color = BLACK;
        K k;
        V v;

        public K getK() {
            return k;
        }

        public V getV() {
            return v;
        }

        public void setV(V v) {
            this.v = v;
        }

        public node(node parent, K k, V v) {
            this.parent = parent;
            this.k = k;
            this.v = v;
        }
    }

    public int size() {
        return this.size;
    }

    public void clear() {
        this.size = 0;
        this.root = null;
    }

    private static <K, V> boolean color(node<K, V> n) {
        return n == null ? BLACK : n.color;
    }

    private static <K, V> node<K, V> parent(node<K, V> n) {
        return n == null ? null : n.parent;
    }

    private static <K, V> node<K, V> leftOf(node<K, V> n) {
        return n == null ? null : n.left;
    }

    private static <K, V> node<K, V> rigthOf(node<K, V> n) {
        return n == null ? null : n.right;
    }

    private static <K, V> void setcolor(node<K, V> n, boolean c) {
        if (n != null) {
            n.color = c;
        }
    }

    private void rotateLeft(node<K, V> n) {
        if (n != null) {
            node<K, V> s = n.right;
            n.right = s.left;
            if (s.left != null) {
                s.left.parent = n;
            }
            s.parent = n.parent;
            if (n.parent == null) {
                this.root = s;
            }
            if (n.parent.left == n) {
                n.parent.left = s;
            } else {
                n.parent.right = s;
            }
            s.left = n;
            n.parent = s;
        }

    }

    private void rotateRight(node<K, V> n) {
        if (n != null) {
            node<K, V> s = n.left;
            n.left = s.right;
            if (s.right != null) {
                s.right.parent = n;
            }
            s.parent = n.parent;
            if (n.parent == null) {
                this.root = s;
            }
            if (n.parent.left == n) {
                n.parent.left = s;
            } else {
                n.parent.right = s;
            }
            s.right = n;
            n.parent = s;
        }
    }

    public void insert(K k, V v) {
        node<K, V> root = this.root;
        if (root == null) {

            this.root = new node<>(null, k, v);
            this.size++;
            return;
        }
        node<K, V> tmp = null;

        while (root != null) {
            tmp = root;
            int c = k.compareTo(root.k);
            if (c > 0) {
                root = root.right;
            } else if (c < 0) {
                root = root.left;
            } else {
                root.setV(v);
            }
        }
        int s = k.compareTo(tmp.k);
        node<K, V> n = new node<>(tmp, k, v);
        if (s > 0) {
            tmp.right = n;
        } else {
            tmp.left = n;
        }
        fixisert(n);
        this.size++;
    }

    private void fixisert(node<K, V> n) {
        n.color = RED;
        while (n != null && n != root && n.parent.color == RED) {
            if (n.parent == leftOf(parent(parent(n)))) {
                node<K, V> s = rigthOf(parent(parent(n)));
                if (s.color == RED) {
                    setcolor(parent(n), BLACK);
                    setcolor(s, BLACK);
                    setcolor(parent(parent(n)), RED);
                    n = parent(parent(n));
                } else {
                    //l-r
                    if (n == rigthOf(parent(n))) {
                        n = parent(n);
                        rotateLeft(n);
                    }
                    setcolor(parent(n), BLACK);
                    setcolor(parent(parent(n)), RED);
                    rotateRight(parent(parent(n)));
                }
            } else {
                node<K, V> s = leftOf(parent(parent(n)));
                if (s.color == RED) {
                    setcolor(parent(n), BLACK);
                    setcolor(s, BLACK);
                    setcolor(parent(parent(n)), RED);
                    n = parent(parent(n));
                } else {
                    if (n == leftOf(parent(n))) {
                        n = parent(n);
                        rotateRight(n);
                    }
                    setcolor(parent(n), BLACK);
                    setcolor(parent(parent(n)), RED);
                    rotateLeft(parent(parent(n)));
                }
            }
        }
        setcolor(n, BLACK);
    }

    //node min ben phai thay the
    private node<K, V> success(node<K, V> x) {
        if (x == null) return null;
        else if (x.right != null) {
            node<K, V> t = x.right;
            while (t.left != null) {
                t = t.left;
            }
            return t;
        } else {
            node<K, V> p = x.parent;
            node<K, V> k = x;
            while (p != null && (x.right == p)) {
                x = p;
                p = p.parent;
            }
            return p;
        }
    }

    public V getv(K k) {
        node<K, V> p = get(k);
        return (p == null) ? null : p.v;
    }

    public ArrayList<K> keys() {
        node<K, V> r = root;
        Stack<node<K, V>> res = new Stack<>();
        ArrayList<K> re = new ArrayList<>();
        while (!res.isEmpty() || r != null) {
            if (r != null) {
                res.add(r);
                r = r.left;
            } else {
                r = res.pop();
                re.add(r.k);
                r = r.right;
            }
        }
        return re;
    }

    final node<K, V> get(K k) {
        if (k == null) throw new NullPointerException();
        node<K, V> r = root;
        while (root != null) {
            int c = k.compareTo(r.k);
            if (c > 0) {
                r = r.right;
            } else if (c < 0) {
                r = r.left;
            } else {
                return r;
            }
        }
        return null;
    }

    public V remove(K k) {
        if (k == null) {
            return null;
        }
        node<K, V> p = get(k);
        V ovalue = get(k).v;
        delele(p);
        return ovalue;
    }

    private void delele(node<K, V> n) {
        this.size--;
        if (n.left != null && n.right != null) {
            node<K, V> s = success(n);
            n.k = s.k;
            n.v = s.v;
            n = s;
            //co hai con
        }
        node<K, V> replace = n.left == null ? n.left : n.right;
        if (replace != null) {
            replace.parent = n.parent;
            if (n.parent == null) {
                this.root = replace;
            } else if (n.parent.left == n) {
                n.parent.left = replace;
            } else {
                n.parent.right = n;
            }

            n.left = n.right = n.parent = null;
            if (replace.color == BLACK) {
                fixDelete(replace);
            }

        } else if (n.parent == null) {
            this.root = null;

        } else {
            //khong co con nao
            if (n.color == BLACK) {
                fixDelete(n);
            }
            if (n.parent != null) {
                if (n.parent.left == n) {
                    n.parent.left = null;
                } else if (n.parent.right == n) {
                    n.parent.right = null;
                }
                n.parent = null;
            }


        }
    }

    private void fixDelete(node<K, V> n) {
        while (n != root && color(n) == BLACK) {
            if (n == leftOf(parent(n))) {
                node<K, V> s = rigthOf(parent(n));
                //s=red
                if (color(s) == RED) {
                    setcolor(parent(n), RED);
                    setcolor(s, BLACK);
                    rotateLeft(parent(n));
                    s = rigthOf(parent(n));
                }
                if (color(leftOf(s)) == BLACK && color(rigthOf(s)) == BLACK) {
                    setcolor(s, RED);
                    n = parent(n);
                } else {
                    //con ben trai do r-l
                    if (rigthOf(s).color == BLACK) {
                        setcolor(leftOf(s), BLACK);
                        setcolor(s, RED);
                        rotateRight(s);
                        s = rigthOf(parent(n));
                    }
                    //hai con s deu do r-r
                    setcolor(rigthOf(s), BLACK);
                    setcolor(s, color(parent(n)));
                    setcolor(parent(n), BLACK);
                    rotateLeft(parent(n));
                    n = root;

                }
            } else {
                node<K, V> s = leftOf(parent(n));
                if (color(s) == RED) {
                    setcolor(parent(n), RED);
                    setcolor(s, BLACK);
                    rotateRight(parent(n));
                    s = leftOf(parent(n));
                }
                if (color(leftOf(s)) == BLACK && color(rigthOf(s)) == BLACK) {
                    setcolor(s, RED);
                    n = parent(n);
                } else {
                    //l-r
                    if (color(leftOf(s)) == BLACK) {
                        setcolor(rigthOf(s), BLACK);
                        setcolor(s, RED);
                        rotateLeft(s);
                        s = leftOf(parent(n));
                    }
                    //ll
                    setcolor(leftOf(s), BLACK);
                    setcolor(s, color(parent(n)));
                    setcolor(parent(n), BLACK);
                    rigthOf(parent(n));
                    n = root;
                }
            }

        }
        setcolor(n, BLACK);
    }

    public K floor(K k) {
        node<K, V> r = root;
        return (r == null) ? null : getfloor(r, k).k;
    }

    private node<K, V> getfloor(node<K, V> r, K k) {
        if (r == null) return null;
        int c = k.compareTo(r.k);
        if (c < 0) {
            return getfloor(r.left, k);
        }
        node<K, V> a = getfloor(r.right, k);
        if (a != null) {
            return a;
        } else {
            return r;
        }

    }

    public K ceiling(K k) {
        node<K, V> r = root;
        return r == null ? null : getceiling(r, k).k;
    }

    private node<K, V> getceiling(node<K, V> r, K k) {
        if (r == null) return null;
        int c = k.compareTo(r.k);
        if (c < 0) {
            node<K, V> p = getceiling(r.left, k);
            if (p != null) {
                return p;
            } else {
                return r;
            }


        }
        return getceiling(r.right, k);

    }

    void print() {
        node r = root;
        print(r);
    }

    void print(node n) {
        if (n == null) return;

        print(n.left);
        System.out.println(n.v);
        print(n.right);
    }

    public static void main(String[] args) {
        RedBlack<Integer, Integer> i = new RedBlack<>();
        i.insert(7, 1);
        i.insert(3, 2);
        i.insert(9, 3);
        i.insert(5, 4);
        i.insert(4, 6);
        i.insert(8, 7);
        i.insert(11, 8);
        i.insert(12, 9);
        System.out.println(i.ceiling(10));


    }
}
