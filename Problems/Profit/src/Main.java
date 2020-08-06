import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = scanner.nextInt();
        int percent = scanner.nextInt();
        int k = scanner.nextInt();

        int years = 0;
        while (money < k) {
            money += money * (percent / 100.0);
            years++;
        }
        System.out.println(years);
    }
}
