package lesson6;

public class Cat extends Animal {
    private static int COUNT_CATS;

    public Cat(String name) {
        super(name);
        super.countBeing();
    }

    @Override
    public int countBeing() {
        return COUNT_CATS++;
    }

    @Override
    public void run(int distance) {
        if (distance > 200) {
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
        return COUNT_CATS;
    }
}
