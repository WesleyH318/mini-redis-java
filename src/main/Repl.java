package main;

import java.util.Scanner;
import main.commands.Command;
import main.commands.CommandFactory;

// Command loop reads input and dispatches via CommandFactory
public class Repl {

    private final Store store;
    private final CommandFactory factory = new CommandFactory();

    public Repl(Store store) {
        this.store = store;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mini-redis (type HELP for commands, EXIT to quit)");

        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 3);

            if (parts[0].equalsIgnoreCase("EXIT")) {
                System.out.println("bye");
                return;
            }

            Command command = factory.create(parts[0]);
            System.out.println(command.execute(store, parts));
        }
    }
}