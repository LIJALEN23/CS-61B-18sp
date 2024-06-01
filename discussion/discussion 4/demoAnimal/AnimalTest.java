package demoAnimal;

public class AnimalTest {
    public static void main(String[] name) {
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet();
        c.greet();
        d.greet();

        a = c;
        a.greet();
        ((Cat) a).greet();
        a.greet();

        a = new Dog("Spot", 10);
        d = (Dog) a;
    }
}
