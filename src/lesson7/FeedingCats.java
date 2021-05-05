package lesson7;

import java.util.Scanner;

public class FeedingCats {
    public static void main(String[] args) {
        Plate plate = new Plate();
        plate.infoPlate();
        plate.fillingPlate();
        Cat[] cats = Cat.createCatArray(enterNumberCats());
        feedingCatsTurns(plate, cats);
    }

    private static int enterNumberCats() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("How many cats do you want to feed?");
        do {
            System.out.println("You must enter a positive integer:");
            if (!sc.hasNextInt()) {
                System.out.println("That not a number.");
                sc.next();
            }
            n = sc.nextInt();
        } while (n <= 0);
        return n;
    }

    private static void feedingCatsTurns(Plate plate, Cat[] cats) {
        for (Cat cat : cats) {
            plate.infoPlate();
            cat.eat(plate);
            cat.infoSatiety();
            if (!cat.getSatiety()){
                plate.cleaningPlate();
                plate.fillingPlate();
                cat.eat(plate);
                cat.infoSatiety();
            }
            System.out.println("----------------------------");
        }
    }
}
