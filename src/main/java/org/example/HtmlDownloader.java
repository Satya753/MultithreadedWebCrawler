package org.example;

import org.example.Utility.HashGenerator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class HtmlDownloader implements Downloader {


    @Override
    public String getDownloadedFile(String web_url) {
        String fileName = HashGenerator.generateHash62Version(web_url) +".html";
        try {
            URL url = new URL(web_url);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            String line;
            while((line = reader.readLine())!=null){
                writer.write(line);
            }
            reader.close();
            writer.close();
        }
        catch(Exception e){
            System.out.println(e + "Malformed webpage found");
        }


        return fileName;

    }
}
