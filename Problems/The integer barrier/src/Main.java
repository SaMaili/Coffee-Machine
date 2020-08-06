import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;
        while (true) {
            int next = scanner.nextInt();

            if (sum >= 1000) {
                sum -= 1000;
                break;

            } else if (next == 0) {
                break;
            }

            sum += next;
        }
        System.out.println(sum);
    }
}