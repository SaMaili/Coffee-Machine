import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean a = scanner.nextInt() > 0;
        boolean b = scanner.nextInt() > 0;
        boolean c = scanner.nextInt() > 0;
        boolean existsOneTime = false;
        int i = 0;
        if (a) {
            i++;
        }
        if (b) {
            i++;
        }
        if (c) {
            i++;
        }
        if (i == 1) {
            existsOneTime = true;
        }
        System.out.println(existsOneTime);
    }
}
