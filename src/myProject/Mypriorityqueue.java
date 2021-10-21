package myProject;

import java.util.Comparator;
import java.util.Optional;

public class Mypriorityqueue <E>{
    public static final int CAPA=7;
    Object []ele;
    int size;
    Comparator<?super E>comparator;

    public Mypriorityqueue(int n, Comparator<? super E> comparator) {
        if(n<0){
            throw new NegativeArraySizeException("gia tri khong hop le");
        }
        ele=new Object[n];
        this.comparator = comparator;
    }

    public Mypriorityqueue(Comparator<? super E> comparator) {
      this(CAPA,comparator);
    }

    public Mypriorityqueue() {
       this(CAPA,null);
    }

    public Comparator<? super E> comparator() {
        return comparator;
    }
   public void grow(){
        Object narr[]=new Object[this.ele.length*2];
        System.arraycopy(ele,0,narr,0,this.size);
        this.ele=narr;
   }
   public void add(E e){
        if(e==null){
            throw  new NullPointerException("gia tri rong");
        }
     int n=this.size;
        if(n==ele.length){
            grow();
        }
        shiffup(n,e);
        size++;
   }
    public E remove(){
       E e;
       if((e=(E)this.ele[0])!=null){
           int n;
           E x=(E)ele[n=(--size)];
           ele[n]=null;
           if(n>0){
               if(comparator!=null){
                   shiffdowusingcompare(0,x,ele,comparator,n);
               }else {
                   shiffdowsingcomparable(0,x,ele,n);
               }
           }
       }
       return e;
    }
    private void shiffup(int k,E x){
        if(comparator!=null){
           shiffupusingcompare(k,x,this.ele,comparator);
        }else {
            shiffupsusingcomparble(k,x,this.ele);
        }
    }
    private static<T> void shiffupusingcompare(int k,T x,Object[]e,Comparator<?super T>c)
    {
        while (k>0){
            int p=(k-1)>>>1;
            Object v=e[p];
            if(c.compare(x, (T)v)>=0){
              break;
            }
          e[k]=v;
            k=p;
        }
        e[k]=x;
    }
    private static <T>void shiffupsusingcomparble(int k,T x,Object[]e){
        Comparable<?super T>v= (Comparable<? super T>) x;
        while (k>0){
            int p=(k-1)>>>1;
            Object t=e[p];
            if(v.compareTo((T)t)>=0){
                break;
            }
            e[k]=t;
            k=p;
        }
        e[k]=v;

    }
    private void shiffdow(int k,E x){
        if(comparator!=null){
            shiffdowusingcompare(k,x,this.ele,comparator,this.size);
        }else {
            shiffdowsingcomparable(k,x,this.ele,this.size);
        }
    }
    private static <T>void shiffdowusingcompare(int k,T x,Object[]e,Comparator<? super T>c ,int n){
        int s=n>>>1;
        while (k<s){
            int left=2*k+1;
            int right=left+1;
            Object v=e[left];
            if(right<n&&c.compare((T)v,(T)e[right])>0){
           v=e[left=right];
            }
            if(c.compare(x, (T)v)<=0){
                break;
            }
            e[k]=v;
            k=left;
        }
        e[k]=x;
    }
    private static <T>void shiffdowsingcomparable(int k,T x,Object[]e,int n){
        int s=n>>>1;
        Comparable<? super T>y= (Comparable<? super T>) x;
        while (k<s){
            int left=2*k+1;
            int right=left+1;
            Object v=e[left];
            if(right<n&&((Comparable<? super T>)v).compareTo((T)e[right])>0){
                v=e[left=right];
            }
            if(y.compareTo((T)v)<0){
                break;
            }
            e[k]=v;
            k=left;
        }
        e[k]=y;
    }
    public int size(){
        return this.size;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public E peek(){
        return(E) ele[0];
    }

    public static void main(String[] args) {
    Mypriorityqueue<String>m=new Mypriorityqueue<>((a,b)->b.compareTo(a));
        m.add("bb");
        m.add("dd");
        m.add("cc");
        m.add("aa");
        m.add("fgf");
        while (!m.isEmpty()){
            System.out.println(m.remove());
        }


    }
}
