import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.next();
        boolean isSymmetrical = number.equals(new StringBuffer(number).reverse().toString());
        if (isSymmetrical) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}