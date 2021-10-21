package String;

public class lesson1 {
    static void d(int n){
        if(n==0)return;
        d(n-1);
        System.out.println(n);
        d(n/2);
    }
    public static void main(String[] args) {
        String d = "nguyenvana";
        char ir[]=new char[d.length()];
        for (int i = 0; i < ir.length; i++) {
            ir[i] =d.charAt(i);
        }
        for (int i = 0; i < ir.length; i++) {
            ir[i]-=32;
        }

        String ss="";
        for (char s:ir
             ) {
        ss+=s;
        }
        StringBuffer res = new StringBuffer();
        for (int i = 0; i < d.length(); i++) {
            if (d.charAt(i) >= 'A' && d.charAt(i) <= 'Z') {
                char s= (char) (d.charAt(i)+32);
                res.append(s);
            }else {
                char s= (char) (d.charAt(i)-32);
                res.append(s);
            }
        }
    }
}
