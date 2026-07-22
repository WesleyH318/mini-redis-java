package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class LoggingStoreTest {

    private ByteArrayOutputStream logCapture;
    private Store inner;
    private Store store;

    @BeforeEach
    void setUp() {
        logCapture = new ByteArrayOutputStream();
        inner = new MapStore();
        store = new LoggingStore(inner, new PrintStream(logCapture));
    }

    private String log() {
        return logCapture.toString();
    }

    @Test
    void setLogsAndDelegates() {
        store.set("k", "v");
        assertTrue(log().contains("[log] SET k"));
        assertEquals("v", inner.get("k"));
    }

    @Test
    void getLogsAndReturnsInnerValue() {
        inner.set("k", "v");
        assertEquals("v", store.get("k"));
        assertTrue(log().contains("[log] GET k"));
    }

    @Test
    void deleteLogsAndDelegates() {
        inner.set("k", "v");
        assertTrue(store.delete("k"));
        assertTrue(log().contains("[log] DEL k"));
        assertNull(inner.get("k"));
    }

    @Test
    void deleteReturnsFalseForMissingKey() {
        assertFalse(store.delete("nope"));
        assertTrue(log().contains("[log] DEL nope"));
    }

    @Test
    void sizeLogsAndDelegates() {
        inner.set("a", "1");
        assertEquals(1, store.size());
        assertTrue(log().contains("[log] SIZE"));
    }
}