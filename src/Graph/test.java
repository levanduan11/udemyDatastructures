package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class test {
    class p{
        int k;

        public p(int k) {
            this.k = k;
        }

//        @Override
//        public int compareTo(p o) {
//           return this.k-o.k;
//        }
//
        @Override
        public String toString() {
            return "p{" +
                    "k=" + k +
                    '}';
        }
    }
  ArrayList add(){
      p a=new p(9);
      p b=new p(-9);
      p c=new p(1);
      p d=new p(2);
        ArrayList<p>i=new ArrayList<>();
      i.add(a);
      i.add(b);
      i.add(c);
      i.add(d);
      Collections.sort(i,(o1,o2)->o1.k-o2.k);
        return i;
    }
     void sort(){
        PriorityQueue<p>l=new PriorityQueue<>(add());
        while (!l.isEmpty()){
            System.out.println(l.poll().toString());
        }
    }

    public static void main(String[] args) {
        test t=new test();
       ArrayList<p>i=t.add();
        for (int j = 0; j < i.size(); j++) {
            System.out.println(i.get(j).toString());
        }
    }
}
