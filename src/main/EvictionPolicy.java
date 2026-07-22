package main;

import java.util.Collection;

// Strategy: decides which key to evict when a bounded store is full
public interface EvictionPolicy {

    // keys are in insertion order
    // Return the key to evict, or null to reject the new write
    String chooseVictim(Collection<String> keys);
}