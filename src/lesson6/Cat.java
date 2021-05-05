package lesson6;

public class Cat extends Animal {
    private static final int MAX_RUN_DISTANCE = 200;
    private static int countCats;

    public Cat(String name) {
        super(name);
        countCats ++;
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
        System.out.println(this.getName() + " can't swim.");
    }

    public static int getCountCats() {
        return countCats;
    }
}
