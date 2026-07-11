package main;

// Contract for a key-value store.
public interface Store {
    void set(String key, String value);
    String get(String key);
    boolean delete(String key);
    int size();
}
