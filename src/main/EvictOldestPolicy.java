package main;

import java.util.Collection;

// Strategy implementation: evict the oldest inserted key (FIFO).
public class EvictOldestPolicy implements EvictionPolicy {

    @Override
    public String chooseVictim(Collection<String> keys) {
        return keys.iterator().next();
    }
}