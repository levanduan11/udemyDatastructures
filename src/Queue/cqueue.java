package Queue;

public class cqueue<E> {
    int l;
    int r;
    int size;
    Object arr[];
    public cqueue(int n) {
        arr = new Object[n];
    }
    public cqueue() {
        this(3);
        this.l = this.r = 0;
    }

    void grow() {
        Object narr[] = new Object[arr.length * 2];
        int d = (l + 1) % arr.length;
        int i = 1;
//        do{
//            narr[i++] = arr[d];
//            d = (d + 1) % arr.length;
//        }while (d != r);
        for (; d != (r+1)%arr.length; ) {
            narr[i++] = arr[d];
            d = (d + 1) % arr.length;

        }
     //   narr[i] = arr[r % arr.length];
        arr = narr;
        this.l = 0;
        this.r = size;
    }

    void add(E data) {
        if ((r + 1) % arr.length == l) {
            grow();
        }
        r = (r + 1) % arr.length;
        arr[r] = data;
        this.size++;

    }

    E remove() {
        E res;
        if (r == l) {
            throw new ArrayIndexOutOfBoundsException("mang rong");
        }
        l = (l + 1) % arr.length;
        res = (E) arr[l];
        arr[l] = 0;
        this.size--;
        return res;
    }

    int size() {
        return this.size;
    }


    boolean inE() {
        return size == 0;
    }

    public static void main(String[] args) {
        cqueue<String> c = new cqueue<>();
        c.add("tao");
        c.add("ten");
        c.add("la");
        c.add("le");
        c.add("van");
        c.add("duan");
//        while (!c.inE()) {
//            System.out.println(c.remove());
//        }

        System.out.println(c.inE());
        System.out.println(c.arr.length);
    }
}
