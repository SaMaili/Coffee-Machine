import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int begin = scanner.nextInt();
        int end = scanner.nextInt();

        int divisibleNumbs = 0;
        int divSum = 0;
        for (int i = begin; i <= end; i++) {
            if (i % 3 == 0) {
                divisibleNumbs++;
                divSum += i;
            }
        }

        double average = (double) divSum / divisibleNumbs;
        System.out.println(average);
    }
}