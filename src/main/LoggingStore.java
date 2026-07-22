package main;

import java.io.PrintStream;

// Decorator: wraps any Store and logs each operation before delegating.
public class LoggingStore implements Store {

    private final Store inner;
    private final PrintStream out;

    public LoggingStore(Store inner) {
        this(inner, System.out);
    }

    public LoggingStore(Store inner, PrintStream out) {
        this.inner = inner;
        this.out = out;
    }

    @Override
    public void set(String key, String value) {
        out.println("[log] SET " + key);
        inner.set(key, value);
    }

    @Override
    public String get(String key) {
        out.println("[log] GET " + key);
        return inner.get(key);
    }

    @Override
    public boolean delete(String key) {
        out.println("[log] DEL " + key);
        return inner.delete(key);
    }

    @Override
    public int size() {
        out.println("[log] SIZE");
        return inner.size();
    }
}