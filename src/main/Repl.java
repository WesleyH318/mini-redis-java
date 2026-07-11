package main;

import java.util.Scanner;

// Command loop: reads set/get/del/help/exit and runs them against Store.
public class Repl {

    private final Store store;

    public Repl(Store store){
        this.store = store;
    }

    public void run(){
        // TODO: full command loop
        // Planned: read input with Scanner, parse into command + args and execute SET/GET/DEL/HELP/EXIT against the store
        System.out.println("under construction");
    }

}
