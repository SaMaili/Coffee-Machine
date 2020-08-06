import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int length = scanner.nextInt();

        int[] ints = new int[length];
        int max = Integer.MIN_VALUE;
        int index = 0;

        for (int i = 0; i < ints.length; i++) {
            ints[i] = scanner.nextInt();
            if (max < ints[i]) {
                max = ints[i];
                index = i;
            }
        }
        System.out.println(index);
    }
}