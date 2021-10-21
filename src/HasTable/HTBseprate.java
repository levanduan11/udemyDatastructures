package HasTable;

import java.security.Key;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Objects;

public class HTBseprate<K, V> {
    node<?, ?>[] ele;
    int size;
    int thresold;//loadfactor*length
    float loadfactor;//size/length
    private static final int MAX_CAPA = Integer.MAX_VALUE - 8;
    private static final int CAPA = 17;

    public HTBseprate(int n, float loadfactor) {
        if (n < 0) {
            throw new NegativeArraySizeException("gia tri khong duoc am");
        }
        if (loadfactor < 0 || Float.isNaN(loadfactor)) {
            throw new IllegalArgumentException("doi so dau vao khong hop le");
        }
        ele = new node[n];
        this.loadfactor = loadfactor;
        thresold = (int) Math.min(this.loadfactor * n, MAX_CAPA + 1);
    }

    public HTBseprate() {
        this(CAPA, 0.75F);
    }

    private int hash(Object key) {
        int h = key.hashCode();
        return (h & Integer.MAX_VALUE) % ele.length;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public void clear() {
        node<?, ?>[] e = ele;
        for (int i = e.length; i-- > 0; ) {
            e[i] = null;
        }
        this.size = 0;
    }

    public V get(K k) {
//        node<?,?>[]e=ele;
//        int hash=k.hashCode();
//        int index=(hash&Integer.MAX_VALUE)%e.length;
//        for(node<K,V> n = (node<K, V>) e[index];n!=null;n=n.next){
//            if(k.equals(n.getKey())&&n.hash==hash){
//                return n.value;
//            }
//        }
//        return null;
        node<K, V> res = search(k);
        return res == null ? null : res.value;
    }
    public V getOrderdefault(K k,V defaultvalue){
        node<K,V>n=search(k);
        return n==null?defaultvalue:n.value;
    }

    public ArrayList<K> keys() {
        ArrayList<K> res = new ArrayList<>();
        node<?, ?> e[] = ele;
        int n = ele.length;
        for (int i = n; i-- > 0; ) {
            for (node<K, V> o = (node<K, V>) e[i]; o != null; o = o.next) {
                if (o.key != null) {
                    res.add(o.key);
                }
            }
        }
        return res;
    }
    public ArrayList<V>values(){
        ArrayList<V>res = new ArrayList<>();
        node<?,?>n[]=ele;
        for(int i=ele.length;i-->0;){
            for(node<K,V> s = (node<K, V>) n[i]; s!=null; s=s.next){
                if(s.value!=null){
                    res.add(s.value);
                }
            }
        }
        return res;
    }

    public node<K, V> search(K k) {
        node<?, ?> e[] = ele;
        int hash = k.hashCode();
        int index = (hash & Integer.MAX_VALUE) % ele.length;
        for (node<K, V> n = (node<K, V>) e[index]; n != null; n = n.next) {
            if (k.equals(n.getKey()) && n.hash == hash) {
                return n;
            }
        }
        return null;
    }

    public boolean containsKey(K k) {
        node<K, V> res = search(k);
        return res != null;

    }
    public boolean containsValues(V v){
        node<?,?>[]e=ele;
        for(int i=ele.length;i-->0;){
            for (node<K,V> n = (node<K, V>) e[i];n!=null;n=n.next){
                    if(v.equals(n.getValue())){
                        return true;
                    }
            }
        }
        return false;
    }

    public boolean replace(K k, V old, V newval) {
        node<?, ?> e[] = ele;
        int hash = k.hashCode();
        int index = (hash & Integer.MAX_VALUE) % ele.length;
        node<K, V> n = (node<K, V>) e[index];
        for (; n != null; n = n.next) {
            if (k.equals(n.getKey()) && n.hash == hash) {
                if (n.value.equals(old)) {
                    n.value = newval;
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public V remove(K k) {
        node<?, ?>[] e = ele;
        int hash = k.hashCode();
        int index = (hash & Integer.MAX_VALUE) % ele.length;
        node<K, V> n = (node<K, V>) e[index];
        node<K, V> pre = null;
        for (; n != null; pre = n, n = n.next) {
            if (k.equals(n.getKey()) && n.hash == hash) {
                if (pre != null) {
                    pre.next = n.next;
                } else {
                    //truong hop chi co 1 phan tu
                    e[index] = pre;
                }
                V old = n.value;
                n.value = null;
                this.size--;
                return old;
            }
        }
        return null;
    }

    private void grow() {
        node<?, ?> old[] = ele;
        int oldlength = ele.length;
        int newlength = ele.length * 2 + 1;
        node<?, ?> res[] = new node[newlength];
        thresold = (int) (newlength * loadfactor);
        ele = res;
        for (int i = oldlength; i-- > 0; ) {
            for (node<K, V> o = (node<K, V>) old[i]; o != null; ) {
                node<K, V> e = o;
                o = o.next;
                int index = (e.hash & Integer.MAX_VALUE) % newlength;
                e.next = (node<K, V>) res[index];
                res[index] = e;
            }
        }


    }

    private void addNode(K k, V v, int index, int hash) {
        node<?, ?>[] t = ele;
        if (size > thresold) {
            grow();
            t = ele;
            hash = k.hashCode();
            index = (hash & Integer.MAX_VALUE) % ele.length;
        }
        node<K, V> e = (node<K, V>) t[index];
        t[index] = new node<>(hash, k, v, e);
        this.size++;
    }

    public V insert(K k, V v) {
        if (v == null) {
            throw new NullPointerException("gia tri null");
        }
        node<?, ?>[] e = ele;
        int hash = k.hashCode();
        int index = (hash & Integer.MAX_VALUE) % e.length;
        node<K, V> t = (node<K, V>) e[index];
        //tim thu xem co gia tri cay trung nhau khong
        for (; t != null; t = t.next) {
            if (t.key.equals(k) && t.hash == hash) {
                V oldvalue = t.value;
                t.value = v;
                return oldvalue;
            }
        }
        addNode(k, v, index, hash);
        return null;
    }

    private static class node<K, V> {
        int hash;
        K key;
        V value;
        node<K, V> next;

        public node(int hash, K key, V value, node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null) {
                throw new NullPointerException("gia tri null");
            }
            V oldvalue = this.value;
            this.value = value;
            return oldvalue;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null || getClass() != o.getClass()) return false;
            node<?, ?> n = (node<?, ?>) o;
            return key == null ? n.getKey() == null : key.equals(n.getKey()) &&
                    value == null ? n.getValue() == null : value.equals(n.getValue());

        }

        @Override
        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        @Override
        public String toString() {
            return key.toString() + "->" + value.toString();
        }
    }

    public static void main(String[] args) {
        HTBseprate<Integer, Integer> t = new HTBseprate<>();
        t.insert(5, 1);
        t.insert(15, 2);
        t.insert(25, 3);
        t.insert(35, 4);
        t.insert(45, 5);
        t.insert(55, 6);
        t.insert(7, 7);
        t.insert(17, 8);
        t.insert(27, 9);
        t.insert(37, 10);
        System.out.println(t.containsValues(45));
        System.out.println(t.getOrderdefault(15,-1));

    }
}
