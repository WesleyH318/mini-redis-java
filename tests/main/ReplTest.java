package main;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import main.commands.CommandFactory;

import static org.junit.jupiter.api.Assertions.*;

public class ReplTest {

    // Runs a full scripted session and returns everything the Repl printed.
    private String runSession(String scriptedInput) {
        InputStream in = new ByteArrayInputStream(
                scriptedInput.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream captured = new ByteArrayOutputStream();
        Repl repl = new Repl(new MapStore(), new CommandFactory(),
                in, new PrintStream(captured));
        repl.run();
        return captured.toString();
    }

    @Test
    void setThenGetRoundTrip() {
        String out = runSession("SET name wesley\nGET name\nEXIT\n");
        assertTrue(out.contains("OK"));
        assertTrue(out.contains("wesley"));
        assertTrue(out.contains("bye"));
    }

    @Test
    void unknownCommandIsReported() {
        String out = runSession("BOGUS\nEXIT\n");
        assertTrue(out.contains("unknown command"));
    }

    @Test
    void emptyLinesAreSkipped() {
        String out = runSession("\n\nSIZE\nEXIT\n");
        assertTrue(out.contains("0"));
        assertTrue(out.contains("bye"));
    }

    @Test
    void endOfInputEndsLoopWithoutExit() {
        // no EXIT command; input just ends
        String out = runSession("SET a 1\n");
        assertTrue(out.contains("OK"));
        assertFalse(out.contains("bye"));
    }
}