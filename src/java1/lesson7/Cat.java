package java1.lesson7;

import java.util.Random;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate p) {
        if (satiety){
            System.out.println(name + " sated.");
            return;
        }
        infoAppetite();
        if (p.getFood() == 0) {
            p.infoPlate();
        } else if (p.getFood() < appetite) {
            System.out.println("There is too little food on the plate.");
        } else {
            p.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " ate.");
        }
    }

    public static Cat[] createCatArray(int length) {
        Random rand = new Random();
        String strUp = "BTCRLPNK";
        String strLow = "eoaiyu";
        Cat[] arr = new Cat[length];
        for (int i = 0; i < length; i++) {
            arr[i] = new Cat((strUp.charAt(rand.nextInt(strUp.length()))) + "at" + (strLow.charAt(rand.nextInt(strLow.length()))),
                    rand.nextInt(10) + 5);
        }
        return arr;
    }

    public void infoSatiety() {
        if (satiety) {
            System.out.println(name + " sated.");
        } else {
            System.out.println(name + " is hungry!");
        }
    }

    public void infoAppetite() {
        System.out.println(name + " must eat " + appetite + " pieces of food to be sated.");
    }

    public boolean getSatiety(){
        return satiety;
    }
}
