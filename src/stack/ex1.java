package stack;

public class ex1<T> {
    Object[] arr;
    int top;
    int size = 0;

    public ex1() {
        this(10);
    }

    public ex1(int n) {
        this.arr = new Object[n];
        this.top = -1;
    }

    public void push(T data) {
        if (this.size == this.arr.length) {
            grow();
        }
        arr[++top] = data;
        this.size++;
    }

    public void grow() {
        int n = this.arr.length;
        Object narr[] = new Object[2 * n];
        System.arraycopy(arr, 0, narr, 0, n);
        this.arr = narr;
    }

    public T pop() {
        if (top == -1) throw new ArrayIndexOutOfBoundsException("khong duoc pop");

        Object narr[] = new Object[arr.length];
        System.arraycopy(arr, 0, narr, 0, top);
        T data = (T) arr[top--];
        this.size--;
        this.arr = narr;
        return (T) data;
    }

    public T pop2() {
        T data = (T) arr[top];
        for (int i = top; i < this.size; i++) {
            arr[i] = arr[i + 1];
        }
        top--;
        this.size--;
        return data;
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    public T peek() {
        return (T) arr[top];
    }

    boolean checkmatches(String s) {
        ex1<Character> e = new ex1<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                e.push(s.charAt(i));
            } else {
                if (e.isEmpty() || s.charAt(i) == ')') {
                    return false;
                } else {
                    e.pop();
                }
            }
        }
        return e.isEmpty();
    }

    int findMaxStack(String s) {
        ex1<Character> e = new ex1<>();
        int max = 0;
        int k = 0;
        for (int i = 0; i < s.length(); i++) {
            if (e.isEmpty() && s.charAt(i) == ')') {
                k = 0;
            } else if (s.charAt(i) == '(') {
                e.push(s.charAt(i));
            } else {
                e.pop();
                k += 2;
            }
            max = Math.max(max, k);
        }
        return max;
    }

    int findMaxRecursion(String s, int max, int l, int r, int c) {
        if (!s.isEmpty()) {
            if (l == r && l != 0 && r != 0) {
                if (c > 0) {
                    c = c + l + r;
                } else {
                    c = l + r;
                }
                l = r = 0;
                max = Math.max(max, c);
                if (s.charAt(0) == ')') {
                    c = 0;
                    return findMaxRecursion(s.substring(1), max, l, r, c);
                } else {
                    return findMaxRecursion(s.substring(1), max, l = l + 1, r, c);
                }
            } else if (l == 0 && r == 0 && s.charAt(0) == ')') {
                //c=0;
                return findMaxRecursion(s.substring(1), max, l, r, c);
            } else if (s.charAt(0) == '(') {
                return findMaxRecursion(s.substring(1), max, l = l + 1, r, c);
            } else {
                return findMaxRecursion(s.substring(1), max, l, r = r + 1, c);
            }
        }
        return max = l == r ? max + l + r : max;
    }

    public int size() {
        return this.size;
    }

    public static void main(String[] args) {
        ex1<Character> e = new ex1<>();
        String s = "(()))(())()";
        System.out.println(e.findMaxRecursion(s, 0, 0, 0, 0));


    }
}
