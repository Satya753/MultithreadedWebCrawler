package org.example;

import org.example.Utility.HashGenerator;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HtmlDownloader htmlDownloader = new HtmlDownloader();
        String baseUrl = "https://jsoup.org/cookbook/extracting-data/example-list-links";
        String fileName = htmlDownloader.getDownloadedFile("https://jsoup.org/cookbook/extracting-data/example-list-links");
        HtmlParser htmlParser = new HtmlParser();

        List< String > listOfUrl = htmlParser.getUrls(fileName ,baseUrl);
        List < Node > seedUrl = new LinkedList<>();
        seedUrl.add(new Node(baseUrl , HashGenerator.generateHash62Version(baseUrl)+".html"));

        Crawler  crawler = new Crawler(seedUrl);
        for (int i = 0 ; i < 2 ; i++) {
            crawler.startCrawl();
            System.out.println("Staring iteration" + i);
        }


    }
}