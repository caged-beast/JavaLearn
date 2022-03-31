package pojo;

import java.io.PrintStream;

public class Student {
    private Integer id;
    private String name;
    private Integer CLASS;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cId=" + CLASS +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getcId() {
        return CLASS;
    }

    public void setcId(Integer cId) {
        this.CLASS = cId;
    }
}
