package zooSimulator;

public class Main {
    public static void main(String[] args) {
        Animal lion = new Lion();
        Animal elephant = new Elephant();
        Animal monkey = new Monkey();

        Zoo.makeAnimalSound(lion);
        Zoo.makeAnimalSound(elephant);
        Zoo.makeAnimalSound(monkey);
    }
}
