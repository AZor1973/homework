package lesson6;

public class Animal {
    private final String name;
    private static int COUNT_ANIMALS;

    public Animal(String name) {
        this.name = name;
        countBeing();
    }

    public int countBeing() {

        return COUNT_ANIMALS++;
    }

    public void run(int distance) {

        System.out.println(this.name + " run " + distance + " meters.");
    }

    public void swim(int distance) {
        System.out.println(this.name + " swim " + distance + " meters.");
    }

    public String getName() {
        return name;
    }

    public static int getCountAnimals() {
        return COUNT_ANIMALS;
    }
}
