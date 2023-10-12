import spiegel_Podacast_Scraper.*;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        LinkedList<Podcast>PodcastList= SpiegelPodcastScrapper.getAllSpiegelPodcasts();
        PodcastList.forEach(
                    e->{System.out.println("Titel: "+e.getTitel()+"\nEpisodes:");
                    e.getEpisodes().forEach(e2->System.out.println(e2.getTitel()));}
        );
        LinkedList<Episode> EpisodeList = SpiegelPodcastScrapper.getAllEpisodesOFPodcast("https://www.spiegel.de/thema/im-verhoer/");

    }


}