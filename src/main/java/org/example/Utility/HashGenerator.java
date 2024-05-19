package org.example.Utility;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class HashGenerator {


    public static String generateHash62Version(String url){
        String shortUrl = UUID.nameUUIDFromBytes(url.getBytes()).toString();
        return shortUrl;
    }

    public static String generateMD5HashofHTMLFile(String filename){

        try(InputStream is  = Files.newInputStream(Paths.get(filename))){
            String digest  = DigestUtils.md5Hex(is);
            return digest;
        }
        catch (Exception e){
            System.out.println("Exception Occured while processing the file");

        }

        return "error";

    }
}
