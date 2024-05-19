package org.example;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class UrlFrontier {

    Queue< Node > queueUrl;

    public UrlFrontier(List< Node > seedUrls){
        queueUrl = new LinkedList<>();
        for (Node node : seedUrls){
            queueUrl.offer(node);
        }
    }

    public void addUrl(Node node){
        queueUrl.add(node);
    }

    public  Node removeFrontUrl(){
        Node node = queueUrl.poll();
        return node;
    }

    public boolean isEmpty(){
        return queueUrl.isEmpty();
    }
}
