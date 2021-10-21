package ArrayADT;

public class delete {
    static void remove(int ar[], int idex) {
        int n = ar.length;
        int rmove[] = new int[n - 1];
        System.arraycopy(ar, 0, rmove, 0, idex);
        System.arraycopy(ar, idex + 1, rmove, idex, n - idex - 1);
        ar = rmove;
        for (int s : ar
        ) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        int ar[] = {1, 2, 3, 4, 5, 6, 7};
     int a[]=new int[10];
        a[0]=1;
        a[1]=2;
        a[2]=3;
        a[3]=4;
        for (int i = 4; i >2; i--) {
            a[i]=a[i-1];
        }
        a[2]=89;
//        for (int i = 1; i <4; i++) {
//            a[i]=a[i+1];
//        }
        for (int s:a
             ) {
            System.out.print(s+"  ");
        }
    }
}
