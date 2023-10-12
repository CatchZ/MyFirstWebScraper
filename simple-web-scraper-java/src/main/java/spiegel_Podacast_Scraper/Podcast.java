package spiegel_Podacast_Scraper;

import java.util.LinkedList;

public class Podcast {
    String Titel;
    LinkedList<Episode> Episodes;

    public String getTitel() {
        return Titel;
    }

    public LinkedList<Episode> getEpisodes() {
        return Episodes;
    }



    public Podcast(String titel, LinkedList<Episode> episodes) {
        Titel = titel;
        Episodes = episodes;
    }
}
