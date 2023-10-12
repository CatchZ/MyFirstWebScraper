import spiegel_Podacast_Scraper.*;

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


    }

}