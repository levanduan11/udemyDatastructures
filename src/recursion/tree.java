package recursion;

public class tree {
static void f(int l,int r ,String s){
    int c=0;
    if(l==0&&r==0){
        c++;
    }
    if (l > 0) {
       f(l - 1, r + 1, s + '(');
    }

    if (r > 0) {
        f(l, r - 1, s + ')');
    }
//    if(k>0){
//        f(l, r ,k-1, s + ')');
//
//    }
}
    static void tree(int n){
        if(n>0){
            System.out.println(n);
//            tree(n-1);
//            tree(n-1);
//            tree(n-1);
            for (int i = 0; i < 3; i++) {
//                tree(n-1);
//                tree(n/2);
//                tree(n-2);
                for (int j = 0; j < 2; j++) {
                    tree(n-1);
                    tree(n/2);
                }
            }
        }
    }
    public static void main(String[] args) {
    // f(3,0,"");3211121112111

        tree(10);

    }
}
