import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //array from split will always have 3 objects: number1, operator and number2
        String[] calculation = scanner.nextLine().split(" ");

        long number1 = Long.parseLong(calculation[0]);
        long number2 = Long.parseLong(calculation[2]);

        switch (calculation[1]) {
            case "+":
                System.out.println(number1 + number2);
                break;
            case "-":
                System.out.println(number1 - number2);
                break;
            case "/":
                System.out.print(number2 == 0 ? "Division by 0!" : number1 / number2);
                break;
            case "*":
                System.out.println(number1 * number2);
                break;
            default:
                System.out.println("Unknown operator");
                break;
        }
    }
}
