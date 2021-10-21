package stack;

public class ex2 {
//    static String convert(String s) {
//        StringBuffer b = new StringBuffer();
//        ex1<Character> e = new ex1<>();
//        e.push(s.charAt(0));
//        for (int i = 1; i < s.length(); i++) {
//            char h = e.peek();
//            int k = pre(s.charAt(i)) - pre(h);
//            if (k > 0) {
//                e.push(s.charAt(i));
//            } else {
//                char v = e.pop();
//                b.append(v);
//                if (!e.isEmpty()) {
//                    int u = pre(s.charAt(i)) - pre(e.peek());
//                    while (!e.isEmpty() && u <= 0) {
//                        v = e.pop();
//                        b.append(v);
//                        if (!e.isEmpty()) {
//                            u = pre(s.charAt(i)) - e.peek();
//                        }
//                    }
//                }
//                e.push(s.charAt(i));
//            }
//        }
//        while (!e.isEmpty()) {
//            b.append(e.pop());
//        }
//        return b.toString();
//    }

    static boolean check(char a) {
        if (a >= 'a' && a <= 'z') {
            return true;
        }

        return false;
    }
static String convert(String s){
        StringBuffer b=new StringBuffer();
        ex1<Character>e=new ex1<>();
        e.push('#');
    for (int i = 0; i < s.length(); i++) {
        int j=0,k=0;
        if(operater(s.charAt(i))){
            b.append(s.charAt(i));
        }else {
            if(pre(s.charAt(i))>pre(e.peek())){
                e.push(s.charAt(i));
            }else {
                b.append(e.pop());
            }
        }
    }
    while (!e.isEmpty()){
        b.append(e.pop());
    }
    return b.toString();
}
    static int pre(char a) {
        if (a == '+' || a == '-') {

            return 1;
        } else if (a == '*' || a == '/') {

            return 2;
        }
//        else if (a >= 'a' && a <= 'z') {
//            return 3;
//        }
        return 0;
    }

    static boolean operater(char a) {
        switch (a) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
        }
        return false;
    }
static int n(int t){
        if(t==4){
            return t;
        }
        int a=2*n(t+1);
        return a;
}
    public static void main(String[] args) {
        String s = "a+b*c";
        System.out.println(n(2));

    }
}
