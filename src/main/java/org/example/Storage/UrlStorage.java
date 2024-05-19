package org.example.Storage;

import org.example.UrlFrontier;

import java.util.HashMap;
import java.util.Map;

public class UrlStorage implements  Storage{

    Map< String , String > urlMap;

    public UrlStorage(){
        urlMap = new HashMap<>();
    }
    @Override
    public boolean isKeyPresent(String key) {
        return urlMap.containsKey(key);
    }

    @Override
    public void addKey(String key , String value) {
        urlMap.putIfAbsent(key , value);


    }
}
