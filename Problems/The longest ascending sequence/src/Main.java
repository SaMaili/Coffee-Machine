import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int length = scanner.nextInt();

        int[] ints = new int[length];
        int maxLength = 0;
        int currentLength = 0;
        int compareInt = Integer.MIN_VALUE;

        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
            if (compareInt < ints[i]) {
                currentLength++;
                compareInt = ints[i];

                if (currentLength >= maxLength) {
                    maxLength++;
                }
            }
        }
        System.out.println(maxLength);
    }
}