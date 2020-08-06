import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        IntStream.range(0, 5).forEach(System.out::println);
    }
}