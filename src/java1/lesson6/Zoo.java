package java1.lesson6;

public class Zoo {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom",200);
        Cat cat2 = new Cat("Jerry",150);
        Cat cat3 = new Cat("Bob",170);
        Dog dog1 = new Dog("Pip",500,10);
        Dog dog2 = new Dog("Myer",450,15);
        Dog dog3 = new Dog("King",520,12);

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
