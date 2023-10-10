package spiegel_Podacast_Scraper;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SpiegelPodcastScrapper {
    private static final String URL = "https://www.spiegel.de/audio/";

    public static void spiegelPodcastScrapper() {
        Document doc;

        try {
            // fetching the target website
            doc = Jsoup
                    .connect(URL)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/107.0.0.0 Safari/537.36")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements h1 = doc.select("h1");
        System.out.println(h1);
    }


}