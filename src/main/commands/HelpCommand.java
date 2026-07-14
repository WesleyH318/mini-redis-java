package main.commands;

import main.Store;

// HELP lists available commands
public class HelpCommand implements Command{

    @Override
    public String execute(Store store, String[] args){
        return "Commands: SET key value | GET key | DEL key | HELP | EXIT";
    }
}