package HasTable;

public class HSBlinnear<K, V> {
    K[] keys;
    V[] values;
    int size;
    int m;
    float loadfactor;
    int thresold;

    public HSBlinnear(int n) {
        keys = (K[]) new Object[n];
        values = (V[]) new Object[n];
        this.loadfactor = 0.75f;
        this.thresold = (int) (keys.length * loadfactor);
        m = n;
    }

    public HSBlinnear() {
        this(5);
    }

    public int hash(K k) {
        int h = k.hashCode();
        return (h & Integer.MAX_VALUE) % m;
    }

    public void grow() {
        HSBlinnear<K, V> f = new HSBlinnear<>(m * 2 + 1);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                f.put(keys[i], values[i]);
            }
        }
        this.keys = f.keys;
        this.values = f.values;
        this.m = f.m;
        this.thresold = (int) (loadfactor * m);
    }

    public void remove(K k) {
        int i = hash(k);
        while (!k.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {
            K old = keys[i];
            V ol = values[i];
            keys[i] = null;
            values[i] = null;
            put(old, ol);
            i = (i + 1) % m;
        }
        this.size--;
    }

    public void put(K k, V v) {
        if (k == null || v == null) {
            System.out.println("doi so khong hop le");
            return;
        }
        if (this.size > thresold) {
            grow();
        }
        int i;
        for (i = hash(k); keys[i] != null; i = (i + 1) % m) {
            if (k.equals(keys[i])) {
                values[i] = v;
                return;
            }
        }
        keys[i] = k;
        values[i] = v;
        this.size++;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        HSBlinnear<Integer, Integer> i = new HSBlinnear<>();
        i.put(1, 2);
        i.put(2, 2);
        i.put(9, 2);
        i.put(4, 2);
        i.put(5, 2);

        i.remove(5);
        System.out.println(i.size());
    }
}
