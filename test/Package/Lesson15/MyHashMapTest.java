package Package.Lesson15;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

    @Test
    void size() {
        MyHashMap myHashMap = new MyHashMap();
        assertEquals(0, myHashMap.size());
        myHashMap.put("google.com", "172.217.16.14");
        assertEquals(1, myHashMap.size());
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
        assertEquals(3, myHashMap.size());
    }

    @Test
    void isEmpty() {
        MyHashMap myHashMap = new MyHashMap();
        assertTrue(myHashMap.isEmpty());
        myHashMap.put("google.com", "172.217.16.14");
        assertFalse(myHashMap.isEmpty());
    }

    @Test
    void containsKey() {
        MyHashMap myHashMap = new MyHashMap();
        assertFalse(myHashMap.containsKey("google.com"));
        myHashMap.put("google.com", "172.217.16.14");
        assertTrue(myHashMap.containsKey("google.com"));
    }

    @Test
    void containsValue() {
        MyHashMap myHashMap = new MyHashMap();
        assertFalse(myHashMap.containsValue("172.217.16.14"));
        myHashMap.put("google.com", "172.217.16.14");
        assertTrue(myHashMap.containsValue("172.217.16.14"));
    }

    @Test
    void get() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        assertEquals("172.217.16.14", myHashMap.get("google.com"));
    }

    @Test
    void put() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("google.com", "172.217.16.15");
        assertTrue(myHashMap.containsKey("google.com"));
        assertEquals("172.217.16.15", myHashMap.get("google.com"));
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
    }

    @Test
    void remove() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        assertTrue(myHashMap.containsKey("google.com"));
        myHashMap.remove("google.com");
        assertFalse(myHashMap.containsKey("google.com"));
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("dou.ua", "178.78.140.30");
        assertTrue(myHashMap.containsKey("google.com"));
        myHashMap.remove("google.com");
        assertFalse(myHashMap.containsKey("google.com"));
    }

    @Test
    void putAll() {
        MyHashMap myHashMapToBeAdded = new MyHashMap();
        myHashMapToBeAdded.put("google.com", "172.217.16.14");
        myHashMapToBeAdded.put("dou.ua", "178.78.140.30");
        MyHashMap myHashMapToAdd = new MyHashMap();
        myHashMapToAdd.put("youtube.com", "172.217.20.174");
        myHashMapToAdd.putAll(myHashMapToBeAdded);

        assertTrue(myHashMapToAdd.containsKey("google.com"));
        assertTrue(myHashMapToAdd.containsKey("dou.ua"));
        assertTrue(myHashMapToAdd.containsKey("youtube.com"));
    }

    @Test
    void clear() {
        MyHashMap myHashMap = new MyHashMap();
        assertEquals(0, myHashMap.size());
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
        assertEquals(3, myHashMap.size());
        assertTrue(myHashMap.containsKey("youtube.com"));
        assertTrue(myHashMap.containsKey("google.com"));
        assertTrue(myHashMap.containsKey("dou.ua"));
        myHashMap.clear();
        assertFalse(myHashMap.containsKey("youtube.com"));
        assertFalse(myHashMap.containsKey("google.com"));
        assertFalse(myHashMap.containsKey("dou.ua"));
        assertEquals(0, myHashMap.size());
    }

    @Test
    void keySet() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
        Set keySet = myHashMap.keySet();
        assertTrue(keySet.contains("google.com"));
        assertTrue(keySet.contains("dou.ua"));
        assertTrue(keySet.contains("youtube.com"));
    }

    @Test
    void values() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
        Collection values = myHashMap.values();
        assertTrue(values.contains("172.217.16.14"));
        assertTrue(values.contains("178.78.140.30"));
        assertTrue(values.contains("172.217.20.174"));
    }

    @Test
    void entrySet() {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put("google.com", "172.217.16.14");
        myHashMap.put("dou.ua", "178.78.140.30");
        myHashMap.put("youtube.com", "172.217.20.174");
        Set entrySet = myHashMap.entrySet();
        assertTrue(entrySet.contains("172.217.16.14"));
        assertTrue(entrySet.contains("178.78.140.30"));
        assertTrue(entrySet.contains("172.217.20.174"));
    }
}