package Heap;

import java.util.PriorityQueue;

public class test {
    int arr[];
    int size=0;
    int point=0;
    test(int n){
        arr=new int[n];
    }
    public void swap(int i,int j,int arr[]){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    public boolean less(int a,int b){
        return a<b;
    }
    public void insert(int data){
        arr[point]=data;
      up(point);
      point++;
        this.size++;


    }
    public void pekk(){
        System.out.println(arr[0]);
    }
    public void up(int i){
        while (i>0&&less(arr[i],arr[i/2])){
            swap(i,i/2,arr);
            i/=2;

        }
    }


    public static void main(String[] args) {
test t=new test(20);
        t.insert(5);
        t.insert(7);
        t.insert(2);
        t.insert(-3);
        t.insert(-19);
        t.insert(-40);
        t.insert(-9);
        t.pekk();
    }
}
