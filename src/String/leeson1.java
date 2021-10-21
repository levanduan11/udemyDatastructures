package String;

import java.util.ArrayList;

public class leeson1 {
  static   ArrayList<String>arrayList=new ArrayList<>();
    public static void main(String[] args) {
print(3,"");
        for (String s:arrayList
             ) {
            System.out.println(s);
        }

    }
    static boolean checkRe(String a,String b,int i,int j){

       if(i==b.length())return true;
       if(a.charAt(i)==b.charAt(j)){
           i++;
       }

       if(j==b.length()-1){
           j=0;
           j=j-1;
       }
       return checkRe(a,b,i,j=j+1);

    }
    static void d(int n,String s){
        if(n==0){
            System.out.println(s);
            return;
        }
        for (int i = 0; i <=1; i++) {
            d(n-1,s+i);
        }
    }
    static boolean checkdup(String s){
        for (int i = 0; i < s.length()-1; i++) {
            for (int j = i+1; j <s.length() ; j++) {
                if(s.charAt(i)==s.charAt(j))return false;
            }
        }
        return true;
    }
    static void  print (int n, String s){
if(n==0){
    if(checkdup(s))
        arrayList.add(s);
    return;
}
        for (int i = 0; i <=2; i++) {
            print(n-1,s+(char) (i+'A'));
        }
    }
static boolean checkmastcher(String a,String b){
        if(a.length()>b.length()||b.length()>a.length())return false;
 int cout[]=new int[26];
    for (int i = 0; i < a.length(); i++) {
        cout[a.charAt(i)-'a']++;
    }
    for (int i = 0; i < b.length(); i++) {
        cout[b.charAt(i)-'a']--;
        if(cout[b.charAt(i)-'a']<0)
            return false;
    }

return true;
}
    static void f(String s) {
        int h = 0, x = 0;
        for (int i = 0; i < s.length(); i++) {
            x = 1;
            x = x << s.charAt(i) - 'a';
            if ((x & h) > 0) {
                System.out.println(s.charAt(i));
            } else {
                h = x | h;
            }
        }
    }

    static void print(String[] a) {
        for (String s : a
        ) {
            System.out.print(s + "  ");
        }
    }

    static void swap(String[] a, int i, int j) {
        String r = a[i];
        a[i] = a[j];
        a[j] = r;

    }

    static void sort(String[] a) {
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && comPare(a[j - 1], a[j]) < 0; j--) {
                swap(a, j, j - 1);
            }

        }
        for (String s : a
        ) {
            System.out.println(s);
        }
    }

    static int comPare(String a, String b) {
        for (int i = 0, j = 0; i < a.length() && i < b.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                return a.charAt(i) - b.charAt(i);
            }

        }
        return a.length() - b.length();
    }

    static String revers(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int i;
        for (i = s.length() - 1; i >= 0; i--) {
            stringBuffer.append(s.charAt(i));
        }

        return stringBuffer.toString();
    }
static char[] sort(char []a){
    int cout[] = new int[26];
    for (int i = 0; i < a.length; i++) {
        cout[a[i] - 'a']++;
    }
            for (int i = 0; i < cout.length-1; i++) {
            cout[i+1]+=cout[i];
        }

        char[]f=new char[a.length];
        for (int i = f.length-1; i >=0 ; i--) {
          f[cout[a[i]-'a']-1]=a[i];
        cout[a[i]-'a']--;
        }
        a=f;
       return a;

}
    static void finddupp(String s) {
        char a[] = s.toCharArray();
        int cout[] = new int[26];
        for (int i = 0; i < a.length; i++) {
            cout[a[i] - 'a']++;
        }
        for (int i = 0; i < cout.length; i++) {
            if (cout[i] > 0) {
                System.out.println((char) (i + 'a') + " => " + cout[i]);
            }
        }
//        for (int i = 0; i < cout.length-1; i++) {
//            cout[i+1]+=cout[i];
//        }
//
//        char[]f=new char[a.length];
//        for (int i = f.length-1; i >=0 ; i--) {
//          f[cout[a[i]-'a']-1]=a[i];
//        cout[a[i]-'a']--;
//        }
//        a=f;
//        for (char ss:a
//             ) {
//            System.out.println(ss);
//        }


    }

    static int coutn(String s) {
        String r[] = s.split(" ");
        return r.length;
    }


}
