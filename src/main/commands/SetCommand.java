package main.commands;

import main.Store;

// SET key value stores a value under a key
public class SetCommand  implements Command{

    @Override
    public String execute(Store store, String[] args){
        if(args.length < 3){
            return "(error) usage: SET key value";
        }
        store.set(args[1], args[2]);
        return "OK";
    }
}
