package main.commands;

import main.Store;

public interface Command {
    // Runs command against the store with args being the full input line
    // split into parts. Returns the output to print.
    String execute(Store store, String[] args);
}
