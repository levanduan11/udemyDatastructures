package Linlist;
//lien ket vong doi
public class ex4 {
    node head;
    node tail;
    int size;

    public ex4() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    static class  node{
        node next;
        node pre;
        int data;

        public node(int data) {
            this.next = null;
            this.pre = null;
            this.data = data;
        }
    }
    void addFist(int data){
        node n=new node(data);
        if(this.head==null){
            this.head=this.tail=null;
        }
        else {
            n.next=this.head;
            head.pre=n;
            tail.next=n;
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
            n.next=head;
            tail=n;

        }
        this.size++;
    }
    int removeLast(){
        node de;
        node n;
        if(tail==null){
            throw new NullPointerException("danh sach rong");
        }
        if(size==1){
            de=tail;
            tail=head=null;
        }else {
            de=tail;
            n=tail.pre;
            n.next=head;
            tail=n;

        }
        this.size--;
        return de.data;
    }
    void print(){
        node n=this.head;
        for (int i = 0; i < this.size; i++) {
            System.out.println(n.data);
            n=n.next;
        }
    }

    public static void main(String[] args) {
        ex4 n=new ex4();
        n.addLast(1);
        n.addLast(2);
        n.addLast(3);
        n.addLast(4);

        n.removeLast();
        n.removeLast();
        n.removeLast();
        n.removeLast();
        n.print();
    }
}
