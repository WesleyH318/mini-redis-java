package main.commands;

import main.Store;

// SIZE reports how many keys are stored
public class SizeCommand implements Command {

    @Override
    public String execute(Store store, String[] args) {
        return String.valueOf(store.size());
    }
}