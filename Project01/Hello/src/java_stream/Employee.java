package java_stream;

public class Employee {
    private String name;
    private double base;
    private double bonus;

    public Employee(String name, double base, double bonus) {
        this.name = name;
        this.base = base;
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", base=" + base +
                ", bonus=" + bonus +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
