package Tree;

public class student {
    String name;
    int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void print(){
        System.out.println(toString());
    }
}
