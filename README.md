# mini-redis-java
A single-node, in-memory key-value store inspired by Redis, built in Java to demonstrate object-oriented design patterns.

## Sprint 1 Checklist

- **Are you in a group?** No (working solo)
- **If so, who else is in your group?** N/A
- **Do you have your GitHub account set up?** Yes
- **Do you have a public repository for your project?** Yes
- **Link to your GitHub repository:** https://github.com/WesleyH318/mini-redis-java
- **If in a group, does everyone have write access?** N/A
- **Do you have a "Hello World" program that compiles and runs?** Yes
- **Where is the entry point to your project?** ``src/main/Main.java``

## Sprint 2 Scaffolding

- `Store` interface (the key value contract)
- `MapStore` HashMap backed implementation
- `Repl` skeleton wired into Main
- `Main` wires a MapStore into the Repl and runs it

## Sprint 3 Design Patterns

- Full REPL command loop (SET / GET / DEL / SIZE / HELP / EXIT)
  **1. Command pattern** — UML: [`command-pattern.png`](command-pattern.png)

- Interface: `Command` (`execute(store, args)`)
- Concrete commands: `SetCommand`, `GetCommand`, `DelCommand`, `SizeCommand`, `HelpCommand`, `ExitCommand`, `UnknownCommand`
- Invoker: `Repl`; Receiver: `Store` / `MapStore`

Each verb is its own class. Commands return strings instead of printing,
so they can be unit tested without capturing console output.

**2. Simple Factory (registry-based)** — UML: [`simple-factory.png`](simple-factory.png)

- Factory: `CommandFactory` (`create(commandWord)`), with `UnknownCommand` as the `getOrDefault` fallback
- Client: `Repl`

`CommandFactory` maps command words to Command objects, replacing the
original switch statement in `Repl`. Adding a new command now means one
new class + one registry line — the Repl never changes (open/closed
principle). `SizeCommand` was added this way as a demonstration.

### Problems implementing the patterns

- **EXIT bypassed the Command abstraction at first** — it was special-cased
  in the Repl loop. Fixed by making `ExitCommand` a real Command that
  returns a sentinel (`EXIT_SIGNAL`) the Repl checks to stop.
- **Misnamed the factory** — I originally called it Factory Method; a code
  review pointed out that's a different GoF pattern (subclassed creators).
  Renamed to Simple Factory in the README, UML, and code comment.

## Planned Final Submission

By the final, I plan to demo a working REPL where a user can store,
retrieve, and delete key-value pairs, with the internals refactored to
showcase object-oriented design patterns such as Command and Factory pattern.

## Libraries

- Java standard library (HashMap, Scanner)
- JUnit (planned for testing in a later sprint)