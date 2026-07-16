package main;

import java.util.HashMap;
import java.util.Map;

// In-memory Store implementation using HashMap
public class MapStore implements Store {

    private final Map<String, String> data = new HashMap<>();

    @Override
    public void set(String key, String value){
        data.put(key, value);
    }

    @Override
    public String get(String key){
        return data.get(key);
    }

    @Override
    public boolean delete(String key){
        return data.remove(key) != null;
    }

    @Override
    public int size(){
        return data.size();
    }
}
