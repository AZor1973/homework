package lesson6;

public class Dog extends Animal {
    private static final int MAX_RUN_DISTANCE = 500;
    private static final int MAX_SWIM_DISTANCE = 10;
    private static int countDogs;

    public Dog(String name) {
        super(name);
        countDogs ++;
    }

    @Override
    public void run(int distance) {
        if (distance > MAX_RUN_DISTANCE) {
            System.out.println(this.getName() + " can't run that much.");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > MAX_SWIM_DISTANCE) {
            System.out.println(this.getName() + " can't swim that much.");
            return;
        }
        super.swim(distance);
    }

    public static int getCountDogs() {
        return countDogs;
    }
}
