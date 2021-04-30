package lesson6;

public class Zoo {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom");
        Cat cat2 = new Cat("Jerry");
        Cat cat3 = new Cat("Bob");
        Dog dog1 = new Dog("Pip");
        Dog dog2 = new Dog("Myer");
        Dog dog3 = new Dog("King");

        System.out.println("Cats:");
        System.out.println();
        cat1.run(40);
        cat2.run(300);
        cat3.swim(30);
        System.out.println("________________________________");
        System.out.println();
        System.out.println("Dogs:");
        System.out.println();
        dog1.run(150);
        dog2.swim(5);
        dog3.swim(20);
        System.out.println("_________________________________");
        System.out.printf("We have %d animals: %d cats and %d dogs.", Animal.getCountAnimals(), Cat.getCountCats(),
                Dog.getCountDogs());
    }
}
