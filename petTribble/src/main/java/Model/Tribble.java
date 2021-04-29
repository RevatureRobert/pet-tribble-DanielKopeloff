package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Tribble {

    public int id ;
    public String name;
    public int size;
    public String color;
    public int age ;
    public int numberOfHairs;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumberOfHairs() {
        return numberOfHairs;
    }

    public void setNumberOfHairs(int numberOfHairs) {
        this.numberOfHairs = numberOfHairs;
    }

    public Tribble(String name, int size, String color, int age, int numberOfHairs) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.age = age;
        this.numberOfHairs = numberOfHairs;
    }

    public Tribble(int id, String name, int size, String color, int age, int numberOfHairs) {
        this.id = id;
        this.name = name;
        this.size = size;
        this.color = color;
        this.age = age;
        this.numberOfHairs = numberOfHairs;
    }

    public Tribble(ResultSet rs)  {
        try {
            this.id = rs.getInt("id");
            this.name = rs.getString("name");
            this.age = rs.getInt("age");
            this.color = rs.getString("color");
            this.size = rs.getInt("size");
            this.numberOfHairs = rs.getInt("number_of_hairs");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Tribble{"+
                "name='" + name + '\'' +
                ", size=" + size +
                ", color='" + color + '\'' +
                ", age=" + age +
                ", numberOfHairs=" + numberOfHairs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tribble)) return false;
        Tribble tribble = (Tribble) o;
        return getId() == tribble.getId() && getSize() == tribble.getSize() && getAge() == tribble.getAge() && getNumberOfHairs() == tribble.getNumberOfHairs() && Objects.equals(getName(), tribble.getName()) && Objects.equals(getColor(), tribble.getColor());
    }


}
