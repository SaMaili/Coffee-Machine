import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int zeros = 0;
        int positive = 0;
        int negative = 0;
        for (int i = 0; i < len; i++) {
            int current = scanner.nextInt();
            if (current == 0) {
                zeros++;
            } else if (current == 1) {
                positive++;
            } else {
                negative++;
            }
        }
        System.out.println(zeros + " " + positive + " " + negative);
    }
}