package lesson7;

public class Plate {
    private int food;
    private boolean isPlateEmpty = true;
    private static final int PLATE_VOLUME = 30;

    public Plate() {
        this.food = 0;
    }

    public void fillingPlate() {
        if (isPlateEmpty) {
            food = PLATE_VOLUME;
            isPlateEmpty = false;
            System.out.println("We filled the plate.");
        }
        infoPlate();
    }

    public void cleaningPlate(){
        food = 0;
        isPlateEmpty = true;
        System.out.println("We cleared the plate.");
    }

    public void decreaseFood(int n) {
        food -= n;
        if (food == 0) {
            isPlateEmpty = true;
        }
    }

    public void infoPlate() {
        if (isPlateEmpty) {
            System.out.println("Plate is empty.");
        }else if (food == PLATE_VOLUME){
            System.out.println("The plate is full. There are " + food + " pieces of food on a plate.");
        } else {
            System.out.println("There are " + food + " pieces of food on a plate.");
        }
    }

    public int getFood() {
        return food;
    }
}
