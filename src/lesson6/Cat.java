package lesson6;

public class Cat extends Animal {
    private final int maxRunDistance;
    private static int countCats;

    public Cat(String name, int maxRunDistance) {
        super(name);
        this.maxRunDistance = maxRunDistance;
        countCats ++;
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
        System.out.println(this.getName() + " can't swim.");
    }

    public static int getCountCats() {
        return countCats;
    }
}
