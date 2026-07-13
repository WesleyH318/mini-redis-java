package main;

import java.util.Scanner;

// Command loop: reads set/get/del/help/exit and runs them against Store.
public class Repl {

    private final Store store;

    public Repl(Store store){
        this.store = store;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("mini-redis (type HELP for commands, EXIT to quit");

        while (true){
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 3);
            String command = parts[0].toUpperCase();

            switch (command){
                case "SET":
                    if (parts.length < 3){
                        System.out.println("(error) usage: SET key value");
                    } else {
                        store.set(parts[1], parts[2]);
                        System.out.println("OK");
                    }
                    break;
                case "GET":
                    if (parts.length < 2){
                        System.out.println("(error) usage: GET key");
                    } else {
                        String value = store.get(parts[1]);
                        System.out.println(value == null ? "(nil)" : value);
                    }
                    break;
                case "DEL":
                    if (parts.length < 2){
                        System.out.println("(error) usage: DEL key");
                    } else {
                        System.out.println(store.delete(parts[1]) ? "1" : "0");
                    }
                    break;
                case "HELP":
                    System.out.println("Commands: SET key value | GET key | DEL key| HELP | EXIT");
                    break;
                case "EXIT":
                    System.out.println("bye");
                    return;
                default:
                    System.out.println("(error) unknown command: " + command);
            }
        }
    }

}
