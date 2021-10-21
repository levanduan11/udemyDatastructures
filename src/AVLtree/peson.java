package AVLtree;

public class peson {
    String name;
    int age;

    @Override
    public String toString() {
        return "peson{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public peson(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
