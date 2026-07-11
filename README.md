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
- `Repl` skeleton wired into Main: *full command loop in progress*
- `Main` wires a MapStore into the Repl and runs it

## Planned Final Submission

By the final, I plan to demo a working REPL where a user can store,
retrieve, and delete key-value pairs, with the internals refactored to
showcase object-oriented design patterns such as Command and Factory Method.

## Libraries

- Java standard library (HashMap, Scanner)
- JUnit (planned for testing in a later sprint)