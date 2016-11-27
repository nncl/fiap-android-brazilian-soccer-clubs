package cauealmeida.com.braziliansoccerclubs.constants;

/**
 * Created by cauealmeida on 11/26/16.
 */

public enum Constants {
    APIURL("https://gist.githubusercontent.com");

    private final String url;

    private Constants(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
