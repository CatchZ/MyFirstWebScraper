import spiegel_Podacast_Scraper.*;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
     final String SPIEGEL_AUDIO_URL = "https://www.spiegel.de/audio/";
    //   Simple_Web_Scraper.web_Scraper();
       System.out.println( SpiegelPodcastScrapper.spiegelPodcastSelector(
               SpiegelPodcastScrapper.getDocumentOfURl(SPIEGEL_AUDIO_URL)
       ));
    System.out.println(
            SpiegelPodcastScrapper.generateSpiegelPodcastUrlList(
                    SpiegelPodcastScrapper.spiegelPodcastSelector(
                            SpiegelPodcastScrapper.getDocumentOfURl(SPIEGEL_AUDIO_URL)
                    )
            )
    );

        LinkedList<Podcast>PodcastList= SpiegelPodcastScrapper.getAllSpiegelPodcasts();
        PodcastList.forEach(
                    e->{System.out.println("Titel: "+e.getTitel()+"\n Episodes:");
                    e.getEpisodes().forEach(e2->System.out.println(e2.getTitel()));}
        );
        LinkedList<Episode> EpisodeList = SpiegelPodcastScrapper.getAllEpisodesOFPodcast("https://www.spiegel.de/thema/im-verhoer/");
        //EpisodeList.forEach(e->System.out.println(e.getTitel()));

    }


}