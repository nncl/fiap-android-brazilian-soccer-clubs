/**
 * Responsável por chamar o serviço
 */

package cauealmeida.com.braziliansoccerclubs.api;

import java.util.List;

import cauealmeida.com.braziliansoccerclubs.models.Team;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by cauealmeida on 11/26/16.
 */

public interface TeamAPI {
    @GET("/nncl/dca25bd7dd6dda23d0e8d8f77b354bc2/raw/2d09c1febd1980e644912e9428000e40cf835932/soccerclubs.json")
    Call<List<Team>> get();
}
