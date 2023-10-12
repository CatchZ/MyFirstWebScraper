package spiegel_Podacast_Scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class SpiegelPodcastScrapper {

    private static final String PODCASTTITELSELECTOR = "a.group.block.text-black";



    public static Document getDocumentOfURl(String url) {
     Document document ;
        try {
            // fetching the target website
            document = Jsoup
                    .connect(url)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return document;
    }

    public static Elements spiegelPodcastSelector(Document document){
        return document.select( PODCASTTITELSELECTOR);
    }

    public static LinkedList<String> generateSpiegelPodcastUrlList(Elements podcastElements){
        LinkedList <String> resultList = new LinkedList<>();
        for(Element podcastElement : podcastElements){
            resultList.add(podcastElement.attr("href"));
        }
        resultList.forEach(e->System.out.println(e));
        return resultList;
    }



}