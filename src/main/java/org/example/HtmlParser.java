package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HtmlParser implements Parser {

    public String content;

    @Override
    public List<String> getUrls(String filename , String baseUrl) throws FileNotFoundException {
        List < String > urlList = new ArrayList<>();

        File input = new File(filename);
        Elements links=null;
        try {
            Document doc = Jsoup.parse(input, "UTF-8", baseUrl);
            links = doc.select("a[href]");
        }
        catch(Exception e){
            System.out.println("Exception occuered" + e);
        }


        for (int i = 0 ;i < links.size() ; i++){
            urlList.add(links.get(i).attr("abs:href"));
        }

        return urlList;
    }
}
