package Tree;

import java.util.ArrayList;

public class test {
    static bstree<String,student>i=new bstree<>();
    public static void main(String[] args) {
        student s=new student("nguyen van a",9);
        student a=new student("nguyen van b",9);
        student b=new student("nguyen van c",9);
        student d=new student("nguyen van d",9);
        student e=new student("nguyen van e",9);
        student f=new student("nguyen van f",9);
        add(s);
        add(a);
        add(b);
        add(d);
        add(e);
        add(f);
      ArrayList<String>ip=i.keys();
        for (int j = 0; j < ip.size(); j++) {
            get(ip.get(j));
        }
    }
    public static void add(student s){
        i.insert(s.name,s);
    }
    public static void get(String name){
        System.out.println(i.get1(name).toString());
    }
}
