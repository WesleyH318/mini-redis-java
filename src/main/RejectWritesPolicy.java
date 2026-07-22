package main;

import java.util.Collection;

// Strategy implementation: reject new writes when the store is full.
public class RejectWritesPolicy implements EvictionPolicy {

    @Override
    public String chooseVictim(Collection<String> keys) {
        return null;
    }
}