import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int current = scanner.nextInt();
        int next = scanner.nextInt();
        boolean bool = true;

        if (current > next) {
            while (next != 0) {
                if (current < next) {
                    bool = false;
                    break;
                }
                current = next;
                next = scanner.nextInt();
            }
        } else {
            while (next != 0) {
                if (current > next) {
                    bool = false;
                    break;
                }
                current = next;
                next = scanner.nextInt();
            }
        }
        System.out.println(bool);
    }
}