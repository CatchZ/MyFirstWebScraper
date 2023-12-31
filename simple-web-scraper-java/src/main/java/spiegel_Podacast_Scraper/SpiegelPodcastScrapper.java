package spiegel_Podacast_Scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;

public class SpiegelPodcastScrapper {

    private static final String PODCASTTITELSELECTOR = "a.group.block.text-black";
    private static final String SPIEGEL_AUDIO_URL = "https://www.spiegel.de/audio/";



    private static Document getDocumentOfURl(String url) {
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

     private static Elements spiegelPodcastSelector(Document document){
        return document.select( PODCASTTITELSELECTOR);
    }
@Deprecated
    private static LinkedList<String> generateSpiegelPodcastUrlList(Elements podcastElements){
        LinkedList <String> resultList = new LinkedList<>();
        for(Element podcastElement : podcastElements){
            resultList.add(podcastElement.attr("href"));
        }
        resultList.forEach(e->System.out.println(e));
        return resultList;
    }

    public static LinkedList<Podcast> getAllSpiegelPodcasts(){
        Document spiegelDocument = getDocumentOfURl(SPIEGEL_AUDIO_URL);
        Elements podcastElements = spiegelPodcastSelector(spiegelDocument);
        LinkedList<Podcast> resultList = new LinkedList<>();
        for(Element podcastElement:podcastElements){
            resultList.add(
                    new Podcast(
                            podcastElement.attr("title"),
                            getAllEpisodesOFPodcast(podcastElement.attr("href"))
                    )
            );
        }
        return resultList;
    }

    public static LinkedList<Episode>getAllEpisodesOFPodcast(String episodesURl){
        Document episodesDocument = getDocumentOfURl(episodesURl);
        Elements episodeElements = episodesDocument.select("article");
        LinkedList<Episode> resultList = new LinkedList<>();
        for(Element podcastElement:episodeElements){
            resultList.add(new Episode(podcastElement.attr("aria-label")));
        }
        return  resultList;
    }



}