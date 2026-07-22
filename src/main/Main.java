package main;

public class Main {
    public static void main(String[] args) {
        Store store = new LoggingStore(new MapStore());
        Repl repl = new Repl(store);
        repl.run();
    }
}
