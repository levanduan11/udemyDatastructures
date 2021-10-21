package Queue;

public class quelist {
node head;
node last;
    int size;
    static class node{
        node next;
        int data;

        public node(int data) {
            this.next = null;
            this.data = data;
        }
    }
    void add(int data){
node n=new node(data);
if(last==null){
    last=head=n;
}else {
    last.next=n;
    last=n;
}
this.size++;
    }
    int remove(){
        int res;
        if (head==null){
            throw new ArrayIndexOutOfBoundsException("danh sach rong");
        }
        if(head.next==null){
            res=head.data;
            head=last=null;
        }else {
            node r=head;
            head=head.next;
            res=r.data;
        }
        this.size--;
        return res;
    }
    void print(){
        node n=head;
        while (head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }
    boolean isEmpty(){
        return size==0;
    }

    public static void main(String[] args) {
        quelist g=new quelist();
        g.add(1);
        g.add(2);
        g.add(3);
        g.add(4);
        g.remove();
        g.remove();
        g.remove();
        g.remove();
        g.print();
    }
}
