package com.clt;

import java.io.*;
import java.util.Objects;
import java.util.TreeSet;

/**
 * @ Author   £ºclt.
 * @ Date     £ºCreated in 19:16 2019/7/26
 */
public class CloneTest {
    public static void main(String[] args) {
        Pet pet = new Pet("Íú²Æ", "1");
        Person p = new Person("³Â","10","mal",pet);
        Person p1 = new Person("³Â","1","mal",pet);

        System.out.println(p+" "+p.hashCode());
        Object o = p.deepClone();
        System.out.println(o+" "+o.hashCode());
        System.out.println(p == o);
        System.out.println(p .equals(o) );
        System.out.println(p.equals(p1)+" "+p1.hashCode());

        System.out.println("################################################");
        Person person1 = new Person("³Â","12422","mal",pet);
        Person person2 = new Person("³Â","2452","mal",pet);
        Person person3 = new Person("³Â","3","mal",pet);
        Person person4 = new Person("³Â","4","mal",pet);
        TreeSet<Person> set = new TreeSet<>();
        set.add(person1);
        set.add(person2);
        set.add(person3);
        set.add(person4);
        System.out.println(set);

        TreeSet<Integer> set1 = new TreeSet<>();
        set1.add(12422);
        set1.add(2452);
        set1.add(3);
        set1.add(4);
        System.out.println(set1);

        Dog dog = new Dog("À´¸£", "1");
        System.out.println(dog);
        Dog dog1 = (Dog) dog.clone();
        System.out.println(dog1);

    }
}

class Person implements Cloneable, Comparable<Person>, Serializable {
    private String name;
    private String age;
    private String sex;
    private Pet pet;

    public Person(String name, String age, String sex, Pet pet) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.pet = pet;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj = super.clone();
            if (this.getPet() != null) {
                Pet pet = (Pet) this.pet.clone();
                ((Person) obj).setPet(pet);
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", pet=" + pet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age) &&
                Objects.equals(sex, person.sex) &&
                Objects.equals(pet, person.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sex, pet);
    }

    @Override
    public int compareTo(Person person) {
        if (Integer.parseInt(this.age) - Integer.parseInt(person.age) > 0) {
            return 1;
        } else if (Integer.parseInt(this.age) - Integer.parseInt(person.age) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    public Person deepClone() {
        Person p2=null;
        Person p1=this;
        PipedOutputStream out=new PipedOutputStream();
        PipedInputStream in=new PipedInputStream();
        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try(ObjectOutputStream bo=new ObjectOutputStream(out);
            ObjectInputStream bi=new ObjectInputStream(in);) {
            bo.writeObject(p1);
            p2=(Person) bi.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p2;
    }
}



class Pet implements Cloneable{
    private String name;
    private String age;

    public Pet(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name) &&
                Objects.equals(age, pet.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}

class Dog implements Cloneable{
    private String name;
    private String age;

    public Dog(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    protected Object clone() {
        Object obj = null;
        try {
            obj =  super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}