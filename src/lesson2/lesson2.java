package lesson2;

public class lesson2 {
    public static void main(String[] args) {
        System.out.println(checkSum(12, 6));
        printSign(0);
        System.out.println(checkSign(0));
        printXtimes("Ha", 3);
        System.out.println(leapYear(400));
    }

    private static boolean checkSum(int a, int b) {
        return (a + b >= 10 && a + b <= 20);
    }

    private static void printSign(int i) {
        if (i >= 0) System.out.println("Number is positive.");
        else System.out.println("Numder is negative.");
    }

    private static boolean checkSign(int i) {
        return i < 0;
    }

    private static void printXtimes(String s, int i) {
        for (int j = 0; j < i; j++) {
            System.out.println(s);
        }
    }

    private static boolean leapYear(int y) {
        if (y % 100 == 0 && y % 400 != 0) return false;
        return y % 4 == 0;
    }
}
