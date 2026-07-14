package main.commands;

import main.Store;

// DEL key removes a key and prints 1 if it existed and 0 if not
public class DelCommand implements Command{

    @Override
    public String execute(Store store, String[] args){
        if(args.length < 2){
            return "(error) usage: DEL key";
        }
        return store.delete(args[1]) ? "1" : "0";
    }
}
