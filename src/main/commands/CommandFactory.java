package main.commands;

import java.util.HashMap;
import java.util.Map;

// Registry-based Simple Factory: maps command words to Command objects
public class CommandFactory {

    private final Map<String, Command> commands = new HashMap<>();
    private final Command unknown = new UnknownCommand();

    public CommandFactory() {
        commands.put("SET", new SetCommand());
        commands.put("GET", new GetCommand());
        commands.put("DEL", new DelCommand());
        commands.put("HELP", new HelpCommand());
        commands.put("EXIT", new ExitCommand());
        commands.put("SIZE", new SizeCommand());
    }

    // Returns the Command for the given word
    public Command create(String commandWord) {
        return commands.getOrDefault(commandWord.toUpperCase(), unknown);
    }
}