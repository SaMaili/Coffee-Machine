import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int numb1 = scanner.nextInt();
        int numb2 = scanner.nextInt();
        System.out.println(string.substring(numb1, numb2 + 1));
    }
}