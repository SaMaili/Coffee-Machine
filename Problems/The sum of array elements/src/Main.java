import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int length = scanner.nextInt();

        int[] ints = new int[length];
        int sum = 0;

        for (int i = 0; i < length; i++) {
            ints[i] = scanner.nextInt();
            sum += ints[i];
        }
        System.out.println(sum);
    }
}