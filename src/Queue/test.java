package Queue;

import java.util.PriorityQueue;

public class test<E> {
    Object arr[];
    int f;
    int l;
    int size=0;
    public test(int n){
        arr=new Object[n];
    }
    public test(){
        this(1);
        f=l=-1;
    }
    void grow(){
        Object []narr=new Object[arr.length*2];
        System.arraycopy(arr,0,narr,0,arr.length);
        arr=narr;
    }
    void push(E data){
        if(size==arr.length){
            grow();
        }
        arr[++l]=data;
        size++;
    }
    E pop(){
        if(size==0){
            throw new ArrayIndexOutOfBoundsException("mang rong");
        }
        E res;
        res= (E) arr[++f];
        arr[f]=null;
        if(f==l){
            f=l=-1;
        }
        this.size--;
        return res;
    }
    boolean isEmpty(){
        return this.size==0;
    }
    int size(){
        return size;
    }
    void print(){

        for (int i = f+1; i<size+f+1; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
     test<String>t=new test<>();
        PriorityQueue c=new PriorityQueue<>();

        t.push("nguyen");
        t.push("van");
        t.push("aa");
        t.push("tt");

//     while (!t.isEmpty()){
//         System.out.println(t.pop());
//     }

        t.print();
    }
}
