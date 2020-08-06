import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int currentBiggest = 0;
        while (i > 0) {
            int nextInt = scanner.nextInt();
            if (nextInt % 4 == 0 && nextInt > currentBiggest) {
                currentBiggest = nextInt;
            }
            i--;
        }
        System.out.println(currentBiggest);
    }
}