package spiegel_Podacast_Scraper;

public class DatabaseController {
    private final String URL = "jdbc:postgresql://localhost/myDB";
    private final String USER = "postgres";
    private final String PASSWORD = "root";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" +
            "  (episode, Podcast) VALUES " +
            " (?, ?);";
}
