package simple_web_scraper;

public class PokemonProduct {
    //alle Datenfelder die Gespeichert werden sollen
    private String url;
    private String image;
    private String name;
    private String price;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


        // getters and setters omitted for brevity...

        @Override
        public String toString() {
            return "{ \"url\":\"" + url + "\", "
                    + " \"image\": \"" + image + "\", "
                    + "\"name\":\"" + name + "\", "
                    + "\"price\": \"" + price + "\" }";
        }

}
