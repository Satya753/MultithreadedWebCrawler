package org.example;

import org.example.Storage.ContentStorage;
import org.example.Storage.UrlStorage;
import org.example.Utility.HashGenerator;

import java.util.Collections;
import java.util.List;

public class Crawler {

    public HtmlDownloader htmlDownloader;
    public HtmlParser htmlParser;
    public UrlFrontier urlFrontier;
    public ContentStorage contentStorage;
    public UrlStorage urlStorage;


    public Crawler(List< Node > seedUrl){
        htmlDownloader = new HtmlDownloader();
        urlFrontier = new UrlFrontier(seedUrl);
        htmlParser = new HtmlParser();
        contentStorage = new ContentStorage();
        urlStorage = new UrlStorage();
    }


    public void startCrawl(){
        if (!urlFrontier.isEmpty()){
            Node node = urlFrontier.removeFrontUrl();
            String fileName = htmlDownloader.getDownloadedFile(node.url);
            String md5HashValue = HashGenerator.generateMD5HashofHTMLFile(fileName);
            if (contentStorage.isKeyPresent(md5HashValue))
                return ;

            contentStorage.addKey(md5HashValue , node.fileName);
            System.out.println(node.fileName  +" " + node.url);

            try {
                List<String> childLinks = htmlParser.getUrls(node.fileName , node.url);
                addChildLinkToUrlFrontier(childLinks);
            }
            catch (Exception e){
                System.out.println("Error occured in processing the link extractor" + e);
            }
        }
        else{
            System.out.println("No url to process");
        }
    }

    private void addChildLinkToUrlFrontier(List < String > childLinks){
       for (String url : childLinks){
           String hashUrl = HashGenerator.generateHash62Version(url);
           if (urlStorage.isKeyPresent(hashUrl))
               continue;
           System.out.println(url);
           urlStorage.addKey(hashUrl , url);
           urlFrontier.addUrl(new Node(url , hashUrl+".html"));
       }
    }


}
