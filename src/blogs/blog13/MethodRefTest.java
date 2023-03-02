package blogs.blog13;

import java.io.PrintStream;
import java.util.function.Consumer;

public class MethodRefTest {
    public static void main(String[] args) {
        Consumer<String> consumer = System.out::println;

        consumer.accept("Hello World");

    }
}
