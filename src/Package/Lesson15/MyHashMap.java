package Package.Lesson15;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MyHashMap implements Map {

    private static final int NUM_BUCKETS = 2;
    private Entry[] data = new Entry[NUM_BUCKETS];

    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        int index = getIndex(key);
        if(data[index] != null){
            Entry current = data[index];
            while (current != null){
                if(current.key.equals(key)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        for (Entry entry: data) {
            Entry current = entry;
            while (current != null){
                if(current.value.equals(value)){
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        int index = getIndex(key);
        if(data[index] != null){
            Entry current = data[index];
            while (current != null){
                if(current.key.equals(key)){
                    return current.value;
                }
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public Object put(Object key, Object value) {
        int index = getIndex(key);
        if(data[index] == null){
            data[index] = new Entry(null, key, value);
        } else {
            Entry current = data[index];
            while (current != null){
                if(current.key.equals(key)){
                    Object previousValue = current.value;
                    current.value = value;
                    return previousValue;
                }
                current = current.next;
            }
            data[index] = new Entry(data[index], key, value);
        }
        size++;
        return null;
    }

    @Override
    public Object remove(Object key) {
        int index = getIndex(key);
        if(data[index] == null){
            return null;
        } else {
            Entry previous = null;
            Entry current = data[index];
            while (current != null){
                if(current.key.equals(key)){
                    Object deletedValue = current.value;
                    if(previous == null){
                        data[index] = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    size--;
                    return deletedValue;
                }
                previous = current;
                current = current.next;
            }
        }
        return null;
    }

    @Override
    public void putAll(Map map) {
        Set keySet = map.keySet();
        for (Object key: keySet) {
            put(key, map.get(key));
        }
    }

    @Override
    public void clear() {
        data = new Entry[NUM_BUCKETS];
        size = 0;
    }

    @Override
    public Set keySet() {
        Set returnSet = new HashSet();
        for (Entry entry: data) {
            Entry current = entry;
            while (current != null){
                returnSet.add(current.key);
                current = current.next;
            }
        }
        return returnSet;
    }

    @Override
    public Collection values() {
        return entrySet();
    }

    @Override
    public Set entrySet() {
        Set returnSet = new HashSet();
        for (Entry entry: data) {
            Entry current = entry;
            while (current != null){
                returnSet.add(current.value);
                current = current.next;
            }
        }
        return returnSet;
    }

    private int getIndex(Object key){
        return Math.abs(key.hashCode() % NUM_BUCKETS);
    }

    private static class Entry{
        public Entry(Entry next, Object key, Object value) {
            this.next = next;
            this.key = key;
            this.value = value;
        }

        Entry next;
        Object key;
        Object value;
    }
}
