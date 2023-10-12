package spiegel_Podacast_Scraper;

import java.util.LinkedList;

public class Podcast {
    String Titel;

    public String getTitel() {
        return Titel;
    }

    public LinkedList<Podcast> getEpisodes() {
        return Episodes;
    }

    LinkedList<Podcast> Episodes;

    public Podcast(String titel, LinkedList<Podcast> episodes) {
        Titel = titel;
        Episodes = episodes;
    }
}
