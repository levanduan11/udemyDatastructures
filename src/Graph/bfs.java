package Graph;

import java.util.*;

public class bfs {
    ArrayList<ArrayList<Integer>> t ;
  boolean check[];
    public bfs(int n) {
        t = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            t.add(new ArrayList<>());
        }
        check=new boolean[t.size()];
    }

    public void add(int v, int w) {
        t.get(v).add(w);
    }

    public void bf2(int root) {
        Stack<Integer> s = new Stack<>();
        s.add(root);
        boolean[] check = new boolean[t.size()];
        while (!s.isEmpty()) {
            int c = s.pop();

            for (int r : t.get(c)
            ) {
                System.out.println(c + " >" + r);
                if (!check[r]) {
                    check[r] = true;
                    s.add(r);
                }
            }
        }
    }
public void dfs(int root){

    check[root]=true;
    for (int s:t.get(root)
         ) {

        if(!check[s]){
            System.out.println(root+" ->"+s);
            dfs(s);
        }
    }

}
public boolean cycle(int w,int u){
        check[w]=true;
    for (int s:t.get(w)
         ) {
        if(!check[s]){
           cycle(s,w);
        }else {
            if(s!=u)return true;
        }
    }
    return false;
}
    public void bf(int root) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(root);
        boolean[] check = new boolean[t.size()];
        check[root] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int s : t.get(v)) {
                System.out.println(v + "--->" + s);
                if (!check[s]) {
                    System.out.println(s + "da duoc check");
                    check[s] = true;
                    res.add(s);
                    q.add(s);
                }

            }
        }
    }

    public static void main(String[] args) {
        bfs y = new bfs(8);
        y.add(1, 2);
        y.add(1, 3);
        y.add(1, 4);
        y.add(2, 3);
        y.add(2, 1);
        y.add(3, 2);
        y.add(3, 1);
        y.add(3, 4);
        y.add(4, 5);
        y.add(4, 3);
        y.add(4, 1);
        y.add(5, 3);
        y.add(5, 4);
        y.add(5, 6);
        //y.add(5, 7);
        y.add(6, 7);
        y.add(7, 5);
        y.dfs(7);


    }
}
