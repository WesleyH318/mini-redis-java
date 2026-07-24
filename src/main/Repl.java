package main;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import main.commands.Command;
import main.commands.CommandFactory;
import main.commands.ExitCommand;

// Command loop reads input and dispatches via CommandFactory
public class Repl {

    private final Store store;
    private final CommandFactory factory;
    private final InputStream in;
    private final PrintStream out;

    public Repl(Store store, CommandFactory factory) {
        this(store, factory, System.in, System.out);
    }

    public Repl(Store store, CommandFactory factory, InputStream in, PrintStream out) {
        this.store = store;
        this.factory = factory;
        this.in = in;
        this.out = out;
    }

    public void run() {
        Scanner scanner = new Scanner(in);
        out.println("mini-redis (type HELP for commands, EXIT to quit)");

        while (true) {
            out.print("> ");
            if (!scanner.hasNextLine()) break;
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 3);

            Command command = factory.create(parts[0]);
            String result = command.execute(store, parts);

            if (ExitCommand.EXIT_SIGNAL.equals(result)) {
                out.println("bye");
                return;
            }
            out.println(result);
        }
    }
}