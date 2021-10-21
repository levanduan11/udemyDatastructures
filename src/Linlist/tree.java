package Linlist;

public class tree {
    node root;
    int size=0;

    public tree() {
        this.root=null;
    }

    static class node{
        node l;
        node r;
        int data;

        public node(int data) {
            this.l=null;
            this.r=null;
            this.data=data;
        }
    }
    node add(int data){
        node n=this.root;
        this.size++;
        root=add(data,n);

        return root;
    }
    node add(int data,node r){

        if(r==null){
            r=new node(data);

        }
      else if(r.data>data){
            r.l=add(data,r.l);
        }else {
            r.r=add(data,r.r);
        }

      return r;
    }
    void print(node r){
        if(r==null)return;
        System.out.println(r.data);
        print(r.l);
        print(r.r);
    }
void pr(){
        node n=this.root;
        print(n);
}
    public static void main(String[] args) {
        tree t=new tree();
      t.add(5);
      t.add(3);
        t.add(8);
        t.add(2);
        t.add(1);
        t.add(4);
        t.add(7);
        t.add(9);
        t.add(6);
        t.add(10);
        t.pr();
    }
}
