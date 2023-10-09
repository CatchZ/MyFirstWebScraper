import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World");

        // initializing the HTML Document page variable
        Document doc;

        try {
            // fetching the target website
            doc = Jsoup.connect("https://scrapeme.live/shop")
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36") // befüllt den Header der Nachricht
                    .header("Accept-Language", "*")
                    .get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        /*The Jsoup select() function apply the CSS selector strategy to retrieve all li.product on the web page. In details, Elements extends an ArrayList. So, you can easily iterate over it.*/
        Elements products = doc.select("li.product");

        //list that will hold the product Data
        List<PokemonProduct> pokemonProducts = new ArrayList<>();

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

        System.out.println(pokemonProducts);
    }
}