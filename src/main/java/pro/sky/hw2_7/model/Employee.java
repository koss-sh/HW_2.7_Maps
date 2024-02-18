package pro.sky.hw2_7.model;

import java.beans.Transient;
import java.util.Objects;

public class Employee {
    private final String firstName;
    private final String lastName;


    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Transient
    public String getFirstName() {
        return firstName;
    }

    @Transient
    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return lastName + " " + firstName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(getFirstName(), employee.getFirstName()) && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getName(), employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getName());
    }

    @Override
    public String toString() {
        return String.format("Имя: ", getName());
    }
}
