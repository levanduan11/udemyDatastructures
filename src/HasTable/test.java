package HasTable;

public class test {
    static<T> int k(T s){
        int k=s.hashCode();
        return k;
    }

    public static void main(String[] args) {
        System.out.println(test.k("aaa"));
    }
}
