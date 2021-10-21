package myProject;

import java.util.ArrayList;
import java.util.Arrays;

public class myArraylist<E> {
    private static final int DEFAUT_CAPACITY = 7;
    private static final Object[] EMPTY_DEFAULT = {};
    private int size;
    private Object[] array;

    public myArraylist() {
        this.size = 0;
        this.array = new Object[DEFAUT_CAPACITY];
    }

    public myArraylist(int v) {
        if (v > 0) {
            this.array = new Object[v];
        } else if (v == 0) {
            this.array = EMPTY_DEFAULT;
        } else {
            throw new NegativeArraySizeException("gia tri khoi tao khong duoc nho hon khong");
        }

    }

    private Object[] growSize() {
        int n = this.array.length;
        Object[] newarray = new Object[2 * n];
        System.arraycopy(this.array, 0, newarray, 0, n);
        return array = newarray;

    }

    public void appen(E value) {
        if (size == this.array.length) {
            array = growSize();
        }
        this.array[size++] = value;
    }

    private boolean checkIndex(int index) {
        if (index >= 0 && index <= size) {
            return true;
        } else {
            throw new ArrayIndexOutOfBoundsException("vi tri chen khong duoc vuot qua kich thuoc mang");

        }

    }

    public boolean contais(E[] e) {
        return Arrays.binarySearch(array, e) != -1;
    }

    public void set(E value, int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException("vi tri sua khong hop le");
        }
        this.array[index] = value;
    }

    public void clear() {
        final Object[] r = array;
        for (int i = size, j = size = 0; j < i; j++) {
            r[j] = null;
        }
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new NullPointerException("vi tri xoa khong hop le");
        }
        E v = (E) array[index];
        for (int i = index; i < size; i++) {
            this.array[i] = this.array[i + 1];
        }
        size--;
        return v;
    }

    public E remove() {
        int n = size - 1;
        E t = (E) this.array[n];
        Object[] nar = new Object[this.array.length];
        for (int i = 0; i < n; i++) {
            nar[i] = this.array[i];
        }
        size--;
        this.array = nar;
        return t;
    }

    public boolean addAt(E value, int index) {
        if (checkIndex(index)) {
            addA(value, index);
            return true;
        }
        return false;
    }

    private void addA(E value, int index) {
        if (size == this.array.length) {
            this.array = growSize();
        }
        for (int i = size; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }
        array[index] = value;
        size++;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public E get(int index) {
        return (E) this.array[index];
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(this.array[i] + "  ");
        }
    }
//
//    public Object[] getArray() {
//        return this.array;
//    }

    public void printlengt() {
        for (Object s : this.array
        ) {
            System.out.println(s);
        }
    }


    public static void main(String[] args) {
        myArraylist<person> d = new myArraylist<>();
        person p = new person(2, "nguyen van a");
        person p1 = new person(3, "nguyen van b");
        person p2 = new person(4, "nguyen van c");
        person p3 = new person(5, "nguyen van d");
        d.appen(p);
        d.appen(p1);
        d.appen(p2);
        d.appen(p3);


    }
}
