package java1.lesson7;

public class PlusString {
    public static void main(String[] args) {
        String s = "I like Java!!!";
        demoString(s);
    }

    public static void demoString(String str) {
        System.out.println(str);
        System.out.println("The last character of " + str + " is: " + str.charAt(str.length() - 1));
        if (str.endsWith("!!!")) {
            System.out.println(str + " ends with '!!!'");
        }
        if (str.startsWith("I like")) {
            System.out.println(str + " starts with 'I like'");
        }
        if (str.contains("Java")) {
            System.out.println(str + " contains 'Java'");
        }
        System.out.println("'Java' starts with index " + str.indexOf("Java"));
        System.out.println(str.replace('a', 'o'));
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());
        System.out.println(str.substring(0, 7) + str.substring(11));
    }
}
