package Queue;

import java.util.ArrayList;
import java.util.Objects;

public class queue<T> {
    int size;
    Object[] arr;


    public queue(int n) {
        arr = new Object[n];
    }

    public queue() {
        this(3);
    }

    void grow() {
        Object narr[] = new Object[arr.length * 2];
        System.arraycopy(arr, 0, narr, 0, arr.length);
        arr = narr;
    }

    void push(T data) {
        int n = arr.length;
        if (size == n) {
            grow();
        }
        arr[size++] = data;
    }

    T pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("danh sach rong");
        }
        T r = (T) arr[0];
        System.arraycopy(arr, 1, arr, 0,size);
        this.size--;
        return r;
    }
//T removeAt(int index){
//        if(size==0){
//            throw new ArrayIndexOutOfBoundsException("danh sach rong");
//
//        }
//        T res= (T) arr[index];
//        System.arraycopy(arr,index+1,arr,index,5);
//this.size--;
//        return res;
//}
    void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i]);
        }
    }
int size(){
        return this.size;
}
boolean isEmpty(){
        return this.size==0;
}
    public static void main(String[] args) {
        queue<String> f = new queue<>();
        f.push("1");
        f.push("2");
        f.push("3");
        f.push("4");
        f.push("5");
        f.print();

int arr[]={1,2,3,4,5,0,0,0};
int a=4;
System.arraycopy(arr,a+1,arr,a,5-a);

    }
}
