package exercise4;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        String rootUrl = "http://wiadomosci.gazeta.pl/";
        String wordToFound = "policja";
        Integer numberOfWords = 0;

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        WebCrawlingTask webCrawlingTask = new WebCrawlingTask(rootUrl,wordToFound);
        numberOfWords = forkJoinPool.invoke(webCrawlingTask);

        System.out.printf("Number of words '%s': %d", wordToFound, numberOfWords);
    }
}
