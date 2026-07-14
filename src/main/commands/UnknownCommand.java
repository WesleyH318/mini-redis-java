package main.commands;

import main.Store;

// For unrecognized user input
public class UnknownCommand implements Command {

    @Override
    public String execute(Store store, String[] args) {
        return "(error) unknown command: " + args[0].toUpperCase();
    }
}