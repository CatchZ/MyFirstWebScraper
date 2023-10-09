import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void scrapeProductPage(
            List<PokemonProduct> pokemonProducts,
            Set<String> pagesDiscovered,
            List<String> pagesToScrape
    ) {
        // the current web page is about to be scraped and
        // should no longer be part of the scraping queue
        String url = pagesToScrape.remove(0);

        pagesDiscovered.add(url);

        // initializing the HTML Document page variable
        Document doc;

        try {
            // fetching the target website
            doc = Jsoup
                    .connect("https://scrapeme.live/shop")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36") // befüllt den Header der Nachricht
                    .header("Accept-Language", "*")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*The Jsoup select() function apply the CSS selector strategy to retrieve all li.product on the web page. In details, Elements extends an ArrayList. So, you can easily iterate over it.*/
        Elements products = doc.select("li.product");




        // Datatypeof List Element list Element : target List
        for (Element product : products) {

            PokemonProduct pokemonProduct = new PokemonProduct();

            // extracting the data of interest from the product HTML element
            // and storing it in pokemonProduct
            pokemonProduct.setUrl(product.selectFirst("a").attr("href"));
            pokemonProduct.setImage(product.selectFirst("img").attr("src"));
            pokemonProduct.setName(product.selectFirst("h2").text());
            pokemonProduct.setPrice(product.selectFirst("span").text());

            // adding pokemonProduct to the list of the scraped products
            pokemonProducts.add(pokemonProduct);

        }
        Elements paginationElements = doc.select("a.page-numbers");


        // iterating over the pagination HTML elements
        for (Element pageElement:paginationElements) {
            // the new link discovered
            String pageUrl = pageElement.attr("href");

            // if the web page discovered is new and should be scraped
            if (!pagesDiscovered.contains(pageUrl) && !pagesToScrape.contains(pageUrl)) {
                pagesToScrape.add(pageUrl);
            }

            // adding the link just discovered
            // to the set of pages discovered so far
            pagesDiscovered.add(pageUrl);
        }
    }

    public static void main(String[] args) {
        // initializing the list of Java object to store
        // the scraped data
        List<PokemonProduct> pokemonProducts = new ArrayList<>();

        // initializing the set of web page urls
        // discovered while crawling the target website
        Set<String> pagesDiscovered = new HashSet<>();

        // initializing the queue of urls to scrape
        List<String> pagesToScrape = new ArrayList<>();
        // initializing the scraping queue with the
        // first pagination page
        pagesToScrape.add("https://scrapeme.live/shop/page/1/");

        // the number of iteration executed
        int i = 0;
        // to limit the number to scrape to 5
        int limit = 48;

        while (!pagesToScrape.isEmpty() && i < limit) {
            scrapeProductPage(pokemonProducts, pagesDiscovered, pagesToScrape);
            // incrementing the iteration number
            i++;
        }
        System.out.println(pokemonProducts.size());


        // writing the scraped data to a db or export it to a file...
    }

}