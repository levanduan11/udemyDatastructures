package Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class kuskal {
    int n;
    List<edge> l;
    List<edge> res;
public boolean mstexit;
public boolean slove;
private int mscost;
    static class edge implements Comparable<edge> {
        int f;
        int t;
        int w;

        @Override
        public int compareTo(edge o) {
            return this.w - o.w;
        }
    }

    public kuskal(int n, List<edge> l) {
        this.n = n;
        this.l = l;
    }

  private   static class unf {
        int[] sz, id;

        public unf(int n) {
            sz = new int[n];
            id = new int[n];
            for (int i = 0; i < n; i++) {
                id[i] = i;
                sz[i] = 1;
            }
        }
public boolean connec(int p,int q){
            return find(p)==find(q);
}
        public int find(int p) {
            int root = p;
            while (root != id[root]) {
                root = id[root];
            }
            while (p != root) {
                int next = id[p];
                id[p] = root;
                p = next;
            }
            return root;
        }
public int size(int p){
            return sz[find(p)];
}
        public void union(int p, int q) {
            int root1 = find(p);
            int root2 = find(q);
            if (root1 == root2) return;
            if (sz[root1] < sz[root2]) {
                id[root1] = root2;
                sz[root2] += sz[root1];
            } else {
                id[root2] = root1;
                sz[root1] += sz[root2];
            }
        }

    }
    public List genmst(){
        kuka();
        return mstexit?res:null;
    }
    public int getmstcost(){
        kuka();
        return mstexit?mscost:null;
    }
private void kuka(){
        if(slove)return;
        PriorityQueue<edge>p=new PriorityQueue<>(l);
        int index=0;
        res=new ArrayList<>();
        unf u=new unf(n);
        while (!p.isEmpty()){
            edge e=p.poll();
            if(u.connec(e.f,e.t))continue;
            u.union(e.f,e.t);
            mscost+=e.w;
            if(u.size(0)==n)break;
        }
        mstexit=(u.size(0)==n);
        slove=true;
}

}
