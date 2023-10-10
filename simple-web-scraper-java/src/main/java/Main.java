import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import  simple_web_scraper.Simple_Web_Scraper;
import spiegel_Podacast_Scraper.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
    //   Simple_Web_Scraper.web_Scraper();
        SpiegelPodcastScrapper.spiegelPodcastScrapper();

    }

}