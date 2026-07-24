package main;

import main.commands.CommandFactory;

public class Main {
    public static void main(String[] args) {
        // the capacity is set to 3 so eviction is easier to demonstate in the REPL
        Store store = new LoggingStore(new BoundedStore(new MapStore(), 3, new EvictOldestPolicy()));
        Repl repl = new Repl(store, new CommandFactory());
        repl.run();
    }
}
