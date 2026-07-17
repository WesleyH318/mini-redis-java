package main;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapStoreTest {

    private Store store;

    @BeforeEach
    void setUp() {
        store = new MapStore();
    }

    @Test
    void getReturnsValueAfterSet() {
        store.set("name", "wesley");
        assertEquals("wesley", store.get("name"));
    }

    @Test
    void getReturnsNullForMissingKey() {
        assertNull(store.get("nope"));
    }

    @Test
    void setOverwritesExistingKey() {
        store.set("k", "v1");
        store.set("k", "v2");
        assertEquals("v2", store.get("k"));
    }

    @Test
    void deleteReturnsTrueForExistingKey() {
        store.set("k", "v");
        assertTrue(store.delete("k"));
        assertNull(store.get("k"));
    }

    @Test
    void deleteReturnsFalseForMissingKey() {
        assertFalse(store.delete("nope"));
    }

    @Test
    void sizeTracksSetAndDelete() {
        assertEquals(0, store.size());
        store.set("a", "1");
        store.set("b", "2");
        assertEquals(2, store.size());
        store.delete("a");
        assertEquals(1, store.size());
    }
}