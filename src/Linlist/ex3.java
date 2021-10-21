package Linlist;

import java.util.LinkedList;

//lien ket doi
public class ex3 {
    node head;
    node tail;
    int size;

    public ex3() {
        this.size=0;
        this.head=null;
        this.tail=null;
    }

    static class  node{
         node next;
         node pre;
         int data;

        public node( int data) {

            this.next = null;
            this.pre = null;
            this.data = data;
        }
    }
    void addfist(int data){
        node n=new node(data);
        if(head==null){
            head=tail=n;
        }else {
            n.next=head;
            head.pre=n;
            head=n;
        }
        this.size++;
    }
    void addLast(int data){
        node n=new node(data);
        if(tail==null){
            tail=head=n;
        }else {
            tail.next=n;
            n.pre=tail;
            tail=n;
        }
        this.size++;
    }
    void addAt(int index,int data){
        node n=new node(data);
        node k=this.head;
        if(index<0||index>this.size){
            throw new NullPointerException("vi tri them khong hop le");
        }else if(index==0){
            addfist(data);
        }else if(index==this.size){
            addLast(data);
        }else {
            for (int i = 0; i < index-1; i++) {
                k=k.next;
            }
            n.next=k.next;
            k.next.pre=n;
            k.next=n;
            n.pre=k;
            this.size++;
        }

    }
    int removeFist(){
        node n=this.head;
        if(head==null){
            throw new NullPointerException("danh sach rong");
        }
        if(head.next==null){
            head=tail=null;
        }else {
          head=n.next;
          head.pre=null;
        }
        this.size--;
        return n.data;
    }
    int removeLast(){
        node n=this.tail;
        if(tail==null){
            head=null;
            throw new NullPointerException("danh sach rong");
        }else if(head.next==null){
            head=tail=null;
        }else {
            node k=this.tail.pre;
            k.next=null;
            this.tail=k;
        }
        this.size--;
        return n.data;
    }
    int removeAt(int index){
        int res;
        node n=this.head;
        node k=null;
        if(index<0||index>=this.size){
            throw new NullPointerException("vi tri xoa khong hop le");
        }if(index==0){
            res=removeFist();

        }else if(index==this.size-1){
            res=removeLast();
        }else {
            for (int i = 0; i < index; i++) {
                k=n;
                n=n.next;
            }
            res=n.data;
           k.next=n.next;
            n.next.pre=k;
            n.next=null;
            this.size--;
        }
        return res;
    }
    int removeAt2(int index){
        node d=this.head;
        int res;
        if(index<0||index>=size){
            throw new NullPointerException("vi tri xoa khong ho le");
        }if(index==0){
            res=removeFist();
        }else if(index==size-1){
            res=removeLast();
        }else {
            for (int i = 0; i < index; i++) {
                d=d.next;
            }
            res=d.data;
            d.pre.next=d.next;
            d.next.pre=d.pre;
            d.next=null;
            d.pre=null;
            d=null;
            this.size--;

        }
        return res;
    }
    int dataPre(int index){
        node n=this.tail;
        int res;
        if(index<=0||index>=this.size){
            throw new NullPointerException("vi tri khong hop le");
        }else if(index==this.size-1){
            res=this.tail.pre.data;
        }else {
            for (int i=this.size-1;i>index;i--){
                n=n.pre;
            }
            res=n.pre.data;
        }
        return res;
    }

    int dataNext(int index){
        node n=this.head;
        int res;
        if(index<0||index>=this.size-1){
            throw new NullPointerException("vi tri khong hop le");
        }
        if(index==0){
            res=head.next.data;
        }else  if(index==this.size-2){
            res=tail.data;
        }else {
            for (int i = 0; i < index; i++) {
                n=n.next;
            }
            res=n.next.data;
        }
        return res;
    }
    int size(){
        return this.size;
    }
    boolean isEmpty(){
        return this.size==0;
    }
void print(){
        node n=this.head;
        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }
}
void reverse(node a,node b){
        if(b!=null){
            reverse(b,b.next);
          b.pre=b.next;
          b.next=a;
          this.tail=b;
        }else {
            this.head=a;
        }

}
void reverse(){
        node a=null;
        node b=this.head;
        reverse(a,b);
}
void reverse2(){
        node p=this.head;
        while (p!=null){
            node t=p.next;
            p.next=p.pre;
            p.pre=t;
            p=p.pre;

        }
        this.head=this.tail;
}
    public static void main(String[] args) {
        ex3 e=new ex3();
        e.addLast(1);
        e.addLast(2);
        e.addLast(3);
        e.addLast(4);
        e.addLast(5);
       e.reverse2();


  e.print();
    }
}
