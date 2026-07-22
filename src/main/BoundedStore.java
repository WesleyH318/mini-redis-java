package main;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

// when full, delegates the eviction decision to an EvictionPolicy (Strategy pattern).
public class BoundedStore implements Store {

    private final Store inner;
    private final int capacity;
    private final EvictionPolicy policy;
    private final Set<String> keys = new LinkedHashSet<>();

    public BoundedStore(Store inner, int capacity, EvictionPolicy policy) {
        this.inner = inner;
        this.capacity = capacity;
        this.policy = policy;
    }

    @Override
    public void set(String key, String value) {
        if (keys.contains(key)) {
            inner.set(key, value); // overwrite, no capacity change
            return;
        }
        if (keys.size() >= capacity) {
            String victim = policy.chooseVictim(Collections.unmodifiableSet(keys));
            if (victim == null) {
                return; // policy rejected the write
            }
            inner.delete(victim);
            keys.remove(victim);
        }
        inner.set(key, value);
        keys.add(key);
    }

    @Override
    public String get(String key) {
        return inner.get(key);
    }

    @Override
    public boolean delete(String key) {
        boolean removed = inner.delete(key);
        if (removed) {
            keys.remove(key);
        }
        return removed;
    }

    @Override
    public int size() {
        return inner.size();
    }
}