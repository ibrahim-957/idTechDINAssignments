package person;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ibrahim", 23);
        Person person2 = new Person();
        person2.setName("Shahin");
        person2.setAge(19);

        System.out.println(person1.getName()  + "age is: " + person1.getAge() + " years old");
        System.out.println(person2.getName()  + "age is: " + person2.getAge() + " years old");
    }
}
