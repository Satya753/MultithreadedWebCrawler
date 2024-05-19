package org.example;

import java.io.FileNotFoundException;
import java.util.List;

public interface Parser {

    public List< String > getUrls(String urls , String baseUrl) throws FileNotFoundException;
}
