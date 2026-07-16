package main.commands;

import main.Store;

// EXIT signals the Repl to stop through a sentinel value
public class ExitCommand implements Command {


    public static final String EXIT_SIGNAL = "__EXIT__";

    @Override
    public String execute(Store store, String[] args) {
        return EXIT_SIGNAL;
    }
}