package lesson6;

public class Dog extends Animal {
    private static int COUNT_DOGS;

    public Dog(String name) {
        super(name);
        super.countBeing();
    }

    @Override
    public int countBeing() {
        return COUNT_DOGS++;
    }

    @Override
    public void run(int distance) {
        if (distance > 500) {
            System.out.println(this.getName() + " can't run that much.");
            return;
        }
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        if (distance > 10) {
            System.out.println(this.getName() + " can't swim that much.");
            return;
        }
        super.swim(distance);
    }

    public static int getCountDogs() {
        return COUNT_DOGS;
    }
}
