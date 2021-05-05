package lesson6;

public class Dog extends Animal {
    private int maxRunDistance;
    private int maxSwimDistance;
    private static int countDogs;

    public Dog(String name, int maxRunDistance, int maxSwimDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        countDogs ++;
    }

    @Override
    public void run(int distance) {
        if (distance > maxRunDistance) {
            System.out.println(this.getName() + " can't run that much.");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > maxSwimDistance) {
            System.out.println(this.getName() + " can't swim that much.");
            return;
        }
        super.swim(distance);
    }

    public static int getCountDogs() {
        return countDogs;
    }
}
