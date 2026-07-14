package main.commands;

import main.Store;

// GET key retrieves the value for a key
public class GetCommand implements Command{

    @Override
    public String execute(Store store, String[] args) {
        if (args.length < 2){
            return "(error) usage: GET key";
        }
        String value = store.get(args[1]);
        return value == null ? "(nil)" : value;
    }
}