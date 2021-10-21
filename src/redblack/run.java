package redblack;

import java.util.ArrayList;
import java.util.Comparator;

public class run {
    public static void main(String[] args) {
        RedBlack<String,Integer>t=new RedBlack<>();
        t.insert("a",1);
        t.insert("b",2);
        t.insert("c",3);
        t.insert("d",4);
        t.insert("e",5);
        t.insert("f",6);
        t.insert("g",7);
        t.insert("h",8);
        ArrayList<String>w=t.keys();
        for (int j = 0; j < w.size(); j++) {
            System.out.println(t.getv(w.get(j)));
        }

    }
}
