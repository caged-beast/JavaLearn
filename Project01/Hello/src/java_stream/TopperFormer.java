package java_stream;

public class TopperFormer {
    String name;
    Double Salary;

    public TopperFormer(String name, Double salary) {
        this.name = name;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "TopperFormer{" +
                "name='" + name + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
