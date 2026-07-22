package main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoundedStoreTest {

    private Store boundedWith(EvictionPolicy policy, int capacity) {
        return new BoundedStore(new MapStore(), capacity, policy);
    }

    @Test
    void staysUnderCapacityWithoutEviction() {
        Store store = boundedWith(new EvictOldestPolicy(), 3);
        store.set("a", "1");
        store.set("b", "2");
        assertEquals(2, store.size());
        assertEquals("1", store.get("a"));
    }

    @Test
    void evictOldestRemovesFirstInsertedKey() {
        Store store = boundedWith(new EvictOldestPolicy(), 2);
        store.set("a", "1");
        store.set("b", "2");
        store.set("c", "3");
        assertNull(store.get("a"));       // evicted
        assertEquals("2", store.get("b"));
        assertEquals("3", store.get("c"));
        assertEquals(2, store.size());
    }

    @Test
    void overwriteDoesNotTriggerEviction() {
        Store store = boundedWith(new EvictOldestPolicy(), 2);
        store.set("a", "1");
        store.set("b", "2");
        store.set("a", "99");             // overwrite, store is full
        assertEquals("99", store.get("a"));
        assertEquals("2", store.get("b")); // nothing evicted
        assertEquals(2, store.size());
    }

    @Test
    void rejectWritesKeepsExistingKeysWhenFull() {
        Store store = boundedWith(new RejectWritesPolicy(), 2);
        store.set("a", "1");
        store.set("b", "2");
        store.set("c", "3");              // rejected
        assertNull(store.get("c"));
        assertEquals("1", store.get("a"));
        assertEquals(2, store.size());
    }

    @Test
    void rejectWritesStillAllowsOverwrites() {
        Store store = boundedWith(new RejectWritesPolicy(), 2);
        store.set("a", "1");
        store.set("b", "2");
        store.set("a", "99");
        assertEquals("99", store.get("a"));
    }

    @Test
    void deleteFreesCapacityForNewKeys() {
        Store store = boundedWith(new RejectWritesPolicy(), 2);
        store.set("a", "1");
        store.set("b", "2");
        assertTrue(store.delete("a"));
        store.set("c", "3");              // fits now
        assertEquals("3", store.get("c"));
        assertEquals(2, store.size());
    }
}