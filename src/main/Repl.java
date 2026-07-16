package main;

import java.util.Scanner;
import main.commands.Command;
import main.commands.CommandFactory;
import main.commands.ExitCommand;

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

            Command command = factory.create(parts[0]);
            String result = command.execute(store, parts);

            if (ExitCommand.EXIT_SIGNAL.equals(result)) {
                System.out.println("bye");
                return;
            }
            System.out.println(result);
        }
    }
}