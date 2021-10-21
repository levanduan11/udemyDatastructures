package myProject;

import java.util.NoSuchElementException;

public class myLinlist <E>{
    private node<E> fist;
    private node<E> last;
    private int size=0;

    public myLinlist() {
        this.fist = null;
        this.last = null;

    }

    static class node<E>{
        node<E>next;
        node<E>prev;
        E data;
        public node(node<E> next, node<E> prev, E data) {
            this.next = next;
            this.prev = prev;
            this.data = data;
        }
    }
    private void linkFist(E data){
        node<E>f=fist;
      node<E>n=new node<>(f,null,data);
      fist=n;
      if(this.last==null){
          last=n;
      }else {
          f.prev=n;
      }
      this.size++;
    }
    private void linkLast(E data){
        node<E>l=last;
        node<E>n=new node<>(null,l,data);
        last=n;

        if(fist==null){
            fist=n;
        }else {
        l.next=n;
        }
        this.size++;
    }
  private void linkbefore(node<E>next,E data){
        node<E>pre=next.prev;
        node<E>n=new node<>(next,pre,data);
        next.prev=n;
        if(pre==null){
            this.fist=n;
           // this.last=next;
        }else {
            pre.next=n;
        }
        this.size++;
  }
  private E unlinkfist(node<E>f){
        E data=f.data;
        node<E>n=f.next;
        f.data=null;
        f.next=null;
      this.fist=n;
        if(n==null){
            this.last=null;
        }else {
            n.prev=null;
        }
        this.size--;
        return data;

  }
  private E unlinklast(node<E>l){
        E data=l.data;
        node<E>n=l.prev;
      l.prev=null;
      l.data=null;
        this.last=n;
        if(n==null){
            this.fist=null;
        }else {
            n.next=null;
        }
       this.size--;
        return data;

  }
  private E unlink(node<E>re){
        E data=re.data;
        node<E>n=re.next;
        node<E>p=re.prev;
      if(p==null){
          this.fist=n;
      }else {
          p.next=n;
          re.prev=null;
      }if(n==null){
          this.last=p;
      }else {
          n.prev=p;
          re.next=null;
      }
      re.data=null;
      this.size--;
      return data;

  }
  public E getFist(){
        node<E>f=this.fist;
        if(f==null){
            throw new NoSuchElementException("danh sach trong");
        }
        return f.data;
  }
  public E getLast(){
        node<E>l=this.last;
        if(l==null){
            throw new NoSuchElementException("danh sach trong");
        }
        return l.data;
  }
  public E removeFist(){
        node<E>f=fist;
        if(f==null){
            throw new NoSuchElementException("danh sach trong");
        }
        return unlinkfist(f);
  }
  public E removeLast(){
        node<E>l=last;
        if(l==null){
            throw new NoSuchElementException("danh sach trong");
        }
        return unlinklast(l);
  }
  public void addFist(E e){
        linkFist(e);
  }
  public void addLast(E e){
        linkLast(e);
  }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return this.size==0;
    }
    public void clear(){
       for(node<E>e=fist;e!=null;){
           node<E>k=e.next;
           e.data=null;
           e.next=null;
           e.prev=null;
           e=k;
       }
    }
    node<E>node(int index){
        node<E>f;
        if(index<(this.size>>1)){
            f=this.fist;
            for (int i = 0; i < index; i++) {
                f=f.next;
            }
            return f;
        }else {
            f=this.last;
            for (int i = this.size-1; i >index ; i--) {
                f=f.prev;
            }
            return f;
        }
    }
    public E get(int index){
        if(index<0||index>=size)throw new NullPointerException("vi tri khong hop le");
        return node(index).data;
    }
    public E set(int index,E data){
        if(index<0||index>=size)throw new NullPointerException("vi tri khong hop le");
        node<E>n=node(index);
        E old=n.data;
        n.data=data;
        return old;
    }
    public E removeAt(int index){
        return unlink(node(index));
    }
    public void addAt(int index,E data){
        linkbefore(node(index),data);
    }
    public void  print (){
        node<E>n=this.fist;
        while (n!=null){
            System.out.println(n.data);
            n=n.next;
        }
    }
    public static void main(String[] args) {
        myLinlist<Integer>m=new myLinlist<>();
        m.addLast(1);
        m.addLast(2);
        m.addLast(3);
        m.addLast(4);
        m.removeAt(0);
        m.print();
    }
}
