package Graph;

public class uf {
    int []id,sz;
    int n;

    public uf(int n) {
        id=new int[n];
        sz=new int[n];
        for (int i = 0; i < n; i++) {
            id[i]=i;//chi so la nut con values la parent luc dau gan paren cho chinh no bang vs chi so
            sz[i]=1;
        }
    }
    public int find(int p){
        int root=p;
        while (root!=id[root]){
            root=id[root];
        }
        while (p!=root){
            int next=id[p];
            id[p]=root;
            p=next;

        }
        return root;
    }
    public void union(int p,int q){
        int root1=find(p);
        int root2=find(q);
        if(root1==root2)return;
        if(sz[root1]<sz[root2]){
            //hop roo1 vs roo2
            id[root1]=root2;//gan parent r1 cho r2
            sz[root2]+=sz[root1];
        }else {
            //hop roo2 vs root1
           id[root2]=root1;
            sz[root1]+=sz[root2];
        }
    }

    public static void main(String[] args) {
        uf i=new uf(10);
        i.union(6,5);
        i.union(5,4);
        i.union(4,3);
        i.union(3,2);
        i.union(2,1);
        i.union(1,0);
        i.union(3,1);
        i.union(8,9);
        i.union(5,0);
        i.union(7,2);
        i.union(6,1);
        i.union(1,0);
        i.union(6,7);
    }
}
