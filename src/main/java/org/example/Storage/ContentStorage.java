package org.example.Storage;

import java.util.HashMap;
import java.util.Map;

public class ContentStorage  implements  Storage{

    Map< String , String > htmlHashContent;

    public ContentStorage(){
        htmlHashContent = new HashMap<>();
    }
    @Override
    public boolean isKeyPresent(String key) {
        return htmlHashContent.containsKey(key);
    }

    @Override
    public void addKey(String key , String value) {
        htmlHashContent.putIfAbsent(key , value);
    }
}
