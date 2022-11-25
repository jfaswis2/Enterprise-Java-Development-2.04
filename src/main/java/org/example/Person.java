package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class Person {
    private int id;
    private String name;
    private int age;
    private String occupation;

    public Person(int id, String name, int age, String occupation) {
        this.id = id;
        this.name = name;
        setAge(age);
        this.occupation = occupation;
    }

    public static Person clone(Person person){
        Person clone = new Person(2,person.getName(),person.getAge(), person.getOccupation());
        return clone;
    }

    public static void documentGenerator(String result) throws IOException {
        FileWriter writer = new FileWriter("person.txt");
        writer.write(result);
        writer.close();
    }

    @Override
    public String toString() {
        String result = "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", occupation='" + occupation + '\'' +
                '}';
        try {
            documentGenerator(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(occupation, person.occupation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, occupation);
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0){
            throw new IllegalArgumentException("La edad debe de ser mayor de 0");
        }
        this.age = age;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }
}
