import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        String string = new Scanner(System.in).next();
        System.out.println(string.toLowerCase().charAt(0) == 'j');
    }
}