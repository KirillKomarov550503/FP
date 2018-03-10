package resource.general;

import java.util.Objects;

public class Person {
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(age, person.age) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(age, name);
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;

    }

    public String getName() {
        return name;
    }
}
