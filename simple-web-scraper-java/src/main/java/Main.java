import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // initializing the HTML Document page variable
        Document doc;

        try {
            // fetching the target website
            doc = Jsoup.connect("https://scrapeme.live/shop").get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}