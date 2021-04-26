package lesson3;


import java.util.Arrays;

public class Lesson3 {
    public static void main(String[] args) {
        invertArray();
        System.out.println("---------------");
        fillArray();
        System.out.println("---------------");
        changeArray();
        System.out.println("---------------");
        fillDiagonal();
        System.out.println("---------------");
        System.out.println(Arrays.toString(initialArray(5, 8)));
        System.out.println("---------------");
        minMaxValue();
        System.out.println("---------------");
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(middleSpace(array));
        System.out.println("---------------");
        offsetElements(array, -2);
    }

    //   Task#1
    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Task#2
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0, j = 50; i < arr.length / 2; i++, j++) {
            arr[i] = i + 1;
            arr[j] = j + 1;
        }
        System.out.println(Arrays.toString(arr));
    }

    //    Task#3
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    // Task#4
    public static void fillDiagonal() {
        int[][] arr = new int[5][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j || (i + j) == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    //   Task#5
    public static int[] initialArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    //   Task#6
    public static void minMaxValue() {
        int[] arr = {11, 23, 13, 4, 5, 6, 7, 8, 9};
        System.out.println(Arrays.toString(arr));
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.printf("Maximum = %d, minimum = %d \n", max, min);
    }

    // Task#7
    public static boolean middleSpace(int[] arr) {
        float sumValues = 0;
        for (int i : arr) {
            sumValues += i;
        }
        float tempSum = 0;
        boolean result = false;
        for (int j : arr) {
            tempSum += j;
            if (tempSum == sumValues / 2) {
                result = true;
            }
        }
        return result;
    }

    // Task#8
    public static void offsetElements(int[] arr, int n) {
        System.out.println(Arrays.toString(arr));
        int temp;
        if (n < 0) {
            for (int i = 0; i < -n; i++) {
                for (int j = arr.length - 1; j >= 0; j--) {
                    temp = arr[j];
                    arr[j] = arr[0];
                    arr[0] = temp;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < arr.length; j++) {
                    temp = arr[j];
                    arr[j] = arr[0];
                    arr[0] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
