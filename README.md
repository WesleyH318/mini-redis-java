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
- **Command pattern**: each verb is its own class implementing
  `Command.execute(store, args)` and has `UnknownCommand` as the fallback
- **Factory pattern**:`CommandFactory` maps command words to Command objects, replacing the original switch
  statement in `Repl`
- Adding a new command now means one new class + one registry line:
  the Repl itself never changes (open/closed principle). `SizeCommand`
  was added this way as a demonstration.

## Planned Final Submission

By the final, I plan to demo a working REPL where a user can store,
retrieve, and delete key-value pairs, with the internals refactored to
showcase object-oriented design patterns such as Command and Factory pattern.

## Libraries

- Java standard library (HashMap, Scanner)
- JUnit (planned for testing in a later sprint)