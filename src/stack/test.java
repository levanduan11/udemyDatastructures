package stack;

import java.util.Stack;

public class test {
    static int perec(char a){
        switch (a){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }
    static String coverprefix(String s){
       ex1<Character> e=new ex1<>();
        String res="";
        for (int i = 0; i < s.length(); i++) {
            char h=s.charAt(i);
            if(Character.isLetterOrDigit(h)){
                res+=h;
            }
            else if(h=='('){
                e.push(h);
            }
            else if(h==')'){
                while (!e.isEmpty()&&e.peek()!='('){
                    res+=e.pop();
                }
                e.pop();
            }else {
                while (!e.isEmpty()&&perec(h)<=perec(e.peek())){
                    res+=e.pop();
                }
                e.push(h);
            }
        }
        while (!e.isEmpty()){
            if(e.peek()=='('){
                return "invalid";
            }
            res+=e.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String s= "a+b*(c^d-e)^(f+g*h)-i";//abcd^e-fgh*+^*+i-
        System.out.println(coverprefix(s));
    }
}
